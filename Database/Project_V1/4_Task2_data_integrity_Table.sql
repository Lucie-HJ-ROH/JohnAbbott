/*
Database Group Project Version 1

Script Data : June 22, 2022
Developed by :  Jingyu An   2228416
                Hyunju Roh  2227572
*/


use WMlibrary
;
go


-- 1.Create or modify the default constraint that makes WA (Washington) the default for the
-- state column in the adult table.
-- set the default constraint value to WA (Washington) for state


if exists(select * from Membership.Adults where state is null )
begin
alter table Membership.Adults
	add constraint df_state_Adult default('WA') for State
end
;
go


-- alter table Membership.Adults
-- 	add constraint df_state_Adult default('WA') for State
-- ;
-- go


-- 2. Create a phone number constraint to the adult table.
-- set the PhoneNo to be unique in the Membership.Adults table.

if exists(select * from Membership.Adults where PhoneNo is null )
begin
alter table Membership.Adults
	add constraint df_PhoneNo_Adult default('000-000-0000') for PhoneNo
end
;
go

-- 3.The value in the due_date column
-- must be greater than or equal to the value in the out_date column (due_date >= out_date).
-- check that (due_date >= out_date)

alter table Trans.loan
alter table Trans.loan
    drop constraint ck_due_date_loan
;

alter table Trans.loan
	add constraint ck_due_date_loan check (dueDate >= checkoutDate)
;
go

-- 4.Create a PRIMARY KEY on the item table
-- add the primary key in the items table
alter table Book.Items
    ADD primary key (ISBN)
;
go

-- 5.Create a PRIMARY KEY constraint on the title table.
-- add the constraint on the title table
alter table Book.titles
    add constraint pk_title
    primary key (titleId)
;
go
-- 6. Write a script that adds PRIMARY KEY constraints to the other tables in the Library database.
-- execute when create tables
-- 1. Member Table
alter table Membership.members
	add CONSTRAINT pk_Members PRIMARY KEY CLUSTERED
	(
		MemberID ASC
	)
;
go

-- 2. Copy Table
alter table Book.copy
	add CONSTRAINT pk_Copy PRIMARY KEY CLUSTERED
	(
		ISBN, CopyNo ASC
	)
;
go



-- 7. Create a FOREIGN KEY on the item table.
--     ISBN  nvarchar(15) not null, -- Foreign key (title)
--     AuthorID varchar(4) not null, -- Foreign key (Authors)
--     PublisherID varchar(4) not null,-- Foreign key (Publishers)
--     BookGenresID varchar(4) not null,-- Foreign key (BookGenres)

-- Foreign key between Book.ItemID  and book.titles
alter table Book.items
	add constraint fk_Itmes_Title foreign key (titleId)
		references Book.titles (titleId)
;
go



-- 8. Write a script that adds FOREIGN KEY constraints to the other tables in the Library database.
-- execute when apply_data_integrity
-- Foreign key between Membership.Adults and Membership.Members
alter table Membership.Adults
	add constraint fk_Adults_Members foreign key (MemberID)
		references Membership.Members (MemberID)
;
go

-- Foreign key between Membership.Juvenile  and Membership.Members
alter table Membership.Juvenile
	add constraint fk_Juvenile_Members foreign key (MemberID)
		references Membership.Members (MemberID)
;
go


-- Foreign key between Membership.Juvenile and Membership.MembersP
alter table Membership.Juvenile
	add constraint fk_Juvenile_MembersP foreign key (MemberIDP)
		references Membership.Members (MemberID)
;
go


-- Foreign key between Book.copy  and book.items
alter table Book.copy
	add constraint fk_copy_items foreign key (ISBN)
		references Book.items (ISBN)
;
go

sp_help 'book.copy'

-- Foreign key between Book.copy  and book.titles
alter table Book.copy
	add constraint fk_copy_Title foreign key (titleId)
		references Book.titles (titleId)
;
go


-- Foreign key between Trans.Loan and Book.copy
alter table Trans.Loan
	add constraint fk_Loan_copy foreign key (ISBN,CopyNo)
		references Book.copy (ISBN,CopyNo)
;
go

-- Foreign key between Trans.Loan and Book.titles
alter table Trans.Loan
	add constraint fk_Loan_titles foreign key (titleID)
		references Book.titles (titleId)
;
go

-- Foreign key between Trans.Loan and Membership.members
alter table Trans.Loan
	add constraint fk_Loan_members foreign key (MemberID)
		references Membership.Members (MemberID)
;
go

-- Foreign key between Trans.Loan and Membership.members
alter table Trans.Reservation
	add constraint fk_Reservation_items foreign key (ISBN)
		references book.Items(isbn)
;
go


-- Foreign key between Trans.Loan and Membership.members
alter table Trans.Reservation
	add constraint fk_Reservation_members foreign key (MemberID)
		references Membership.Members (MemberID)
;
go

-- Foreign key between Trans.LoanHistory and Book.copy
alter table Trans.LoanHistory
	add constraint fk_LoanHistory_copy foreign key (ISBN,CopyNo)
		references Book.copy (ISBN,CopyNo)
;
go

-- Foreign key between Trans.LoanHistory and Book.titles
alter table Trans.LoanHistory
	add constraint fk_LoanHistory_titles foreign key (titleID)
		references Book.titles (titleId)
;
go

-- Foreign key between Trans.LoanHistory and Membership.members
alter table Trans.LoanHistory
	add constraint fk_LoanHistory_Members foreign key (MemberID)
		references Membership.Members (MemberID)
;
go
