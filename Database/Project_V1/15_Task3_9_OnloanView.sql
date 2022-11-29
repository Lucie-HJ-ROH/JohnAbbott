/*
Database Group Project Version 1

Script Data : June 22, 2022
Developed by :  Jingyu An   2228416
                Hyunju Roh  2227572
*/

/*
 9. Create a view and save it as OnloanView that queries the loan, title, and member tables.
 Lists the member, title, and loan information of a copy that is currently on loan.
 */

use WMlibrary
;
go

if OBJECT_ID('trans.OnloanView', 'V') is not null
	drop view trans.OnloanView
;
go

create view trans.OnloanView
as
	select  M.memberID, T.booktitle, C.on_loan
	from Trans.loan as L
        inner join book.copy C on L.ISBN = C.ISBN
	    inner join book.titles T on L.titleId = T.titleId
        inner join membership.members M on L.memberId = M.memberID
        where C.on_loan = 'Y'
    group by M.memberID, T.booktitle, C.on_loan
;
go



select *
from trans.OnloanView
;
go

