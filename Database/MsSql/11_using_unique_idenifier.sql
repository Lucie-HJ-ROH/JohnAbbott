/* Purpose: Using UniqueIdentifier Objects in the database
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


-- select all defined table
select *
from sysobjects

-- 'U' system object type means it is a user-defined table 
if OBJECT_ID('Person.Contacts', 'U') is not null
	drop table Person.Contacts
;
go

create table Person.Contacts
(
	ContactID uniqueidentifier not null default newID(),
	FirstName nvarchar(15) not null,
	LastName nvarchar(15) not null,
	constraint pk_Contacts primary key clustered (ContactID asc)
)
;
go

insert into Person.Contacts(FirstName, LastName)
values('Mary', 'Smith')
;
go

select *
from Person.Contacts
;
go
