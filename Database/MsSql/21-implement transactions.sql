/* Purpose: Implementing Transactionss in the database Safeway22H2
Script Date: June 27, 2022
Developed by: Khattar Daou
*/

/* add a statement that specifies the script
runs in the context of the Safeway22H2 database */

-- switch to the Safeway22H2 database
-- Syntax: use database_name
use Safeway22H2
;
go -- includes end of the batch marker


/* create a table to support the transaction demo */

/* clean up if the tables already exsists */
if OBJECT_ID('Sales.SimpleOrderDetails', 'U') is not null
	drop table Sales.SimpleOrderDetails
;
go

if OBJECT_ID('Sales.SimpleOrders', 'U') is not null
	drop table Sales.SimpleOrders
;
go


create table Sales.SimpleOrders 
(
	OrderID int identity(1, 1) not null,
	CustomerID nchar(5) not null,
	EmployeeID int not null,
	OrderDate datetime not null,
	constraint pk_SimpleOrders primary key clustered (OrderID asc)	
)
;
go

-- add foreign key constraints to SimpleOrders
alter table Sales.SimpleOrders
	add constraint fk_SimpleOrders_Customers foreign key (CustomerID) references Sales.Customers (CustomerID),
	constraint fk_SimpleOrders_Employees foreign key (EmployeeID) references HumanResources.Employees (EmployeeID)
;
go	


create table Sales.SimpleOrderDetails
(
	OrderID int not null,
	ProductID int not null,
	UnitPrice money not null,
	Quantity smallint not null,
	constraint pk_SimpleOrderDetails primary key clustered (OrderID asc, ProductID asc)
)
;
go

-- add foreign key constraints to SimpleOrderDetails
alter table Sales.SimpleOrderDetails
	add constraint fk_SimpleOrderDetails_SimpleOrders foreign key (OrderID) references Sales.SimpleOrders (OrderID),
	constraint fk_SimpleOrderDetails_Products foreign key (ProductID) references Production.Products (ProductID)
;
go

/*
Business rules might dictate that an order is complete only if the data was successfully inserted into both tables. 
As you will see in the next example, a runtime error in this batch might result in data being inserted into one table but not the other. 
Enclosing both INSERT statements in a user-defined transaction provides the ability to undo the data insertion in one table if the INSERT statement in the other table fails. 
A simple batch does not provide this capability.
*/

/*
SQL Server manages resources on behalf of transactions while the transactions are active. These resources may include locks and entries in the transaction log to allow SQL Server to undo changes made by the transaction should a rollback be required.
*/

-- Bartch without transaction management
begin try
	insert into Sales.SimpleOrders (CustomerID, EmployeeID, OrderDate)
	values ('ALFKI', 1, '2022/06/13');	-- insert succeds

	insert into Sales.SimpleOrders (CustomerID, EmployeeID, OrderDate)
	-- wrong cutomer id | wrong employee id (does not exist)
	values ('ALKKI', 20, '2022/06/13'); -- inser fails

	insert into Sales.SimpleOrderDetails (OrderID, ProductID, UnitPrice, Quantity)
	values (9, 2, 15.59, 20);

	insert into Sales.SimpleOrderDetails (OrderID, ProductID, UnitPrice, Quantity)
	-- order no. 999 does not exist as a primary key value
	-- Product ID 78 dos not exists in Products table
	values (999, 78, 55.59, 2);
end try
begin catch
	-- inserted rows will exist in Sales.Orders table
	select ERROR_NUMBER() as 'Error Number', ERROR_MESSAGE() as 'Error Message'
end catch
;
go

/* 
If the first INSERT statement succeeds but a subsequent INSERT statement fails, the new row in the
Sales.SimpleOrders table will persist after the end of the batch, even after the execution branches to the CATCH block. This issue applies to any successful statements, if a later statement fails with a runtime error.
*/



/* show that even with exception handling, some rows were inserted */
select *
from [Sales].[SimpleOrders]
;
go

select *
from [Sales].[SimpleOrderDetails]
;
go

delete
[Sales].[SimpleOrders]

select *
from [HumanResources].[Employees]
;
go
/* ****************** Transactions Extend Batches ****************** */
 /* To work around this situation, you will need to direct SQL Server to treat the batch as a transaction. 
Transaction commands identify blocks of code that must succeed or fail together and procide points where database engine can roll back, or undo, operations.
*/

