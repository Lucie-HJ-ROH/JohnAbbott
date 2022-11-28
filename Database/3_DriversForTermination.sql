/*
Assignment
SA5_DB_Take_Home_Assignment_2_Data_Winter_2022_FSD-05

Script Data : June 14, 2022
Developed by :  Jingyu An   2228416
                Hyunju Roh  2227572
*/

/* *************************************************************** */
/* create database */
create database MovingOn_JGAnAndHJRoh
;

use MovingOn_JGAnAndHJRoh
;

/* *************************************************************** */
/* Create Tables */
-- 1. Customers
create table Customers
(
    CustID INT not null ,
    CompanyName varchar(50) null ,
    ContactFirst varchar(30) not null ,
    ContactLast varchar(30) not null ,
    Address varchar(40) not null ,
    City varchar(30) not null ,
    State varchar(2) not null ,
    Zip varchar(10) not null ,
    Phone varchar(15) not null ,
    Balance DECIMAL(19,4) not null ,
    constraint pk_Customers primary key (CustID asc)
)
;

-- 2. Drivers
create table Drivers
(
    DriverID INT not null ,
    DriverFirst varchar(30) not null ,
    DriverLast varchar(30)  not null ,
    SSN varchar(9) not null ,
    DOB DATETIME not null ,
    StartDate DATETIME not null ,
    EndDate DATETIME null ,
    Address varchar(40) not null ,
    City varchar(30) not null ,
    State varchar(2) not null ,
    Zip varchar(10) not null ,
    Phone varchar(15) not null ,
    Cell varchar(15) not null ,
    MileageRate DECIMAL(19,4) not null ,
    Review DATETIME null ,
    DrivingRecord varchar(1) not null ,
    constraint pk_Drivers primary key (DriverID asc)
)
;

-- 3. Employees
create table Employees
(
    EmpID INT not null ,
    EmpFirst varchar(30) not null ,
    EmpLast varchar(30) not null ,
    WarehouseID varchar(5) not null ,                   -- foreign key references to Warehouses
    SSN varchar(9) not null ,
    DOB DATETIME not null ,
    StartDate DATETIME not null ,
    EndDate DATETIME null ,
    Address varchar(40) not null ,
    City varchar(30) not null ,
    State varchar(2) not null ,
    Zip varchar(10) not null ,
    PositionID INT not null ,                           -- foreign key references to Positions
    Memo LONGTEXT null ,
    Phone varchar(15) not null ,
    Cell varchar(15) not null ,
    Salary DECIMAL(19,4) null ,
    HourlyRate DECIMAL(19,4) null ,
    Review DATETIME null ,
    constraint pk_Employees primary key (EmpID asc)
)
;



-- 4. JobDetails
create table Jobdetails
(
    JobID INT not null ,                                -- foreign key references to Joborders
    VehicleID varchar(10) not null ,                    -- foreign key references to Vehicles
    DriverID INT not null ,                             -- foreign key references to Drivers
    MileageActual INT not null ,
    WeightActual INT not null ,
    constraint pk_Jobdetails primary key (JobID asc)
)
;

-- 5. JobOrders
create table Joborders
(
    JobID INT not null ,
    CustID INT not null ,                               -- foreign key references to Customers
    MoveDate DATETIME not null ,
    FromAddress varchar(50) not null ,
    FromCity varchar(30) not null ,
    FromState varchar(2) not null ,
    ToAddress varchar(50) not null ,
    ToCity varchar(30) not null ,
    ToState varchar(2) not null ,
    DistanceEst INT not null ,
    WeightEst INT not null ,
    Packing TINYINT(1) not null ,
    Heavy TINYINT(1) not null ,
    Storage TINYINT(1) not null ,
    constraint pk_Joborders primary key (JobID asc)
)
;

-- 6. StorageUnits
create table Storageunits
(
    UnitID INT not null ,
    WarehouseID varchar(5) not null ,                   -- foreign key references to Warehouses
    UnitSize varchar(10) not null ,
    Rent DECIMAL(19,4) not null ,
    constraint pk_Storageunits primary key
        (
            UnitID asc ,
            WarehouseID asc
        )
)
;

-- 7. UnitRentals
create table Unitrentals
(
    CustID INT not null ,                               -- foreign key references to Customers
    WarehouseID varchar(5) not null ,                   -- foreign key references to Warehouses
    UnitID INT not null ,
    DateIn DATETIME not null ,
    DateOut DATETIME null ,
    constraint pk_Unitrentals primary key
        (
            CustID asc ,
            WarehouseID asc ,
            UnitID
        )
)
;

