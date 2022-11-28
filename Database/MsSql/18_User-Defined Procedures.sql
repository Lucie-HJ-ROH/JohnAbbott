/* Purpose: User-Defined Stored Procedures in the Safeway22H2 database
 in the database Safeway22H2
Script Date: June 23, 2022
Developed by: Khattar Daou
*/

/* add a statement that specifies the script
runs in the context of the master database */

-- switch to the Safeway22H2 database
-- Syntax: use database_name

use Safeway22H2
;
go -- includes end of the batch marker


-- Transact-SQL Syntax for Stored Procedures in SQL Server and Azure SQL Database  
  /*
CREATE [ OR ALTER ] { PROC | PROCEDURE } 
    [schema_name.] procedure_name 
    [ { @parameter [ type_schema_name. ] data_type }  ]   

AS 
	{ [ BEGIN ] 
		sql_statement [;] [ ...n ] 
		[ END ] 
	}  
[;]  

*/


/* create a procedure, HumanResources.getAllEmployeesSP, that returns the employee first name, last name, and title
*/
create procedure HumanResources.getAllEmployeesSP
as
	begin
		select FirstName, LastName, Title
		from HumanResources.Employees
	end
;
go

/* call the procedure HumanResources.getAllEmployeesSP */
execute HumanResources.getAllEmployeesSP
;
go

/* create a procedure, HumanResources.getAllEmployeeByNameSP, that returns the employee first name, last name, and title, knowing (having) the employee number */
create procedure HumanResources.getAllEmployeeByNameSP
(
	-- declare a parameter 
	-- SYNTAX: @parameter_name as  data_type [=expression]
	@EmployeeID as int
)
as
	begin
		select FirstName, LastName, Title
		from HumanResources.Employees
		where EmployeeID = @EmployeeID
	end
;
go


/* call the procedure HumanResources.getAllEmployeeByNameSP */
execute HumanResources.getAllEmployeeByNameSP @EmployeeID = 1
;
go


/* create a procedure, HumanResources.getAllEmployeeByTitleSP, that returns the employee full name, phone, and title, knowing the job title */
alter procedure HumanResources.getAllEmployeeByTitleSP
(
	-- decalre parameter
	@Title as nvarchar(30)
)
as
	begin
		select
			concat_ws(', ', LastName, FirstName) as 'FullName',
			Title
		from HumanResources.Employees
		where Title like @Title
	end
;
go

/* call the procedure HumanResources.getAllEmployeeByTitleSP */
execute HumanResources.getAllEmployeeByTitleSP @Title = 'Sales Rep%'
;
go



/*
This procedures returns a list of products that have prices that do not exceed a specified amount. The example shows using multiple SELECT statements and multiple OUTPUT parameters. OUTPUT parameters enable an external procedure, a batch, or more than one Transact-SQL statement to access a value set during the procedure execution.
*/

/* create a procedure, Production.getProductListSP, that returns a list of products with prices that do not exceed a specific amount */
create procedure Production.getProductListSP
(
	-- declare parameters
	@ProductName as nvarchar(40),	-- Product Name
	@MaxPrice as smallmoney,		-- Product maximum price
	@ComparePrice as smallmoney output,
	@ListPrice as smallmoney out -- output
)
as

/* 
	Stops the message that shows the count of the number of rows affected by a Transact-SQL statement or stored procedure from being returned as part of the result set.
	When SET NOCOUNT is ON, the count is not returned. When SET NOCOUNT is OFF, the count is returned.
	*/
	 SET NOCOUNT ON; 

select PP.ProductName as 'Product', SOD.UnitPrice as 'Selling Price'
from Production.Products as PP
		inner join Sales.[Order Details] as SOD
			on PP.ProductID = SOD.ProductID
	where PP.ProductName like @ProductName 
		and
		SOD.UnitPrice < @MaxPrice

	-- populate the output parameters
	set @ListPrice = 
	(
		select max(SOD.UnitPrice) as 'Maximum Price'
		from Production.Products as PP
		inner join Sales.[Order Details] as SOD
			on PP.ProductID = SOD.ProductID
		where SOD.UnitPrice < @MaxPrice
	)

	-- set the @ComparePrice equal to @MaxPrice
	set @ComparePrice = @MaxPrice
;
go

/* testing procedure Production.getProductListSP 
Execute Production.getProductListSP to return a list of products that cost less than $100. The OUTPUT parameters @SellingPrice and @ComparePrice are used with control-of-flow language to return a message in the Messages window.
*/

declare @ComparePrice as smallmoney, @SellingPrice as smallmoney
execute Production.getProductListSP
	'%Mishi%',
	100,
	@ComparePrice output, 
	@SellingPrice output

	if (@SellingPrice <= @ComparePrice)
		begin
		print 'These products can be purshased for less than $' +   
		rtrim(cast(@ComparePrice as nvarchar(20))) + '.'
	end
	else
		begin
			print 'These prices for all products in this list exceed $' +
			rtrim(cast(@ComparePrice as nvarchar(20))) + '.'
		end
;
go

select *
from Production.Products
where ProductName like '%Mishi%'
;
go


