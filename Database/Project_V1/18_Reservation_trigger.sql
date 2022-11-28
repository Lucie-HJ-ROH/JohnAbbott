/*
Database Group Project Version 1

Script Data : June 22, 2022
Developed by :  Jingyu An   2228416
                Hyunju Roh  2227572
*/


use WMlibrary
;
go


-- when insert reservation.
drop trigger trans.ReservationCntCheckTR
create trigger trans.ReservationCntCheckTR
on trans.Reservation
for insert

as
 	begin
--  		declare @reservedCnt as int,
--  		        @memberId as int
--  		set @reservedCnt = (
--  		    select M.reservedCnt
--  		    from Membership.Members as M
--  		    where @MemberID = 2585
--              )
--  		-- compute the return value
--  		--if @reservedCNT = 4
	   print 'Reservation is complete.'
 	end
;
go

insert trans.Reservation
	values(6,2585,2022-06-24)
;
go
--
-- 	insert trans.Reservation
-- 	values(35,2585,2022-06-24)
-- ;
-- go

--
-- Alter table Membership.Members add ReservedCnt int default 0 not null
-- ;
-- go

-- setting for reservedCnt

DECLARE @Counter INT
SET @Counter = 0
WHILE ( @Counter <= 10000)
BEGIN
    update Membership.Members
    set reservedCnt =
            (select count(R.MemberID)
             from Trans.Reservation as R
             where MemberID = @Counter + 1
             group by MemberID),
        @counter = @counter + 1

    where MemberID = @Counter +1
END

select R.memberId, count(R.MemberID)
from Trans.Reservation as R
where MemberID = 2585
group by R.MemberID

select *
from Membership.Members
where reservedCnt > 0


;
go
