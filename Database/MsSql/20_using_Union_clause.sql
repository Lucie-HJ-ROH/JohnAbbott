/* Purpose: Using union Clause in the Safeway22H2 database
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

 
/* return the list of customers in Canada */
select CompanyName, Address, City, Region, PostalCode, Country, 'Customer' as 'Status'
from Sales.Customers
where Country = 'Canada'
union -- union all
/* 
 ? The number and the order of the columns must be the same in all queries.
 ? The data types must be compatible.
*/
/* return the list of Suppliers in Canada */
select CompanyName, Address, City, Region, PostalCode, Country ,'Supplier' as 'Status'
from Purchasing.Suppliers
where Country = 'Canada'
;
go