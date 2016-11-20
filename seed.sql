-- This is the seed file to populate our database with the information provided
-- by the owner of the actual shop whose warehouse we are modelling
-- in cases where data wasn't provided, we made up data (ie customers and orders)

-- populate the Product table with samples

insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct)
values(1,'Sativa Tincture',30,'mL',20,100),
    (2,'Indica Tincture',30,'mL',19,100),
    (3,'Extra Strength Tincture',30,'mL',50,100),
    (4,'Headache Rollon',10,'mL',40,100),
    (5,'Sleep Rollon',10,'mL',40,100),
    (6,'Cannabis Spray',200,'mL',80,100),
    (7,'30 CBD Tincture',30,'mL',40,100),
    (8,'100ml Cannabis Healing Salve',100,'mL',80,100),
    (9,'50ml Cannabis Healing Salve',50,'mL',45,100),
    (10,'15ml Cannabis Healing Salve',15,'mL',20,100);

-- populate the Order table with samples

-- populate the Recipe table with samples
insert into Recipe(recID, recName, procedure)
values(1,'Sativa Tincture','Add ingredients together at the same time. Mix ingredients together for 2 mins'),
    (2,'Indica Tincture','Add ingredients together at the same time. Mix ingredients together for 2 mins'),
    (3,'Extra Strength Tincture','Add ingredients together at the same time. Mix ingredients together for 4 mins'),
    (4,'Headache Rollon','Add ingredients together at the same time. Mix ingredients together for 5 mins'),
    (5,'Sleep Rollon','Add ingredients together at the same time. Mix ingredients together for 2 mins'),
    (6,'Cannabis Spray','Add ingredients together at the same time. Mix ingredients together for 9 mins'),
    (7,'30 CBD Tincture','Add ingredients together at the same time. Mix ingredients together for 7 mins'),
    (8,'100ml Cannabis Healing Salve','Add ingredients together at the same time. Mix ingredients together for 9 mins'),
    (9,'50ml Cannabis Healing Salve','Add ingredients together at the same time. Mix ingredients together for 5 mins'),
    (10,'15ml Cannabis Healing Salve','Add ingredients together at the same time. Mix ingredients together for 3 mins');

-- populate the Customer table with samples
insert into Customer(custID,custName)
values(1,'Snoop Dogg'),
    (2,'Martha Stewart'),
    (3,'Barack Obama'),
    (4,'Carl Sagan'),
    (5,'Joe Rogan');

-- populate the Material table with samples
insert into Material(matID,matName,matStock,matUnit,matPrice)
values(1,'coconut oil',20,'L',5),
    (2,'castor oil',20,'L',5),
    (3,'calendula oil',5,'L',20),
    (4,'sunflower oil',50,'L',10),
    (5,'cannabis oil sativa',2,'kg',200),
    (6,'cannabis oil indica',2,'kg',200),
    (7,'cannabis oil pink kush',2,'kg',300),
    (8,'cannabis infused coconut oil',2,'L',500),
    (9,'CBD infused coconut oil',5,'L',500),
    (10,'pure cbd oil',1,'L',500),
    (11,'essential oil mix',2,'L',100),
    (12,'essential oil premix (headache)',2,'L',100),
    (13,'essential oil premix (sleep)',2,'L',100),
    (14,'beeswax',1,'kg',75),
    (15,'honey',10,'L',45),
    (16,'distilled water',50,'L',10),
    (17,'pure ethanol',20,'L',100),
    (18,'amber 30ml glass bottle',50,'bottles',1),
    (19,'10 ml glass roll-on bottle',60,'bottles',1),
    (20,'plastic 200ml bottle spray',25,'bottles',1),
    (21,'blue cobalt glass bottle',13,'bottles',3),
    (22,'label large',200,'labels',2),
    (23,'label small',150,'labels',2);

-- populate the Container table with samples
insert into Container(matID,volume)
values(18,30),
    (19,10),
    (20,200),
    (21,30);

