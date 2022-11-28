/* Purpose: Creating User-Defined Data Types in the database library
Script Date: June 21, 2022
Developed by: Hyunju Roh, Jingyu An
*/

use WMlibrary
;
go

if OBJECT_ID('Membership.Members', 'U') is not null
	drop table Membership.Members
;
go




create table Membership.Members
(
	MemberID int not null,
    FirstName nvarchar(15) not null,
    LastName nvarchar(15) not null,
    MiddleInitial nvarchar(10) null
)
;
go

if OBJECT_ID('Membership.Adults', 'U') is not null
	drop table Membership.Adults
;
go



create table Membership.Adults
(
	MemberID int not null,
    street nvarchar(15) not null,
    city nvarchar(15) not null,
    state char(2) null,
    zip nvarchar(7) not null,
    ExprDate DATE not null,
    PhoneNo nvarchar(15) null,
    Photograph image null
)
;
go

if OBJECT_ID('Membership.Juvenile', 'U') is not null
	drop table Membership.Juvenile
;
go
create table Membership.Juvenile
(
	MemberID int not null, -- Foreign key (Members)
	MemberIDP int not null, -- Foreign key (Members)
    BirthDate DATETIME not null
)
;
go

if OBJECT_ID('Book.Items', 'U') is not null
	drop table Book.Items
;
go

create table Book.Items
(
    ISBN int not null ,
    titleID int not null,-- Foreign key (title)
    languageB nvarchar(10) not null,
    cover nvarchar(10) not null ,
    loanable char(1) not null

)
;
go


if OBJECT_ID('Book.titles', 'U') is not null
	drop table Book.titles
;
go
create table Book.titles
(
    titleId int not null,
    bookTitle nvarchar(50) not null,
    author nvarchar(50) not null
)
;
go

if OBJECT_ID('Book.copy', 'U') is not null
	drop table Book.copy
go

create table Book.copy
(
    ISBN int not null, -- Foreign key (Items)
    CopyNo  int not null,
    titleID int not null,-- Foreign key (title)
    on_loan char(1) not null, -- Y , N

)
;
go
/*
if OBJECT_ID('Book.Authors', 'U') is not null
	drop table Book.Authors
;
go
create table Book.Authors
(
	AuthorID int identity(1, 1) not null,
    AuthorName nvarchar(30) not null,
    constraint pk_Authors primary key clustered
        (
            authorID asc
        )
)
;
go

if OBJECT_ID('Book.BookGenres', 'U') is not null
	drop table Book.BookGenres
;
go
create table Book.BookGenres
(
	BookGenresID int identity(1, 1) not null,
    BookGenresDesc nvarchar(30) not null,
    constraint pk_BookGenres primary key clustered
        (
            BookGenresID asc
        )
)
;
go

if OBJECT_ID('Book.Publisher', 'U') is not null
	drop table Book.Publisher
;
go
 create table Book.Publisher
(
	PublisherID int identity(1, 1) not null,
    PublisherDesc nvarchar(30) not null,
    constraint pk_Publisher primary key clustered
        (
            PublisherID asc
        )
)
;
go*/

if OBJECT_ID('Trans.Loan', 'U') is not null
	drop table Trans.Loan
;
go

create table Trans.Loan
(
    ISBN int not null, -- Foreign key (items)
    CopyNo  int not null,-- Foreign key (copy)
    titleID int not null, -- Foreign key (titles)
    MemberID int not null, -- Foreign key (Members)
    checkoutDate Datetime null,
    dueDate Datetime null
)
;
go

if OBJECT_ID('Trans.Reservation', 'U') is not null
	drop table Trans.Reservation
;
go
create table Trans.Reservation
(
    ISBN int not null, -- Foreign key (items)
    MemberID int not null, -- Foreign key (Members)
    LogDate DATETIME not null
)
;
go

if OBJECT_ID('Trans.LoanHistory', 'U') is not null
	drop table Trans.LoanHistory
;
go

create table Trans.LoanHistory
(
    ISBN int not null,-- Foreign key (items)
    CopyNo  int not null,-- Foreign key (copy)
    checkoutDate Datetime null,
    titleID int not null, -- Foreign key (titles)
    MemberID int not null, -- Foreign key (Members)
    dueDate Datetime null,
    noticeDate Datetime null
)
;
go

