/* Purpose: Inserting data into table Objects in the database Northwind22H1
Script Date: June 21, 2022
Developed by: Khattar Daou
*/

/* add a statement that specifies the script
runs in the context of the master database */

-- switch to the Northwind database
-- SSyntax: use database_name
use Safeway22H2
;
go -- includes end of the batch marker


/* 1. using insert clause 
Syntax: 
insert [into] schema_name.table_name [(column_list)]
values (value1, value2, ...)
;
go
*/

insert into HumanResources.Employees (FirstName, LastName, Birthdate, HireDate, Address, City, Region, PostalCode, Country, HomePhone)
values('John', 'Smith', '5/21/1999', '8/12/2018', 'some address', 'some city', 'some region', 'zipcode', 'some country', '(514) 555-5555')
;
go

select *
from HumanResources.Employees
;
go

/* add a new column named Email into table Employees  */
alter table HumanResources.Employees
	add Email nvarchar(60) null
;
go

update HumanResources.Employees
	set Email = 'john.smith@smith.com'
where EmployeeID = 1
;
go

alter table HumanResources.Employees
	alter column Email nvarchar(60) not null
;
go

insert into Sales.customers (
	CustomerID, CompanyName, Address, City, Region, PostalCode, Country, Phone, Email)
values
('AROUT','Around the Horn','120 Hanover Sq.', 'London', 'N/A', 'WA1 1DP', 'UK','(171) 555-7788', 'info@arout.co.uk'),
('BLONP','Blondel p?re et fils', '24, place Kl?ber', 'Strasbourg','N/A', '67000','France','88.60.15.31', 'info@blonp.fr'),
('BONAP','Bon app','12, rue des Bouchers','Marseille', 'N/A','13008','France','91.24.45.40', 'info@bonap.fr')
;
go

select *
from Sales.Customers
;
go

execute sp_help 'Sales.Customers'
;
go

/* change the Fax column name to null */
alter table Sales.Customers
	alter column Fax nvarchar(24) null
;
go

/* 2. using insert clause from another table 
insert [into] schema_name.table_name [(column_list)]
select (column_name_1, column_name_2, ...)
from schema_name.another_table_name
*/

insert into Production.Suppliers (
	CompanyName, Address, City, Region, PostalCode, Country, Phone, Email)
select CompanyName, Address, City, Region, PostalCode, Country, Phone, Email
from Sales.Customers
;
go

select * 
from Production.Suppliers
;
go

/* 3. Using Bulk insert clause
Syntax:
bulk insert schema_name.table_name
from 'path/filename.ext'
with 
(
	FirstRow = number_of_first_row,
	RowTerminator = '\n',
	FieldTerminator = ','
)
*/

select *
from Person.Contacts
;
go


bulk insert Person.Contacts
from 'I:\_data_sources\contacts.txt'
with
(
	FirstRow = 2,
	FieldTerminator = ',',
	RowTerminator = '\n'
)
;
go


/* create a temporary table MyContacts */
create table #MyContacts
(
	ContactID smallint  identity(1, 1) not null,
	FirstName nvarchar(15) not null,
	LastName nvarchar(15) not null,
	SocialNumber nchar(11) not null,
	Address nvarchar(40) not null,
	Region nchar(2) null,
	constraint pk_Contacts primary key clustered (ContactID asc)
)
;
go

/* insert from an external data source */
bulk insert #MyContacts 
from 'I:\_data_sources\contacts.txt'
with
(
	FirstRow = 2,
	FieldTerminator = ',',
	RowTerminator = '\n'
)
;
go
 
select *
from #MyContacts
;
go

