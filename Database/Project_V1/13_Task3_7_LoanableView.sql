/*
Database Group Project Version 1

Script Data : June 22, 2022
Developed by :  Jingyu An   2228416
                Hyunju Roh  2227572
*/

/*
 7. Create a view and save it as LoanableView that queries CopywideView (3-table join).
 Lists complete information about each copy marked as loanable (loanable = 'Y').
 */

use WMlibrary
;
go

if OBJECT_ID('book.loanableView', 'V') is not null
	drop view book.loanableView
;
go

create view Book.loanableView
as
	select  c.CopyNo, t.bookTitle, i.ISBN, i.translation, I.loanable
	from book.copy as C
        inner join book.items I on C.ISBN= I.ISBN
        inner join book.titles T on C.titleID = T.titleId
    where t.titleId = i.titleID and I.loanable = 'Y'


;
go


select *
from Book.loanableView
;
go