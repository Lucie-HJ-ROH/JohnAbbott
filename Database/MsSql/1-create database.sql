/* Purpose: Create Database Safeway22H2
Script Date: June 20, 2022
Developed by Khattar Daou
*/


/* add a statement that specifies that the script runs in the context of the master database */
-- switch to the master database
-- Syntax: use database_name
use master
;
go  -- include end of batch markers (go statement)

/* Syntax: create object_type object_name */
create database Safeway22H2
on primary
(
	-- 1) rows data logical filename
	name = 'Safeway22H2',
	-- 2) rows data initial file size 
	size = 12MB,
	-- 3) rows data auto growth size
	filegrowth = 8MB,
	-- 4) rows data maximum size
	maxsize = unlimited, -- 250MB
	-- 5) rows data path and file name
	filename = 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Safeway22H2.mdf'
)
-- log file
log on
(
	-- 1) log logical filename
	name = 'Safeway22H2_log',
	-- 2) log initial file size (1/4 the rows data file size)
	size = 3MB,
	-- 3) log auto growth size
	filegrowth = 10%,
	-- 4) log maximum size
	maxsize = 25MB,
	-- 5) log path and file name
	filename = 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Safeway22H2_log.ldf'
)
;
go

-- return the definition of the Safeway22H2 database
execute sp_helpdb 'Safeway22H2'
;
go

-- remove an exisiting database from the server
drop database MyDB1
;
go

-- increase the maximum size of the Safeway22H2 database to 100MB

-- switch to the master database
use master;
go

alter database Safeway22H2
	modify file 
		(
			name = 'Safeway22H2_log',
			maxsize = 100MB
		)
;
go



-- return the definition of Safeway22H2 database using system stored procedure
-- Syntax: execute stored_procedure_name [parameter_value]

execute sp_helpdb 'Safeway22H2'
;
go

/* return the SQL Server version we are running */
select
	@@VERSION as 'SQL Server Version',
	@@SERVERNAME as 'Server Name'
;
go

/* using T-SQL Functions */

-- switch to the Safeway22H2 database
-- Syntax: use database_name
use Safeway22H2
;
go

select 
	USER_NAME() as 'User Name',
	DB_NAME() as 'Database Name'
;
go
