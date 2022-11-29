/* Purpose: Renaming database objects
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


/* 
1. create a new database Testtttttttttttt
2. create a new table, Contactssssssssss
3. create a column, ContactIDddddddd
*/

-- switch to the Testtttttttttttt database
use Testtttttttttttt
;
go

-- creating table
create table Contactssssssssss
(
	ContactIDddddddd int, -- rename this column
	ContactFirstName nvarchar(30)
)
;
go



-- 1. renaming the database
/* Syntax:
execute sp_renamedb 'old_database_name', 'new_database_name'
*/
execute sp_renamedb 'Testtttttttttttt', 'TestDB'
;
go

execute sp_helpdb 'TestDB'
;
go

-- 2. rename a table
/*
Syntax:
execute sp_rename 'schema_name.old_table_name', 'new_table_name'
;
go
*/
execute sp_rename 'dbo.Contactssssssssss', 'Contacts'
;
go

-- 3. renaming a column
/* 
Syntax:
execute sp_rename 'schema_name.table_name.old_column_name', 'new_column_name', 'Column'
*/
execute sp_rename 'dbo.Contacts.ContactIDddddddd', 'ContactID', 'Column'
;
go
