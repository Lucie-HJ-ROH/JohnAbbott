/*
Database Group Project Version 1

Script Data : June 22, 2022
Developed by :  Jingyu An   2228416
                Hyunju Roh  2227572
*/

/*
4. Create a view and save it as adultwideView that queries the member and adult tables.
Lists the name & address for all adults.

*/


use WMlibrary
;
go


if OBJECT_ID('Membership.AdultwideView', 'V') is not null
	drop view Membership.AdultwideView
;
go

create view Membership.AdultwideView
as
	select concat(M.FirstName,' ',M.LastName ,' ', m.MiddleInitial) as 'Member Name' , concat(A.street,' ' ,A.city ,' ' , a.state,' ' ,a.zip) as 'Member Address'
	from Membership.Adults as A
    inner join Membership.Members M on A.MemberID = M.MemberID
;
go


select *
from Membership.AdultwideView
;
go