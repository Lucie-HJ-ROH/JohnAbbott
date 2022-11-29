/*
Database Group Project Version 1

Script Data : June 22, 2022
Developed by :  Jingyu An   2228416
                Hyunju Roh  2227572
*/

/*
6. Create a view and save it as and CopywideView that queries the copy, title and item tables.
Lists complete information about each copy.

 */

use WMlibrary
;
go

if OBJECT_ID('Book.copyWideView', 'V') is not null
	drop view Book.copyWideView
;
go

create view Book.copyWideView
as
	select  c.CopyNo, t.bookTitle, i.ISBN, i.translation, c.on_loan
	from book.copy as C
        inner join book.items I on C.ISBN= I.ISBN
        inner join book.titles T on C.titleID = T.titleId
    where t.titleId = i.titleID

;
go


select *
from Book.copyWideView
;
go