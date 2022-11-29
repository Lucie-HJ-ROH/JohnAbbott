/*
Database Group Project Version 1

Script Data : June 22, 2022
Developed by :  Jingyu An   2228416
                Hyunju Roh  2227572
*/

/*

 10. Create a view and save it as OverdueView that queries OnloanView (3-table join.)
 Lists the member, title, and loan information of a copy on loan that is overdue (due_date < current date)

 */

use WMlibrary
;
go


-- Create user-defined functions

create function Trans.getNumberOfDueDaysFn
(
	-- declare parameter list
	@dueDate as datetime,
	@currentDate as datetime
)
returns int
as
	begin
		-- declare the return variable
		declare @NumberOfDueDays as int
		-- compute the return value
		select @NumberOfDueDays = abs(dateDiff(day, @dueDate, @currentDate ))
		-- return the result to the function caller
		return @NumberOfDueDays
	end
;
go

if OBJECT_ID('trans.OverdueView', 'V') is not null
	drop view trans.OverdueView
;
go

create view trans.OverdueView
as
select M.memberID, T.booktitle , Trans.getNumberOfDueDaysFn(duedate, getdate()) as 'overdue period'
from Trans.loan as L
inner join book.copy C on L.ISBN = C.ISBN
	    inner join book.titles T on L.titleId = T.titleId
	    inner join Membership.Members M on L.MemberID = M.MemberID
where C.on_loan = 'Y' and Trans.getNumberOfDueDaysFn(duedate, getdate()) > 0
group by M.memberID, T.booktitle , Trans.getNumberOfDueDaysFn(duedate, getdate())
;
go



select *
from trans.OverdueView
;
go

