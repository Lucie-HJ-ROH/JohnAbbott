/* Purpose: User-Defined Functions in the Safeway22H2 database
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

-- Some of the Date and Time Built-In Functions


/* A User-Defined Function (UDF) is a Transactional-SQL (T-SQL) statements that returns parameters, perform an action, such as calculation, and returns the result of that action as a value. 
The return value can either be a scalar (single) or a table. */

/* 
SYNTAX:
	create function schema_name.function_name
	(
		[@parameter_name as data_type,
		@parameter_name as data_type,
		...
		]
	)
	returns data_type
	as
		begin
			T-SQL statement goes here
			return value
		end
	;
	go
*/

/* 'U' - Table 
	'V' - View
	'Fn' - function
*/

/*
if OBJECT_ID('schema_name.object_name', 'object_type') is not null
	drop object_type object_name
*/

/* create a function, HumanResources.getEmployeeSeniorityFn, that returns the employee seniority. drop the function if exists and re-createe it */

if OBJECT_ID('HumanResources.getEmployeeSeniorityFn', 'Fn') is not null
	drop function HumanResources.getEmployeeSeniorityFn
;
go

alter function HumanResources.getEmployeeSeniorityFn
(
	-- define parameter list
	@HireDate as datetime
)
returns int
as
	begin
		-- declare the return value
		declare @Seniority as int

		-- compute the return value
		select @Seniority = abs(DateDiff(year, @HireDate, getDate() ) )

		-- return the result to the function caller
		return @Seniority
	end
;
go

/* display the seniority of Safeway22H2 employees */
select
	EmployeeID, FirstName, LastName, HireDate, Title,
	HumanResources.getEmployeeSeniorityFn(HireDate) as 'Seniority'
from HumanResources.Employees
-- where EmployeeID = 1
where Title = 'Sales Representative' 
order by 'Seniority' desc
;
go


/* testing the HumanResources.getEmployeeSeniorityFn function */
select HumanResources.getEmployeeSeniorityFn('2025/1/20')
;
go


/* create a function, Sales.getNumberOfDaysFn, that returns the number of days between the order date and ship date. How long it took to ship an order. */
create function Sales.getNumberOfDaysFn
(
	-- declare parameter list
	@StartDate as datetime,
	@EndDate as datetime
)
returns int
as
	begin
		-- declare the return variable
		declare @NumberOfDays as int 
		-- compute the return value
		select @NumberOfDays = abs(dateDiff(day, @StartDate, @EndDate ))
		-- return the result to the function caller
		return @NumberOfDays
	end
;
go

/* testing Sales.getNumberOfDaysFn function */
select sales.getNumberOfDaysFn('2022/1/1', '2022/06/30') as 'Number of days to ship'
;
go

select OrderID, OrderDate, ShippedDate,
 Sales.getNumberOfDaysFn(OrderDate, ShippedDate) as 'No. of Days to Ship'
from Sales.Orders
-- where OrderID = 11000
-- where OrderID in (10248, 10249, 10250)
where OrderID between 10248 and 10260
;
go

/* create a table-valued function (TVF).
create Sales.getOrderDetailsTVF that returns a table-valued result. include the order id and the product name.
*/
select SO.OrderID as 'Order', PP.ProductName as 'Product'
from Sales.Orders as SO
	inner join Sales.[Order Details] as SOD
		on SO.OrderID = SOD.OrderID
	inner join Production.Products as PP
		on PP.ProductID = SOD.ProductID
where SO.OrderID in(10248, 10250)
;
go

create function Sales.getOrderDetailsTVF
(
	-- declare a parameter 
	@OrderID as int
)
returns table
as
	return
	(
		select SO.OrderID as 'Order', PP.ProductName as 'Product'
		from Sales.Orders as SO
			inner join Sales.[Order Details] as SOD
				on SO.OrderID = SOD.OrderID
			inner join Production.Products as PP
				on PP.ProductID = SOD.ProductID
		where SO.OrderID = @OrderID
	)
;
go

/* testing the Sales.getOrderDetailsTVF function */
select *
from Sales.getOrderDetailsTVF(10248)
;
go