-- populate the RawMaterial table with samples
insert into RawMaterial(matID,potency,active)
values(5,'high','cannabis sativa'),
    (6,'high','cannabis indica'),
    (7,'high','cannabis pink kush'),
    (8,'10%','cannabis'),
    (9,'10%','CBD'),
    (10,'100%','CBD');

-- populate the Label table with samples
insert into Label(matID,labelSize)
values(22,'large'),
    (23,'small');

-- populate the Recipe_Uses table with samples
insert into Recipe_Uses(recID,matID,quantity,recUnit)
values(1,1,30,'mL'),
    (1,5,400,'mg'),
    (1,18,1,'bottle'),
    (8,14,10,'g'),
    (8,11,2,'mL'),
    (8,1,70,'mL'),
    (8,2,2,'mL'),
    (8,3,3,'mL'),
    (8,9,10,'mL'),
    (9,14,5,'g'),
    (9,11,1,'mL'),
    (9,1,35,'mL'),
    (9,2,1,'mL'),
    (9,3,1.5,'mL'),
    (9,9,5,'mL'),
    (10,14,1.5,'g'),
    (10,11,0.3,'mL'),
    (10,1,10.5,'mL'),
    (10,2,0.3,'mL'),
    (10,3,0.45,'mL'),
    (10,9,1.5,'mL'),
    (2,1,30,'mL'),
    (2,6,400,'mg'),
    (2,18,1,'bottle'),
    (3,1,30,'mL'),
    (3,7,400,'mg'),
    (3,18,1,'bottle'),
    (4,19,1,'bottle'),
    (4,8,5,'mL'),
    (4,4,3,'mL'),
    (4,12,2,'mL'),
    (5,19,1,'bottle'),
    (5,8,5,'mL'),
    (5,4,3,'mL'),
    (5,13,2,'mL'),
    (6,20,1,'bottle'),
    (6,17,13,'mL'),
    (6,16,3,'mL'),
    (6,15,2,'mL'),
    (6,6,1,'g'),
    (7,10,400,'mg'),
    (7,1,30,'mL'),
    (7,21,1,'bottle');

-- populate the OrderProductProducesProduct table with samples
insert into OrderProductProducesProduct(dateupdated,quantityRes,prodID)
values(TO_DATE('19-NOV-16 12:56 P.M.','DD-MON-YY HH:MI P.M.'),5,1),
    (TO_DATE('19-NOV-16 15:34 P.M.','DD-MON-YY HH:MI P.M.'),5,3),
    (TO_DATE('19-NOV-16 10:42 A.M.','DD-MON-YY HH:MI A.M.'),20,2),
    (TO_DATE('19-NOV-16 14:30 P.M.','DD-MON-YY HH:MI P.M.'),17,7),
    (TO_DATE('19-NOV-16 13:56 P.M.','DD-MON-YY HH:MI P.M.'),4,6);

-- populate the Reserves table with samples
insert into Reserves(prodID,orderID,numProd)
values(1,1,5),
    (3,2,5),
    (2,3,20),
    (7,4,17),
    (6,5,4);

-- populate the Filled_For table with samples
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped)
values(TO_DATE('19-NOV-16 12:57 P.M.','DD-MON-YY HH:MI P.M.'),1,5,0),
    (TO_DATE('19-NOV-16 15:35 P.M.','DD-MON-YY HH:MI P.M.'),3,2,5,0),
    (TO_DATE('19-NOV-16 10:43 A.M.','DD-MON-YY HH:MI A.M.'),2,3,13,0),
    (TO_DATE('19-NOV-16 14:31 P.M.','DD-MON-YY HH:MI P.M.'),7,4,17,0),
    (TO_DATE('19-NOV-16 13:57 P.M.','DD-MON-YY HH:MI P.M.'),6,5,4,0);

-- populate the Placed_For table with samples
insert into Placed_For(orderID,custID)
values(1,5),
    (2,3),
    (3,4),
    (4,2),
    (5,1);