use WMlibrary
;
go


insert into Membership.Members(MemberID, FirstName, LastName, MiddleInitial)
values(10004, 'Johnathan', 'Smith', 'D')
;
go

insert into Membership.Adults(MemberID, street, city, state, zip, ExprDate, PhoneNo, Photograph)
values (10004,'Brookline','Kingsley','','36114','2008-01-06', null,null)
;
go

insert into Membership.Members(MemberID, FirstName, LastName, MiddleInitial)
values(10005, 'Petronella', 'Smith', 'S')
;
go

insert into Membership.Adults(MemberID, street, city, zip, ExprDate)
values (10005,'lakeshore','Dorval','13534','2022-01-06')
;
go

insert into Membership.Members(MemberID, FirstName, LastName, MiddleInitial)
values(10006, 'Harry', 'Porter', 'H')
;
go

insert into Membership.Adults(MemberID, street, city, zip, ExprDate)
values (10006,'Queenly','Oxford','55643','2023-01-06')
;
go



select *
from membership.adults
where MemberID = 10006
;
go



select *
from membership.members
;
go

update Trans.Loan
set checkoutDate = dateAdd(year,14, checkoutDate)
    , dueDate = dateAdd(year,14, dueDate)
;
go

update Trans.Loan
set checkoutDate = dateAdd(month ,6, checkoutDate)
    , dueDate = dateAdd(month,6, dueDate)
;
go

update Trans.Loan
set checkoutDate = dateAdd(day ,-15, checkoutDate)
    , dueDate = dateAdd(day,-15, dueDate)
;
go
select *
from trans.Loan
;
go


update Trans.LoanHistory
set checkoutDate = dateAdd(year,14, checkoutDate)
    , dueDate = dateAdd(year,14, dueDate)
    , noticeDate = dateAdd(year,14, noticeDate)
;
go

select *
from trans.LoanHistory
;
go

update Trans.Reservation
set LogDate = dateAdd(year,14, LogDate)

;
go

select *
from trans.Reservation
;
go


update Membership.Adults
set ExprDate = dateAdd(year,14, ExprDate)

;
go

select *
from  Membership.Adults
;
go


update Membership.Juvenile
set BirthDate = dateAdd(year,14, BirthDate)

;
go

select *
from  Membership.Juvenile
;
go
