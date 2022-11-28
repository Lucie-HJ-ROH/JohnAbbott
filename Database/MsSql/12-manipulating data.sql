/* Purpose: Manipulate data in the Safeway22H2 database
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


/* Partial syntax:
select <select_list< [ into new_table]
[From object_name]
[Where search_condition]
[Group by group_by_condition]
[Having search_condition]
[Order by oreder_expression [asc] | [desc] ]
*/


/*
The actual physical execution of the statement is determined by the query processor and the order may vary from this list.

1. FROM
2. ON
3. JOIN
4. WHERE
5. GROUP BY
6. WITH CUBE or WITH ROLLUP
7. HAVING
8. SELECT
9. DISTINCT
10. ORDER BY
11. TOP

The preceding sequence is usually true. However, there are uncommon cases where the sequence may differ.

For example, suppose you have a clustered index on a view, and the view excludes some table rows, and the view's SELECT column list uses a CONVERT that changes a data type from varchar to integer. In this situation, the CONVERT may execute before the WHERE clause executes. Uncommon indeed. Often there is a way to modify your view to avoid the different sequence, if it matters in your case.
*/

/* 
1) Read the question
2) find the object(s) - table or a query that answer your question
3) list the column(s) - fields from each object
4) define the criteria(s) 
5) run one criteria after another
*/

/*
Example 1
Find customers in London (UK) with Sales Representative contact title. 
*/
select CustomerID, CompanyName, ContactTitle, City, Country
from sales.Customers
where
	City = 'London'
	and Country = 'UK'
	and ContactTitle = 'Sales Representative'
;
go

/*
Example 2
Suppose that you want to see a list of countries where suppliers are located. You want to arrange the countries alphabetically, and within each country you want to list supplier names alphabetically. 
*/

select Country, CompanyName
from Purchasing.Suppliers
order by Country asc, CompanyName asc
;
go

/*
Example 3
Suppose you want to see the name and location of suppliers from Germany. 
*/
select CompanyName, Address, city, Region, PostalCode, Country
from Purchasing.Suppliers
where Country = 'Germany'
;
go

/*
Example 4
Suppose that you want to display company names of suppliers from Sweden, but you only want to see the company names, not the country, in the result set. 
*/
select CompanyName -- , Country
from Purchasing.Suppliers
where country = 'Sweden'
;
go

/*
Example 5
Suppose that you want to view all the fields in the Order Details table, but you're interested in seeing only those records with an Order ID greater than 11000. 
*/

select *
from Sales.[Order Details]
where OrderID > 11000
;
go

/*
Example 6
Suppose that you want to find employees how are hired between January 1st and March 31st 2021 (first quarter of 2021).   
*/

select EmployeeID, FirstName, LastName
from HumanResources.Employees
where HireDate between '2021/1/1' and '2021/3/31'
-- where HireDate between '1/1/2021' and '3/31/2021'
-- where HireDate between 'January 1, 2021' and '2021/3/31'
;
go

/*
Example 7
Suppose you want to see suppliers from Germany or Canada. 
*/
select SupplierID, CompanyName, Country
from Purchasing.Suppliers
where Country in('Germany', 'Canada')
;
go

/*
Example 8
Suppose you want to see suppliers in either the UK (United Kingdom) or Paris.  
*/
select CompanyName, City, Country
from Purchasing.Suppliers
where Country = 'UK' or City = 'Paris'
;
go

/*
Example 9
Suppose that you want to find suppliers who have a fax number. 
*/
select SupplierID, CompanyName, Fax
from Purchasing.Suppliers
where Fax is not null
;
go

/*
Example 10
Suppose that you want to see customers who are located in Seattle, Kirkland, or Portland. 
*/
select CompanyName, City
from Sales.Customers
where City in('Seattle', 'Kirkland', 'Portland')
;
go

/*
Example 11
Suppose that you want to select a list of countries where suppliers are located.
*/
-- distinct - unique
select distinct Country
from Purchasing.Suppliers
order by Country asc
;
go


/* Example 12
Suppose you remember that a customer's company name starts with 'The', but you can't remember the rest of the name. Find all the company names starting with 'The'. Create this view and save it as 12_vCompanyNameStartingWithThe.
*/

create view oCmpanyNameStartingWithTheView
as
	SELECT C.CompanyName
	FROM Sales.Customers as C
	WHERE C.CompanyName Like 'The%'
;
go


