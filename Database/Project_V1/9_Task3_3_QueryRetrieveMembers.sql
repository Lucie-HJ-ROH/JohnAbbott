/*
Database Group Project Version 1

Script Data : June 22, 2022
Developed by :  Jingyu An   2228416
                Hyunju Roh  2227572
*/


/*
3. Write and execute a query to retrieve the member’s full name and member_no from the member table
   and the isbn and log_date values from the reservation table for members 250, 341, 1675.
   Order the results by member_no. You should show information for these members, even if they have no books or reserve.
*/

use WMlibrary
;
go

select M.memberID, concat(M.FirstName,' ',M.LastName ,' ', m.MiddleInitial) as 'Member Name' ,R.ISBN , R.LogDate
from Membership.Members as M
    left outer join trans.Reservation R on R.MemberID = M.MemberID
where M.MemberID in (250,341,1675)
order by M.MemberID
;
go


