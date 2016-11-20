drop table Material cascade constraints;
drop table Container cascade constraints;
drop table RawMaterial cascade constraints;
drop table Label cascade constraints;
drop table Recipe_Uses cascade constraints;
drop table Recipe cascade constraints;
drop table Product cascade constraints;
drop table OrderProductProducesProduct cascade constraints;
drop table Reserves cascade constraints;
drop table Order cascade constraints;
drop table Customer cascade constraints;
drop table Filled_For cascade constraints;
drop table Placed_For cascade constraints;
drop sequence matIdSeq;
drop sequence recIdSeq;


create table Material
    (matID char(40) not null,
    matName varchar(40) not null,
    matStock char(40) not null,
    matPrice char(40) not null,
    matUnit char(40)  null,
    primary key (matID));

grant select on Material to public;

create table Container
    (matID char(40) not null,
    volume varchar(40) not null,
    primary key (matID));

grant select on Container to public;

create table RawMaterial
    (matID char(40) not null,
    potency varchar(40) not null,
    active char(40) not null,
    primary key (matID));

grant select on RawMaterial to public;

create table Label
    (matID char(40) not null,
    labelSize char(40) not null,
    primary key (matID));

grant select on Label to public;

create table Recipe_Uses
    (recID char(40) not null,
    matID char(40) not null,
    quantity char(40) not null,
    primary key (recID, matID),
    foreign key (matID) references Material,
    foreign key (recID) references Recipe);

grant select on Recipe_Uses to public;

create table Recipe
    (recID char(40) not null,
    procedure varchar(1200) null,
    primary key (recID));

grant select on Recipe to public;

create table Product
    (stockProduct varchar(100),
    prodPrice varchar(40), not null,
    prodID varchar(40) not null,
    prodName varchar(40) not null,
    prodSize varchar(40) not null,
    prodUnit char(20) null,
    primary key (prodID));

grant select on Product to public;


-- following is the weak realationship set between Product-Produces-OrderProduct
create table OrderProductProducesProduct
    (dateupdated varchar(20) not null,
    quantityRes char(10) not null,
    prodID varchar(40) not null,
    primary key (prodID, dateUpdated),
    foreign key (prodID) references Product);

grant select on OrderProductProducesProduct to public;

create table Reserves
    (prodID varchar(40) not null,
    orderID varchar(40) not null,
    numProd varchar(10) not null,
    primary key (prodID, orderID),
    foreign key (prodID) references Product,
    foreign key (orderID) references Order);

grant select on Reserves to public;


create table Order
    (orderID varchar(40) not null,
    primary key (orderID));

grant select on Order to public;

create table Customer
    (custID varchar(40) not null,
    custName varchar (100),
    primary key (custID));

grant select on Customer to public;

-- Filled_For is the relationship between Product-Produces-OrderProduct and Order
create table Filled_For
    (dateupdated varchar(20) not null,
    prodID varchar(40) not null,
    orderID varchar(40) not null,
    numFilled varchar(10),
    isShipped integer default 0,
    primary key (dateupdated, prodID, orderID),
    foreign key (dateupdated, prodID) references OrderProductProducesProduct,
    foreign key (orderID) references Order,
    check (isShipped >= 0 AND isShipped <= 1));

grant select on Filled_For to public;

-- Placed_For is the relationship between Order, Placed_For and Customer. It is a many-to-one relationship
-- So every order must have a customer, i.e. custID cannot be null

create table Placed_For
    (orderID varchar(40),
    custID  varchar(40) not null,
    primary key (orderID),
    foreign key (custID) references Customer);

grant select on Placed_For to public;





