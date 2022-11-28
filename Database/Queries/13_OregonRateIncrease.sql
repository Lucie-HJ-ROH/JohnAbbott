/*
Assignment
SA5_DB_Take_Home_Assignment_2_Data_Winter_2022_FSD-05

Script Data : June 14, 2022
Developed by :  Jingyu An   2228416
                Hyunju Roh  2227572
*/

use MovingOn_JGAnAndHJRoh
;

select concat(E.EmpFirst, ' ', E.EmpLast) , w.State, e.HourlyRate , e.HourlyRate * 1.1
from Employees as E
    inner join Warehouses W on E.WarehouseID = W.WarehouseID
where e.WarehouseID = 'OR-1' and e.HourlyRate > 0
;