/* Example 13
Create a view that returns the employee id, employee full name, full address, home phone, and extension. Save this view as 13_vEmployeeFullName.
SYNTAX: calculated_field_name:expression
EmployeeName:[First Name] + ' ' + [LastName] as 'Employee'
*/
SELECT E.EmployeeID, (E.FirstName + ', ' + E.LastName) as 'FullName', 
(E.Address + ' ' + E.City + ' ' + E.Region + ' ' + E.PostalCode + ' ' + E.Country) as 'FullAddress', E.HomePhone, E.Extension
FROM HumanResources.Employees as E
;
go


SELECT E.EmployeeID, concat(E.FirstName, ', ', E.LastName) as 'FullName', 
concat(E.Address, ' ', E.City, ' ', E.Region, ' ', E.PostalCode, ' ' + E.Country) as 'FullAddress', E.HomePhone, E.Extension
FROM HumanResources.Employees as E
;
go

-- concat_ws() can be used with SQL Server 2017 and higheer version
SELECT E.EmployeeID, concat_ws(' ', E.FirstName, E.LastName) as 'FullName', 
concat_ws(' ', E.Address, E.City, E.Region, E.PostalCode + E.Country) as 'FullAddress', E.HomePhone, E.Extension
FROM HumanResources.Employees as E
;
go


/*
Example 14
Suppose you want to find out what all your confection products (CategoryID = 3) would cost if you raised price by 25 percent. Add a calculated field and name it NewPrice. Create this view and save it as 14_vNewPriceForConfectionProducts. 
*/


select 
	PP.ProductID, PP.ProductName, PP.UnitPrice,
	(PP.UnitPrice * 1.25) as 'NewPrice'
from Production.Products as PP
where PP.CategoryID = 3
;
go

/* Example 15
Suppose you want to calculate the total number of products. Create this view and save it as 15_vTotalNumberOfProducts. 
*/ 

SELECT Count(P.ProductID) as 'Total Number Of Products'
FROM Production.Products as P
;
go

/*
Example 16
Suppose you want to find the total number of product purchased that come from each supplier (company name). List the highest values first. Create this view and save it as 16_vTotalNumberOfProductsFromEachSupplier. 
*/

select PS.CompanyName, Count(PP.ProductID) AS 'Total Number Of Products'
FROM Purchasing.Suppliers as PS 
	INNER JOIN Production.Products as PP
		ON PS.SupplierID = PP.SupplierID
GROUP BY PS.CompanyName
ORDER BY Count(PP.ProductID) DESC
;
go

/* Example 17
How many products each category (category Name) contains. Create this view and save it as 17_vTotalNumberOfProductsPerCategory.
*/

SELECT PC.CategoryID, PC.CategoryName, Count(PP.ProductID) AS 'Total Number Of Products'
FROM Production.Categories as PC 
	INNER JOIN Production.Products as PP 
		ON PC.CategoryID = PP.CategoryID
GROUP BY PC.CategoryID, PC.CategoryName
;
go


/* Example 18
What is the perecentage of UnitsInStock comparing to UnitsOnOrder. Create this view and save it as 18_vUnitPercentage.
*/

SELECT PP.ProductID, PP.ProductName, PP.UnitsInStock, PP.UnitsOnOrder, 
 [UnitsInStock]/([UnitsInStock]+[UnitsOnOrder]) as 'Percentage' --,
-- cast(round([UnitsInStock]/([UnitsInStock] + [UnitsOnOrder]), 2) as float) AS 'Percentage',
 --cast(([UnitsInStock])/([UnitsInStock] + [UnitsOnOrder]) as money) AS 'Percentage',
--convert(money, ([UnitsInStock])/([UnitsInStock] + [UnitsOnOrder]) ) AS 'Percentage'
FROM Production.Products as PP
WHERE (PP.UnitsInStock !=0)
;
go


/* Example 19
Find the ten most expensive products. Create this view and save it as 19_vTenMostExpensiveProducts.
*/
SELECT TOP 10 with ties PP.ProductID, PP.ProductName, PP.UnitPrice
FROM Production.Products as PP
ORDER BY PP.UnitPrice DESC
;
go

/* Example 20
calculate the subtotal of each order. Create this view and save it as 20_vOrderSubtotal.
Subtotal = unit price x quantity - discount
*/
create view OrderSubtotalView
as
select OD.OrderID, OD.ProductID, OD.UnitPrice, OD.Quantity, OD.Discount, (OD.UnitPrice * OD.Quantity) * (1 - OD.Discount) as 'OrderSubtotal'
from Sales.[Order Details] as OD
;
go

select OrderID, sum(OrderSubtotal) as 'Total'
from OrderSubtotalView
-- where OrderID = 10248
where OrderID between 10248 and 10250
group by OrderID
;
go
