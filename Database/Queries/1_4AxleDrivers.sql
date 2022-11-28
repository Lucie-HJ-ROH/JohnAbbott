/*
Assignment
SA5_DB_Take_Home_Assignment_2_Data_Winter_2022_FSD-05

Script Data : June 14, 2022
Developed by :  Jingyu An   2228416
                Hyunju Roh  2227572
*/
use MovingOn_JGAnAndHJRoh
;

select *
from Drivers
;

select DriverID, CONCAT(DriverFirst,' ',DriverLast), DrivingRecord,Phone
    from Drivers
    where DrivingRecord < 'C'
;