-- 8. Vehicles
create table Vehicles
(
    VehicleID varchar(10) not null ,
    LicensePlateNum varchar(7) not null ,
    Axle INT not null ,
    Color varchar(10) not null ,
    constraint pk_Vehicles primary key (VehicleID asc)
)
;

-- 9. Positions
create table Positions
(
    PositionID INT not null ,
    Title varchar(30) not null ,
    constraint pk_Positions primary key (PositionID asc)
)
;

-- 10. Warehouses
create table Warehouses
(
    WarehouseID varchar(5) not null ,
    Address varchar(40) not null ,
    City varchar(30) not null ,
    State varchar(2) not null ,
    Zip varchar(10) not null ,
    Phone varchar(15) not null ,
    ClimateControl TINYINT(1) not null ,
    SecurityGate TINYINT(1) not null ,
    constraint pk_Warehouses primary key (WarehouseID asc)
)
;

/* *************************************************************** */
/* add foreign key constraint(s) to the Employees */
/* 1. Foreign Key Between Employees and Warehouses tables */
alter table Employees
	add constraint fk_Employees_Warehouses foreign key (WarehouseID)
		references Warehouses (WarehouseID)
;

/* 2. Foreign Key Between Employees and Positions tables */
alter table Employees
	add constraint fk_Employees_Positions foreign key (PositionID)
		references Positions (PositionID)
;

/* add foreign key constraint(s) to the Jobdetails */
/* 1. Foreign Key Between Jobdetails and Joborders tables */
alter table Jobdetails
	add constraint fk_Jobdetails_Joborders foreign key (JobID)
		references Joborders (JobID)
;

/* 2. Foreign Key Between Jobdetails and Vehicles tables */
alter table Jobdetails
	add constraint fk_Jobdetails_Vehicles foreign key (VehicleID)
		references Vehicles (VehicleID)
;

/* 3. Foreign Key Between Jobdetails and Drivers tables */
alter table Jobdetails
	add constraint fk_Jobdetails_Drivers foreign key (DriverID)
		references Drivers (DriverID)
;

/* add foreign key constraint(s) to the Joborders */
/* 1. Foreign Key Between Joborders and Customers tables */
alter table Joborders
	add constraint fk_Joborders_Customers foreign key (CustID)
		references Customers (CustID)
;

/* add foreign key constraint(s) to the Storageunits */
/* 1. Foreign Key Between Storageunits and Warehouses tables */
alter table Storageunits
	add constraint fk_Storageunits_Warehouses foreign key (WarehouseID)
		references Warehouses (WarehouseID)
;

/* add foreign key constraint(s) to the Unitrentals */
/* 1. Foreign Key Between Unitrentals and Customers tables */
alter table Unitrentals
	add constraint fk_Unitrentals_Customers foreign key (CustID)
		references Customers (CustID)
;

/* 2. Foreign Key Between Unitrentals and Warehouses tables */
alter table Unitrentals
	add constraint fk_Unitrentals_Warehouses foreign key (WarehouseID)
		references Warehouses (WarehouseID)
;

load data infile 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Customers.csv'
into table Customers
fields terminated by ','
lines terminated by '\r\n'
ignore 1 lines
;


/* Inserts into the Warehouses table */
INSERT INTO Warehouses (WarehouseID, Address, City, State, Zip, Phone, ClimateControl, SecurityGate)
VALUES
('WA-1', 'Kingsley Av', 'Utah', 'WA', 'H9S 1G2', '4384017088', 1, 1),
('OR-1', 'Presentation Av', 'Portland', 'OR', 'H9S 1G2', '43847771234', 0, 1),
('WY-1', 'Carson Av', 'Michigan', 'WY', 'H0H 0H0', '5147089999', 1, 0)
;


INSERT INTO Positions (PositionID, Title)
VALUES
    (1, 'CEO'),
    (2, 'CFO'),
    (3, 'IT Manager'),
    (4, 'Supply Chain Manager'),
    (5, 'Sales Manager'),
    (6, 'Sales Assistant'),
    (7, 'Administrative Manager'),
    (8, 'Administrative Assistant'),
    (9, 'Marketing Manager'),
    (10, 'Marketing Assistant'),
    (11, 'Accounting Manager'),
    (12, 'Accounting Assistant')
;

INSERT INTO Unitrentals(CUSTID, WAREHOUSEID, UNITID, DATEIN)
Values
    (38, 'WY-1', 10, 20160115)
;


/*   Select Command */
select *
from Customers
;

select *
from Drivers
;

select *
from Employees
;

select *
from Jobdetails
;


select *
from Joborders
;

select *
from Positions
;

select *
from Storageunits
;

select *
from Unitrentals
;

select *
from Vehicles
;

select *
from Warehouses
;


