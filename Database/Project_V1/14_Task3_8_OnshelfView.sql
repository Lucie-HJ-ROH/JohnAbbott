/*
Database Group Project Version 1

Script Data : June 22, 2022
Developed by :  Jingyu An   2228416
                Hyunju Roh  2227572
*/

/*
 8. Create a view and save it as OnshelfView that queries CopywideView (3-table join).
 Lists complete information about each copy that is not currently on loan (on_loan ='N').
 */
use WMlibrary
;
go

if OBJECT_ID('book.OnshelfView', 'V') is not null
	drop view book.OnshelfView
;
go

create view Book.OnshelfView
as
	select  c.CopyNo, t.bookTitle, i.ISBN, i.translation, c.on_loan
	from book.copy as C
        inner join book.items I on C.ISBN= I.ISBN
        inner join book.titles T on C.titleID = T.titleId
    where t.titleId = i.titleID and C.on_loan = 'N'


;
go

select *
from Book.OnshelfView
;
go