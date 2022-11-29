/* Purpose: Creating User-Defined Data Types in the database Northwind22H1
Script Date: June 20, 2022
Developed by: Khattar Daou
*/

/* add a statement that specifies the script
runs in the context of the master database */

-- switch to the Northwind database
-- SSyntax: use database_name
use Northwind22H1
;
go -- includes end of the batch marker


/* Partial Syntax:
create type [schema_name].type_name
from system_data_type [constraint]
*/

/* create BusinessAddress data type */
create type BusinessAddress
from nvarchar(40) not null
;
go


/* create RegionCode (state or province) data type */
create type dbo.RegionCode
from nchar(2) null
;
go

/* create SocialNumber data type */
create type SocialInsuranceNo
from nchar(11) not null
;
go

/* create table Contacts */
create table Contacts
(
	ContactID smallint  identity(1, 1) not null,
	FirstName nvarchar(15) not null,
	LastName nvarchar(15) not null,
	SocialNumber SocialInsuranceNo,
	Address BusinessAddress,
	Region RegionCode,
	constraint pk_Contacts primary key clustered (ContactID asc)
)
;
go

/* return the definition of the table Contacts */
execute sp_help 'Contacts'
;
go

/* insert row into Contacts */
insert into Contacts (FirstName, LastName, Address, SocialNumber)
values ('John', 'Smith', 'some address', '123-456-789')
;
go

select *
from Contacts;
go



