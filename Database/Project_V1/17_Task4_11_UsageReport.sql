/*
Database Group Project Version 1

Script Data : June 22, 2022
Developed by :  Jingyu An   2228416
                Hyunju Roh  2227572
*/

/*
 Task 4 Create Stored Procedures and Triggers
 11. Generating Usage Reports –
 seven questions are listed at the end of this document to generate summary information for librarians.
1. How many loans did the library do last year?
2. What percentage of the membership borrowed at least one book?
3. What was the greatest number of books borrowed by any one individual?
4. What percentage of the books was loaned out at least once last year?
5. What percentage of all loans eventually becomes overdue?
6. What is the average length of a loan?
7. What are the library peak hours for loans?

 */
use WMlibrary
;
go

-- 1. How many loans did the library do last year?
select sum(tbl.allCount) as 'Number of loans last year'
from
(
    select count(*) as allCount
    from trans.LoanHistory LH
    where datepart(YEAR , LH.checkoutDate) = 2021
    UNION ALL
    select count(*) as allCount
    from trans.Loan L
    where datepart(YEAR , L.checkoutDate) = 2021
)
tbl
;
go


-- 2. What percentage of the membership borrowed at least one book?
select cast(cast(count(DISTINCT LH.MemberID)+count(DISTINCT L.MemberID) as DECIMAL) /
            cast(count(DISTINCT M.MemberID) as DECIMAL) * 100 as float) as
    'Percentage of the membership borrowed at least one book'
from Membership.Members  M
left outer join trans.LoanHistory  LH on M.MemberID = LH.MemberID
left outer join trans.Loan  L on M.MemberID = L.MemberID
;
go

-- 3. What was the greatest number of books borrowed by any one individual?
select TOP 1 member as 'Top Member ID', tbl.popularity as 'Greatest number of books borrowed'
from
    (
        select count(*) as 'popularity', M.MemberID as 'member'
        from Membership.Members M
        inner join trans.LoanHistory LH on M.MemberID = LH.MemberID
        group by M.MemberID
        union all
        select count(*) as 'popularity', M.MemberID as 'member'
        from Membership.Members M
        inner join trans.Loan L on M.MemberID = L.MemberID
        group by M.MemberID
    )tbl
order by tbl.popularity desc
;
go

-- 4. What percentage of the books was loaned out at least once last year?
select cast(count(DISTINCT case when datepart(YEAR , L.checkoutDate) = 2021 or
                                datepart(YEAR , LH.checkoutDate) = 2021 then I.ISBN end ) as decimal)
        / cast(count(DISTINCT I.ISBN) as decimal) * 100 as 'Percentage of books was loaned once last year'
from Book.Items I
left outer join trans.Loan L on I.ISBN = L.ISBN
left outer join Trans.LoanHistory LH on I.ISBN = LH.ISBN
;
go

-- 5. What percentage of all loans eventually becomes overdue?
select cast(sum(tbl.overdue) as decimal) / cast(sum(tbl.allLoans) as decimal) * 100 as 'percentage of overdue'
from
    (
        select count(*) as 'allLoans', null as 'overdue'
        from trans.Loan L
        union all
        select count(*) as 'allLoans', count(case when LH.noticeDate is not null then 1 end) as 'overdue'
        from trans.LoanHistory LH
    ) tbl
;
go

-- 6. What is the average length of a loan?
select avg(tbl.total) as 'Average length of a loan'
from
(
    select sum(DATEDIFF(DAY, LH.checkoutDate, LH.dueDate)) as 'total'
    from Trans.LoanHistory LH
    group by LH.ISBN, LH.CopyNo
)tbl
;
go

-- 7. What are the library peak hours for loans?
select datepart(hh, LH.checkoutDate) as 'hours', count(datepart(hh, LH.checkoutDate)) as 'Count of checkout'
from Trans.LoanHistory LH
group by datepart(hh, LH.checkoutDate)
;
go