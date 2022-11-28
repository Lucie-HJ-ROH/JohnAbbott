/* Purpose: Creating View Objects in the Safeway22H2 database
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


/* 1. create the contact customer view (Sales.ContactNameView) that contains the contact name and contact title */


if OBJECT_ID('Sales.ContactNameView', 'V') is not null
	drop view Sales.ContactNameView
;
go

create view Sales.ContactNameView
as
	select SC.CustomerID, SC.CompanyName, SC.ContactName, SC.ContactTitle
	from Sales.Customers as SC
;
go

select *
from Sales.Customers
;
go

/* 2. modify the Sales.ContactNameView and add the Phone, and Country */
alter view Sales.ContactNameView
	as
	select SC.CustomerID, SC.CompanyName, SC.ContactName, SC.ContactTitle, Phone, Country
	from Sales.Customers as SC
;
go


/* create the order total view, Sales.OrderTotalView, that returns the sum of each order */
create view Sales.OrderTotalView
as
	select SOD.OrderID, SOD.ProductID,
   convert(smallmoney,	(SOD.UnitPrice * SOD.Quantity)*(1 - SOD.Discount) ) as 'OrderTotal'
	from Sales.[Order Details] as SOD
-- where SOD.OrderID = 10250
;
go

/* 3. return the grand total of all orders placed in 2022. use the Sales.OrderTotalView in your script. */

if OBJECT_ID('Sales.OrderTotalView', 'V') is not null
	drop view Sales.OrderTotalView
;
go

select SC.CompanyName as 'Company', 
		sum(SOT.OrderTotal) as 'Grand Total'
from Sales.OrderTotalView as SOT 
	inner join Sales.Orders as SO
		on SOT.OrderID = SO.OrderID
	inner join Sales.Customers as SC
	on SO.CustomerID = SC.CustomerID
where year(SO.OrderDate) = '2022'
group by SC.CompanyName
;
go

execute sp_depends 'Sales.OrderTotalView'
;
go

