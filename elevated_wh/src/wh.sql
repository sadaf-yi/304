drop table Material CASCADE CONSTRAINTS;
drop table Container CASCADE CONSTRAINTS;
drop table RawMaterial CASCADE CONSTRAINTS;
drop table Label CASCADE CONSTRAINTS;
drop table Recipe_Uses CASCADE CONSTRAINTS;
drop table Recipe CASCADE CONSTRAINTS;
drop table Product CASCADE CONSTRAINTS;
drop table Build_Product CASCADE CONSTRAINTS;
drop table OrderProductProducesProduct CASCADE CONSTRAINTS;
drop table Reserves CASCADE CONSTRAINTS;
drop table Cust_Order CASCADE CONSTRAINTS;
drop table Customer CASCADE CONSTRAINTS;
drop table Filled_For CASCADE CONSTRAINTS;
drop table Placed_For CASCADE CONSTRAINTS;



create table Material
(matID integer not null,
matName varchar2(100) not null,
matStock integer,
matPrice integer,
matUnit varchar2(10),
primary key (matID));

grant select on Material to public;

create table Container
(matID integer not null,
volume integer not null,
primary key (matID));

grant select on Container to public;

create table RawMaterial
(matID integer not null,
potency varchar2(40) not null,
active varchar2(40) not null,
primary key (matID));

grant select on RawMaterial to public;

create table Label
(matID integer not null,
labelSize varchar2(40) not null,
primary key (matID));

grant select on Label to public;

create table Recipe
(recID integer not null,
procedure varchar2(1200) not null,
recName varchar2(100) not null,
primary key (recID));

grant select on Recipe to public;

create table Recipe_Uses
(recID integer not null,
matID integer not null,
quantity integer not null,
recUnit varchar2(10) not null,
primary key (recID, matID),
foreign key (matID) references Material,
foreign key (recID) references Recipe);

grant select on Recipe_Uses to public;

create table Product
(stockProduct integer default 0,
prodPrice integer not null,
prodID integer not null,
prodName varchar2(40) not null,
prodSize integer not null,
prodUnit varchar2(10),
primary key (prodID));

grant select on Product to public;

create table Build_Product
(prodID integer not null,
recID integer not null,
primary key (prodID),
foreign key (prodID) references Product,
foreign key (recID) references Recipe);

grant select on Build_Product to public;

create table Cust_Order
(orderID integer not null,
primary key (orderID));

grant select on Cust_Order to public;

-- following is the weak realationship set between Product-Produces-OrderProduct
-- this relationship takes orderID from
create table OrderProductProducesProduct
(dateupdated DATE not null,
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
foreign key (orderID) references Cust_Order);

grant select on Reserves to public;

create table Customer
(custID integer not null,
custName varchar2(100),
primary key (custID));

grant select on Customer to public;

-- Filled_For is the relationship between Product-Produces-OrderProduct and Order
create table Filled_For
(dateupdated DATE not null,
prodID integer not null,
orderID integer not null,
numFilled integer,
isShipped integer default 0,
primary key (orderID, prodID),
foreign key (prodID, dateupdated) references OrderProductProducesProduct(prodID, dateupdated),
foreign key (orderID) references Cust_Order,
check (isShipped >= 0 AND isShipped <= 1));

grant select on Filled_For to public;

-- Placed_For is the relationship between Order, Placed_For and Customer. It is a many-to-one relationship
-- So every order must have a customer, i.e. custID cannot be null

create table Placed_For
(orderID integer not null,
custID  integer not null,
primary key (orderID),
foreign key (custID) references Customer);

grant select on Placed_For to public;
