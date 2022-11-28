/*
Assignment
SA5_DB_Take_Home_Assignment_2_Data_Winter_2022_FSD-05

Script Data : June 14, 2022
Developed by :  Jingyu An   2228416
                Hyunju Roh  2227572
*/


/*
MovinOn knows that having a workforce of long-term employees improves customer service
and avoids the high expense of training new employees.
Darnell wants to know if one warehouse is more effective at retaining employees than another.
Create an employee list that calculates the number of years each employee has worked for MovinOn.
Organize the list by job title within each warehouse. Save the script as 12_EmployeeLongevity.

*/
use MovingOn_JGAnAndHJRoh
;


SELECT concat(E.EmpFirst, ' ', E.EmpLast),p.Title, W.State, TIMESTAMPDIFF(YEAR,E.StartDate,now())
    from Employees as E
        inner join Positions P on E.PositionID = P.PositionID
        inner join Warehouses W on E.WarehouseID = W.WarehouseID
    order by  w.State desc, p.Title desc
;