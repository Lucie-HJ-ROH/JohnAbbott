/* Purpose: Using System Stored Procedures in the Safeway22H2 database
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

/*
Stored procedures are similar to procedures in other programming languages in that they can:

? Accept input parameters and return multiple values in the form of output parameters to the calling procedure or batch.

? Contain programming statements that perform operations in the database, including calling other procedures.

? Return a status value to a calling procedure or batch to indicate success or failure (and the reason for failure).
*/

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

execute sp_datatype_info
;
go

/* return the list of all databases in SQL Server */
execute sp_databases
;
go

/* return information about Safeway22H2 database */
exec sp_helpdb 'Safeway22H2'
;
go

/* return information about specific object in a database */
execute sp_help @objname = 'Sales.Customers'
;
go

/* return all tables in a specific schema */
execute sp_tables
@table_name = 'Orders',
@table_owner = 'Sales'
;
go

/* return constraints applyed to the Sales.Orders table */
execute sp_helpconstraint 'Sales.Orders'
;
go


/* 
1. write a query that retreive system metadata
2. using system catalog views 
3. using standard information_schema views
4. using system functions 
*/

-- 1. write a query that retreive system metadata
/* view the server settings using system views and functions */
select name, value, value_in_use, description
from sys.configurations
;
go

/* return the list of all databases in SQL Server */
select name, database_id, collation_name, user_access, user_access_desc,state_desc
from sys.databases
;
go

/* list all user-defined tables */
select
	S.name as 'Schema Name',
	T.name as 'Table Name',
	T.type_desc as 'Table Description',
	T.create_date as 'Created Date'
from sys.tables as T
	inner join sys.schemas as S
		on T.schema_id = S.schema_id
order by S.name, T.name
;
go

-- 2. using system catalog views 
select *
from INFORMATION_SCHEMA.TABLES
where TABLE_TYPE = 'base table'
;
go

select *
from INFORMATION_SCHEMA.VIEWS
;
go

select *
from INFORMATION_SCHEMA.VIEW_COLUMN_USAGE
where VIEW_SCHEMA ='Sales'
and VIEW_NAME ='OrderTotalView'
;
go

/* return the list of all stored procedures */
exec sp_stored_procedures
;
go
