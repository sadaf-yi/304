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


create table material
    (name varchar(40) not null,
    stock char(40) not null,
    materialid char(40) not null,
    price char(40) not null,
    volume char(40)  null,
    msize char(40)  null,
    potency char(40)  null,
    active char(40)  null,
    primary key (materialid));

grant select on material to public;


create table recipe
    (procedure varchar(1200) null,
    recid char(40) not null,
    primary key (recid));

grant select on recipe to public;

create table product
    (prodid varchar(40) not null,
    psize char(20) not null,
    price char(20) null,
    name varchar(40) not null,
    unit char(20) null,
    primary key (prodid, psize));

grant select on product to public;


create table customer
    (custid varchar(40) not null,
    custname char(40) not null,
    primary key (custid)
);

grant select on customer to public;

create table worder
    (orderid char(40) not null,
    quantity char(40) not null,
    primary key (orderid));

grant select on worder to public;


create table prodRecBuild
    (prbdid varchar(40) not null,
    prbsize char(20) not null,
    price char(20) null,
    name varchar(1200) null,
    recid char(40) null,
    primary key (prbsize , prbdid),
    foreign key (recid) references recipe(recid));

grant select on prodRecBuild to public;


create table orderPlacedFor
    (opforderid char(40) not null,
    quantity char(40) null,
    opfcustid varchar(40) not null,
    primary key (opforderid),
    foreign key (opfcustid) references customer(custid));

grant select on orderPlacedFor to public;

create table resCreate
    (rtime varchar(40) null,
    rcorderid char(40) null,
    rcid varchar(40) null,
    rcsize char(20) null,
    primary key (rcorderid , rcid , rcsize),
    foreign key (rcorderid) references orderPlacedFor (opforderid),
    foreign key (rcid , rcsize) references product (prodid , psize));

grant select on resCreate to public;

create table sProdFilled
    (dateupdated varchar(40) not null,
    spforderid char(40) not null,
    spfid varchar(40) not null,
    spfsize char(20) not null,
    primary key (dateupdated, spforderid, spfid , spfsize),
    foreign key (spfid, spfsize) references product (prodid, psize),
    foreign key (spforderid) references orderPlacedFor (opforderid));

grant select on sProdFilled to public;

create sequence matIdSeq;
create sequence recIdSeq;


insert into material
values('madarine oil', '10', matIdSeq.nextval, '2.99', null, null , 'x10', '1000');

insert into material
values('cinnamon honey oil', '20' ,matIdSeq.nextval ,'4.99' ,null,null ,'x10' ,'1000');

insert into material
values('bottle' ,'20' ,matIdSeq.nextval ,'1.99' ,'100',null ,null ,null);

insert into material
values('box' ,'20' ,matIdSeq.nextval ,'2.99' ,'200',null ,null ,null );

insert into material
values('label-100' ,'20' ,matIdSeq.nextval ,'2.99' ,null ,'10x10' ,null ,null);

insert into material
values('label-200' ,'20' ,matIdSeq.nextval ,'2.99' ,null ,'10x20' ,null ,null);

insert into material
values('label-400' ,'20' ,matIdSeq.nextval ,'2.99' ,null ,'20x20' ,null ,null);

insert into material
values('label-300' ,'20' ,matIdSeq.nextval ,'2.99' ,null ,'30x10' ,null ,null);

insert into material
values('label-1000' ,'20' ,matIdSeq.nextval ,'2.99' ,null ,'100x100' ,null ,null);



insert into recipe
values('1. chop the leaves fine 2. mix with queaty oil 3. boil for 10 minutes' ,'001');

insert into recipe
values('1. dry the leaves int he dryer 2. mix with water and ginger 3. refrigerate' ,'002');

insert into recipe
values('1. boil the queaty oils 2. mix with apple juice 3. refrigerate' ,'003');

insert into recipe
values('1. chop the leaves fine 2. mix with water 3. boil for 10 minutes' ,'004');

insert into recipe
values('1. mix water with madarine juice 2. mix with queaty oil 3. boil for 10 minutes' ,'005');


insert into product
values('001' ,'100' ,'120.00' ,'essential mandarine oil' ,'20');

insert into product
values('002' ,'250' ,'20.22' ,'queermiean oil' ,'220');

insert into product
values('003' ,'100' ,'35.00' ,'cucamber concentrate' ,'30');

insert into product
values('004' ,'20000' ,'42.55' ,'sunflower seeds' ,'100');

insert into product
values('005' ,'200' ,'450.22' ,'mineral avocado oil' ,'220');


insert into customer
values('100','yoo');

insert into customer
values('102','jackson');

insert into customer
values('103','henders');

insert into customer
values('104','yadegari');

insert into customer
values('105','holle');


insert into worder
values('001' ,'120');

insert into worder
values('002' ,'400');

insert into worder
values('003' ,'250');

insert into worder
values('004' , '100');

insert into worder
values('005' , '145');

insert into prodRecBuild
values('002', '100' , '10.99' , 'essential queermiean oil' , '001');

insert into prodRecBuild
values('003', '120' , '12.99' , 'essential ginger gozzin' , '002');

insert into prodRecBuild
values('004', '200' , '40.99' , 'seeds all around the world' , '003');

insert into prodRecBuild
values('004', '300' , '40.99' , 'poorin flower concentrate' , '004');

insert into prodRecBuild
values('005', '450' , '75.99' , 'golden flower aromatic skin therapy' , '005');

insert into orderPlacedFor
values('012' , '120' , '100');

insert into orderPlacedFor
values('013' , '150' , '102');

insert into orderPlacedFor
values('014' , '175' , '103');

insert into orderPlacedFor
values('015' , '190' , '104');

insert into orderPlacedFor
values('016' , '200' , '105');

insert into resCreate
values('015' , '014', '001' ,'100');

insert into resCreate
values('022' , '013','002' ,'250');

insert into resCreate
values('025', '015', '002' ,'250' );

insert into resCreate
values('017', '016', '001' ,'100');

insert into resCreate
values('019','016', '002' ,'250' );


insert into sProdFilled
values('12072015', '014' , '001' ,'100');

insert into sProdFilled
values('12072016', '013','002' ,'250');

insert into sProdFilled
values('01062015' ,'015' ,'003' ,'100');

insert into sProdFilled
values('09072016' , '016' ,'004' ,'20000');

insert into sProdFilled
values('10072016', '016','005' ,'200');












