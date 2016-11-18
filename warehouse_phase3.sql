drop table material cascade constraints;
drop table recipe cascade constraints;
drop table product cascade constraints;
drop table customer cascade constraints;
drop table worder cascade constraints;
drop table prodRecBuild cascade constraints;
drop table orderPlacedFor cascade constraints;
drop table resCreate cascade constraints;
drop table sProdFilled cascade constraints;
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

create table recipe_uses
    (recID char(40) not null,
    matID char(40) not null,
    quantity char(40) not null,
    primary key (recID, matID),
    foreign key (matID) references Material,
    foreign key (recID) references Recipe);

grant select on recipe_uses to public;

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

create table OrderProduct
    (dateupdated varchar(20) not null,
    quantityRes char(10) not null,
    primary key (prodID, dateUpdated),
    foreign key (prodID) references Product);


