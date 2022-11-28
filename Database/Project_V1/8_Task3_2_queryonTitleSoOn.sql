/*
Database Group Project Version 1

Script Data : June 22, 2022
Developed by :  Jingyu An   2228416
                Hyunju Roh  2227572
*/


/*
 2. Write and execute a query on the title, item, and copy tables
 that returns the isbn, copy_no, on_loan, title, translation, and cover,
 and values for rows in the copy table with an ISBN of 1 (one), 500 (five hundred),
 or 1000 (thousand). Order the result by ISBN column.
 */


use WMlibrary
;
go

SP_RENAME 'book.items.languageB', 'translation', 'column';
go



select I.ISBN, c.CopyNo, c.on_loan, T.bookTitle, i.translation, i.cover
from book.copy as C
         inner join book.Items I on I.ISBN = C.ISBN
         inner join book.titles T on T.titleId = C.titleID
where i.ISBN in (1, 500, 1000)
order by i.ISBN



alter procedure Book.copyISBN(
    @Isbn as int
)
as
begin
    select I.ISBN, c.CopyNo, c.on_loan, T.bookTitle, i.translation, i.cover
    from book.copy as C
             inner join book.Items I on I.ISBN = C.ISBN
             inner join book.titles T on T.titleId = C.titleID
    where I.Isbn = @Isbn
end
    ;
go


/* call the procedure HumanResources.getAllEmployeeByNameSP */
execute Book.copyISBN @isbn = 1
execute Book.copyISBN @isbn = 500
execute Book.copyISBN @isbn = 1000

;
go