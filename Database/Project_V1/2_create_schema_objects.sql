/* Purpose: Creating Schema Objects in the Database Library
Script Date: June 21, 2022
Developed by Hyunju Roh, Jingyu An
*/


use WMlibrary
;
go  -- include end of batch markers (go statement)


/* create schema objects and set the owner to each of them
1. Membership
2. Book
3. Transaction
*/

-- syntax: create schema schema_name authorization onwer_name

-- 1. Membership schema
create schema Membership authorization dbo
;
go

-- 2. Book schema
create schema Book authorization dbo
;
go

-- 3. Transaction schema
create schema Trans authorization dbo
;
go


