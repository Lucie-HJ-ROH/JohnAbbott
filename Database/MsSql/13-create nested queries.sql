/* Purpose: Creating Nested Qyeries in the Safeway22H2 database
 in the database Safeway22H2
Script Date: June 22, 2022
Developed by: Khattar Daou
*/

/* add a statement that specifies the script
runs in the context of the master database */

-- switch to the Safeway22H2 database
-- Syntax: use database_name

use Safeway22H2
;
go -- includes end of the batch marker

/* A subquery is a query that is nested inside a SELECT, INSERT, UPDATE, or DELETE statement, or inside another subquery. A subquery can be used anywhere an expression is allowed. 

A subquery is also called an inner query or inner select, while the statement containing a subquery is also called an outer query or outer select.

A subquery nested in the outer SELECT statement has the following components:

A regular SELECT query including the regular select list components.
A regular FROM clause including one or more table or view names.
An optional WHERE clause.
An optional GROUP BY clause.
An optional HAVING clause.

*/


/* a scalar subquery -> a query that returns a single value 
 Multiple-value subquery --> a query that returns a result set much like a single-column table 
*/


/* return the last order placed */
select top 1 SO.OrderID
from Sales.Orders as SO
order by SO.OrderID desc
;
go

-- using max() function
select max(SO.OrderID) as 'Last Order'
from Sales.Orders as SO
;
go

-- get the order from order details table
select max(SOD.OrderID) as 'Last Order'
from Sales.[Order Details] as SOD
;
go

/* return the last order placed with the product id, unit price, and the quantity */
/* NOT AS GOOD RESULT */
select 
	max(SOD.OrderID) as 'Last Order',
	SOD.ProductID as 'Product',
	SOD.UnitPrice as 'Selling Price',
	SOD.Quantity as 'Quantity'
from sales.[Order Details] as SOD
group by 
	SOD.ProductID,
	SOD.UnitPrice,
	SOD.Quantity
;
go

/* return the last order placed using as nested query */
select 
	SOD.OrderID as 'Last Order',
	SOD.ProductID as 'Product',
	SOD.UnitPrice as 'Selling Price',
	SOD.Quantity as 'Quantity'
from sales.[Order Details] as SOD
where SOD.OrderID = 
	( -- nested query
	select max(SO.OrderID) as 'Last Order'
	from Sales.Orders as SO

	)
;
go

select *
from Sales.[Order Details]
where OrderID = 11077
;
go

/* return the list of orders placed by customers from Mexico (Ship Country) */
select SO.CustomerID as 'Customer ID', So.OrderID as 'Order ID'
from Sales.Orders as SO
where SO.ShipCountry = 'Mexico'
;
go

/* return the list of orders placed by customers (Company Name) from Mexico (Ship Country) */
select SC.CompanyName as 'Company Name', So.OrderID as 'Order ID'
from Sales.Orders as SO
	inner join Sales.Customers as SC
		on SO.CustomerID = SC.CustomerID
where SO.ShipCountry = 'Mexico'
;
go

-- using nested query 
select SO.CustomerID as 'Customer ID', So.OrderID as 'Order ID'
from Sales.Orders as SO
where SO.CustomerID in
	(
		select SC.CustomerID
		from Sales.Customers as SC
		where SC.Country = 'Mexico'
	)
;
go

/* Correlated sub-query refers to columns of table used in outer table. Correlated sub-query is used to pass a value from the outer query to the inner query to be used as parameter 
*/

/* return orders with the last order date for each employee */
select
	SO.EmployeeID as 'Employee No.',
	convert(nvarchar(12), SO.OrderDate) as 'Order Date',
	SO.OrderID as 'Order No.'
from Sales.Orders as SO
	inner join HumanResources.Employees as HRE
		on SO.EmployeeID = HRE.EmployeeID
where SO.OrderDate =
	(
		-- return the last order 
		select max(SO2.OrderDate)
		from Sales.Orders as SO2
		where SO2.EmployeeID = SO.EmployeeID
	)
Order by SO.EmployeeID, SO.OrderDate
;
go

select *
from HumanResources.Employees

select * 
from Sales.Orders
where EmployeeID = 10
;
go

/* use the [NOT] [EXSITS] predicate with sub-query to check for any result that returns from a query. EXISTS evaluates whether rows exist, but rather than returns them, it returns true or false
*/

/* return the number of employees who are associated with orders */
select HRE.EmployeeID as 'Employee Number', HRE.LastName as 'Last Name'
from HumanResources.Employees as HRE
where 
	(
		select count(*)
		from Sales.Orders as SO
		where SO.EmployeeID = HRE.EmployeeID
	) > 0
;
go

-- check the required columns
insert into HumanResources.Employees (FirstName, LastName)
values ('John', 'Smith')
;
go

-- using the EXISTS to return the same result 
select HRE.EmployeeID as 'Employee Number', HRE.FirstName as 'First Name', 
HRE.LastName as 'Last Name'
from HumanResources.Employees as HRE
where exists -- not exists
(
		select count(*)
		from Sales.Orders as SO
		where SO.EmployeeID = HRE.EmployeeID
		group by SO.OrderID
)
;
go

-- add yourself as a new employee
insert into HumanResources.Employees (FirstName, LastName)
values ('Khattar', 'Daou')
;
go

/* return any customer (company name) that has never placed an order */
-- use [NOT] EXISTS clause
select SC.CustomerID as 'Customer ID', SC.CompanyName as 'Company Name'
from Sales.Customers as SC
where not exists 
(
	select SO.OrderID
	from Sales.Orders as SO
	where SC.CustomerID = SO.CustomerID
)
;
go

-- same query using outer join
select SC.CustomerID as 'Customer ID', SC.CompanyName as 'Company Name', SO.OrderID
from Sales.Customers as SC
	left outer join Sales.Orders as SO
		on SC.CustomerID = SO.CustomerID
where SO.OrderID is null
;
go

