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



create table Material
    (matID integer not null,
    matName varchar(100) not null,
    matStock float default 0.0,
    matPrice integer not null,
    matUnit varchar(7)  null,
    primary key (matID));

grant select on Material to public;

create table Container
    (matID integer not null,
    volume varchar(40) not null,
    primary key (matID));

grant select on Container to public;

create table RawMaterial
    (matID integer not null,
    potency varchar(40) not null,
    active varchar(40) not null,
    primary key (matID));

grant select on RawMaterial to public;

create table Label
    (matID integer not null,
    labelSize varchar(40) not null,
    primary key (matID));

grant select on Label to public;

create table Recipe_Uses
    (recID integer not null,
    matID integer not null,
    quantity integer not null,
    recUnit char(2) not null,
    primary key (recID, matID),
    foreign key (matID) references Material,
    foreign key (recID) references Recipe);

grant select on Recipe_Uses to public;

create table Recipe
    (recID integer not null,
    procedure varchar(1200) not null,
    recName varchar (100) not null,
    primary key (recID));

grant select on Recipe to public;

create table Product
    (stockProduct integer default 0,
    prodPrice integer not null,
    prodID integer not null,
    prodName varchar(40) not null,
    prodSize varchar(40) not null,
    prodUnit char(2),
    primary key (prodID));

grant select on Product to public;


create table Order
    (orderID integer not null,
    primary key (orderID));

grant select on Order to public;

-- following is the weak realationship set between Product-Produces-OrderProduct
-- this relationship takes orderID from
create table OrderProductProducesProduct
    (dateupdated varchar(20) not null,
    quantityRes integer not null,
    prodID integer not null,
    primary key (prodID, dateUpdated),
    foreign key (prodID) references Product);

grant select on OrderProductProducesProduct to public;

create table Reserves
    (prodID integer not null,
    orderID integer not null,
    numProd integer not null,
    primary key (prodID, orderID),
    foreign key (prodID) references Product,
    foreign key (orderID) references Order);

grant select on Reserves to public;

create table Customer
    (custID integer not null,
    custName varchar (100),
    primary key (custID));

grant select on Customer to public;

-- Filled_For is the relationship between Product-Produces-OrderProduct and Order
create table Filled_For
    (dateupdated varchar(20) not null,
    prodID integer not null,
    orderID varchar(40) not null,
    numFilled integer,
    isShipped integer default 0,
    primary key (orderID),
    foreign key (dateupdated, prodID) references OrderProductProducesProduct,
    foreign key (orderID) references Order,
    check (isShipped >= 0 AND isShipped <= 1));

grant select on Filled_For to public;

-- Placed_For is the relationship between Order, Placed_For and Customer. It is a many-to-one relationship
-- So every order must have a customer, i.e. custID cannot be null

create table Placed_For
    (orderID varchar(40) not null,
    custID  varchar(40) not null,
    primary key (orderID),
    foreign key (custID) references Customer);

grant select on Placed_For to public;






