/*
Database Group Project Version 1

Script Data : June 22, 2022
Developed by :  Jingyu An   2228416
                Hyunju Roh  2227572
*/
/*

5. Create a view and save it as ChildwideView that queries the member, adult,
and juvenile tables. Lists the name & address for the juveniles.
 */

use WMlibrary
;
go

if OBJECT_ID('Membership.ChildwideView', 'V') is not null
	drop view Membership.ChildwideView
;
go

create view Membership.ChildwideView
as
	select M.memberID, concat(M.FirstName,' ',M.LastName ,' ', m.MiddleInitial) as 'Member Name' , concat(A.street,' ' ,A.city ,' ' , a.state,' ' ,a.zip) as 'Member Address'
	from Membership.Juvenile as J
    inner join Membership.Members M on J.MemberID = M.MemberID
    inner join Membership.Adults A on J.MemberIDP = A.MemberID
;
go


select *
from Membership.ChildwideView
;
go