
/* Purpose: Creating Schema Objects in the Database Library
Script Date: June 21, 2022
Developed by Hyunju Roh, Jingyu An
*/


use WMlibrary
;
go  -- include end of batch markers (go statement)

drop procedure Book.TitleLoanableCheckSP

create procedure Book.TitleLoanableCheckSP
(
	-- declare a parameter
	-- SYNTAX: @parameter_name as  data_type [=expression]
	@title as nvarchar(50)
)
as
	begin
	    select T.bookTitle,I.translation,I.loanable
		from book.titles as T
        inner join Items I on T.titleId = I.titleID
        where t.bookTitle like @title
	end
;
go


execute Book.TitleLoanableCheckSP @Title = 'a%'
;
go