/* Purpose: Creating Schema Objects in the Database Library
Script Date: June 21, 2022
Developed by Hyunju Roh, Jingyu An
*/


use WMlibrary
;
go -- include end of batch markers (go statement)


BEGIN TRAN

DECLARE @id INT
SET @id = 2585

INSERT Trans.Reservation
VALUES (1, @id, 2022 - 06 - 30)

if
        (select reservedCnt
         from Membership.Members
         where MemberID = @id) > 3
    begin
        print 'You have already reserved 4 book.'
    end
else
    begin
        UPDATE Membership.Members
        SET reservedCnt= reservedCnt + 1
        WHERE MemberID = @id
    end

COMMIT TRAN

select M.reservedCnt
from Membership.Members as M
where M.MemberID = 2585