/*
As you have seen, runtime errors encountered during the execution of simple batches create the
possibility of partial success, which is not typically a desired outcome. 
To address this, you will add code to identify the batch as a transaction by placing the batch between BEGIN TRANSACTION and COMMIT TRANSACTION statements. 
You will also add error-handling code to roll back the transaction should an error occur. 
This error-handling code will undo the partial changes made before the error occurred.
*/

/* create a transaction to wrap around insertion */
/* NOTE: this script will work with no error */
begin try
	begin transaction 
		insert into Sales.SimpleOrders (CustomerID, EmployeeID, OrderDate)
		values ('ALFKI', 1, '2022/06/13');	-- insert succeds

		insert into Sales.SimpleOrders (CustomerID, EmployeeID, OrderDate)
		-- wrong cutomer id | wrong employee id (does not exist)
		values ('ALKKI', 20, '2022/06/13'); -- inser fails

		insert into Sales.SimpleOrderDetails (OrderID, ProductID, UnitPrice, Quantity)
		values (9, 2, 15.59, 20);

		insert into Sales.SimpleOrderDetails (OrderID, ProductID, UnitPrice, Quantity)
		-- order no. 999 does not exist as a primary key value
		-- Product ID 78 dos not exists in Products table
		values (999, 78, 55.59, 2);
	/* COMMIT 
		Once the statements in your transaction have completed without error, you need to instruct SQL Server to end the transaction, making the modifications permanent and releasing resources that were held on behalf of the transaction.
		? ensures all the transaction's modifications are made a permanent part of the database
		? frees resources, such as locks, used by the transaction
	*/
	commit transaction
end try
begin catch
	-- inserted rows will exist in Sales.Orders table
	select ERROR_NUMBER() as 'Error Number', ERROR_MESSAGE() as 'Error Message'
	/* rollback transaction
		? undoes all modifications made in the transaction by reverting the data to the state it was in at the beginning of the transaction
		? frees resources, such as locks, used by the transaction
	*/
	rollback transaction
	Print '***** Transaction Error - Rolling Back Transaction *****'
end catch
;
go

/*
In order to end a failed transaction, you will use the ROLLBACK command. ROLLBACK undoes any
modifications made to data during the transaction, reverting it to the state it was in when the transaction started. This includes rows inserted, deleted, or updated, as well as objects created. ROLLBACK also allows SQL Server to release resources, such as locks, held during the transaction's lifespan.

If you are using T-SQL structured exception handling, you will want to ROLLBACK the transaction inside the CATCH block that follows the TRY block containing the BEGIN and COMMIT statements.
*/

/* show that even with exception handling, some rows were inserted */
select *
from [Sales].[SimpleOrders]
;
go

select *
from [Sales].[SimpleOrderDetails]
;
go

/* 
Within the TRY block, the INSERT statements are wrapped by BEGIN TRANSACTION and COMMIT
TRANSACTION statements. This identifies the INSERT statements as a single unit of work that must
succeed or fail together. If no runtime error occurs, the transaction commits, and the result of each INSERT is allowed to persist in the database.

If an error occurs during the execution of the first INSERT statement, the execution branches to the CATCH block, bypassing the second INSERT statement. The ROLLBACK statement in the CATCH block
terminates the transaction, releasing its resources.

If an error occurs during the execution of the second INSERT statement, the execution branches to the CATCH block. Because the first INSERT completed successfully and added rows to the Sales.SimpleOrders table, the ROLLBACK statement is used to undo the successful INSERT operation.
*/

--Step 6: Execute with errors in data to test transaction handling
BEGIN TRY
	BEGIN TRANSACTION
		INSERT INTO Sales.SimpleOrders(CustomerID, EmployeeID, OrderDate) 
		VALUES (68,9,'2022/06/13');

		INSERT INTO Sales.SimpleOrderDetails(OrderID, ProductID, UnitPrice, Quantity) 
		VALUES (99, 2,15.20,20);
	COMMIT TRANSACTION
END TRY
BEGIN CATCH
	SELECT ERROR_NUMBER() AS ErrNum, ERROR_MESSAGE() AS ErrMsg;
	ROLLBACK TRANSACTION
	Print '***** Transaction Error - Rolling Back Transaction *****'
END CATCH
;
go
