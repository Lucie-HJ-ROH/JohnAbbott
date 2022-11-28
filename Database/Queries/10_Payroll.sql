/*
Assignment
SA5_DB_Take_Home_Assignment_2_Data_Winter_2022_FSD-05

Script Data : June 14, 2022
Developed by :  Jingyu An   2228416
                Hyunju Roh  2227572
*/
#
# list of list of employees that includes
# their salary or hourly pay rate.
# The list must also include Social Security Numbers and employee IDs
# so that an outside firm can properly process the payroll.
# Produce an employee list that provides this information,
# and sort it so that it’s easy to find an employee by name. for those employees who are on a salary,
# the list should show their monthly wage.

use MovingOn_JGAnAndHJRoh
;

select E.EmpID, E.SSN , concat(E.EmpFirst, ' ' , E.EmpLast), E.Salary, E.HourlyRate
from Employees as E
where HourlyRate > 0 or Salary > 0
order by concat(E.EmpFirst, ' ' , E.EmpLast) asc
;

