/*
Database Group Project Version 1

Script Data : June 24, 2022
Developed by :  Jingyu An   2228416
                Hyunju Roh  2227572
*/
-- West Municipal Library


use WMlibrary
;
go

/* retrieve index information on table membership.member */
execute sp_help 'membership.members'
;
go

exec sp_helpindex 'membership.members'
;
go

/* retrieve index information on table Sales.Orders */
execute sp_helpindex 'Book.items'
;
go



select
	name, -- name of the index. Name must be unique
	index_id, -- the ID of the index: 0 --> heap, 1 --> clustered, >1 --> nonclustered
	type, -- type of the index: 0 --> heap, 1 --> clustered, 2 --> nonclustered, 3 --> xml, 4 --> spatial index
	type_desc,	-- description of the index
	is_unique,	-- 1 --> unique, 0 --> index is not unique
	is_primary_key	-- 1 --> index is part of the primary key
from sys.indexes
where object_id = OBJECT_ID('Book.items')

;
go

/* create a nonclustered index, ncl_LastName, on the employee last name */
-- create nonclustered index index_name on table_name (column_name)
create nonclustered index ncl_on_loan on book.copy (on_loan)
;
go

/* remove the index, ncl_LastName, on the table HumanResources.Employees */
-- Syntax: drop index from_schema_name_table_name.index_name
drop index book.copy.ncl_on_loan
;
go
