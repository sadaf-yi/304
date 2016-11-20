-- This is the seed file to populate our database with the information provided
-- by the owner of the actual shop whose warehouse we are modelling
-- in cases where data wasn't provided, we made up data (ie customers and orders)

-- populate the Product table with samples

insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(1,'Sativa Tincture',30,'mL',20,100);
insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(2,'Indica Tincture',30,'mL',19,100);
insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(3,'Extra Strength Tincture',30,'mL',50,100);
insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(4,'Headache Rollon',10,'mL',40,100);
insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(5,'Sleep Rollon',10,'mL',40,100);
insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(6,'Cannabis Spray',200,'mL',80,100);
insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(7,'30 CBD Tincture',30,'mL',40,100);
insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(8,'100ml Cannabis Healing Salve',100,'mL',80,100);
insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(9,'50ml Cannabis Healing Salve',50,'mL',45,100);
insert into Product(prodID, prodName, prodSize, prodUnit, prodPrice, stockProduct) values(10,'15ml Cannabis Healing Salve',15,'mL',20,100);

-- populate the Order table with samples

-- populate the Recipe table with samples
insert into Recipe(recID, recName, procedure) values(1,'Sativa Tincture','Add ingredients together at the same time. Mix ingredients together for 2 mins');
insert into Recipe(recID, recName, procedure) values(2,'Indica Tincture','Add ingredients together at the same time. Mix ingredients together for 2 mins');
insert into Recipe(recID, recName, procedure) values(3,'Extra Strength Tincture','Add ingredients together at the same time. Mix ingredients together for 4 mins');
insert into Recipe(recID, recName, procedure) values(4,'Headache Rollon','Add ingredients together at the same time. Mix ingredients together for 5 mins');
insert into Recipe(recID, recName, procedure) values(5,'Sleep Rollon','Add ingredients together at the same time. Mix ingredients together for 2 mins');
insert into Recipe(recID, recName, procedure) values(6,'Cannabis Spray','Add ingredients together at the same time. Mix ingredients together for 9 mins');
insert into Recipe(recID, recName, procedure) values(7,'30 CBD Tincture','Add ingredients together at the same time. Mix ingredients together for 7 mins');
insert into Recipe(recID, recName, procedure) values(8,'100ml Cannabis Healing Salve','Add ingredients together at the same time. Mix ingredients together for 9 mins');
insert into Recipe(recID, recName, procedure) values(9,'50ml Cannabis Healing Salve','Add ingredients together at the same time. Mix ingredients together for 5 mins');
insert into Recipe(recID, recName, procedure) values(10,'15ml Cannabis Healing Salve','Add ingredients together at the same time. Mix ingredients together for 3 mins');

-- populate the Customer table with samples
insert into Customer(custID,custName) values(1,'Snoop Dogg');
insert into Customer(custID,custName) values(2,'Martha Stewart');
insert into Customer(custID,custName) values(3,'Barack Obama');
insert into Customer(custID,custName) values(4,'Carl Sagan');
insert into Customer(custID,custName) values(5,'Joe Rogan');

-- populate the Material table with samples
insert into Material(matID,matName,matStock,matUnit,matPrice) values(1,'coconut oil',20,'L',5);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(2,'castor oil',20,'L',5);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(3,'calendula oil',5,'L',20);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(4,'sunflower oil',50,'L',10);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(5,'cannabis oil sativa',2,'kg',200);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(6,'cannabis oil indica',2,'kg',200);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(7,'cannabis oil pink kush',2,'kg',300);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(8,'cannabis infused coconut oil',2,'L',500);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(9,'CBD infused coconut oil',5,'L',500);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(10,'pure cbd oil',1,'L',500);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(11,'essential oil mix',2,'L',100);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(12,'essential oil premix (headache)',2,'L',100);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(13,'essential oil premix (sleep)',2,'L',100);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(14,'beeswax',1,'kg',75);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(15,'honey',10,'L',45);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(16,'distilled water',50,'L',10);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(17,'pure ethanol',20,'L',100);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(18,'amber 30ml glass bottle',50,'bottles',1);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(19,'10 ml glass roll-on bottle',60,'bottles',1);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(20,'plastic 200ml bottle spray',25,'bottles',1);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(21,'blue cobalt glass bottle',13,'bottles',3);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(22,'label large',200,'labels',2);
insert into Material(matID,matName,matStock,matUnit,matPrice) values(23,'label small',150,'labels',2);

-- populate the Container table with samples
insert into Container(matID,volume) values(18,30);
insert into Container(matID,volume) values(19,10);
insert into Container(matID,volume) values(20,200);
insert into Container(matID,volume) values(21,30);

-- populate the RawMaterial table with samples
insert into RawMaterial(matID,potency,active) values(5,'high','cannabis sativa');
insert into RawMaterial(matID,potency,active) values(6,'high','cannabis indica');
insert into RawMaterial(matID,potency,active) values(7,'high','cannabis pink kush');
insert into RawMaterial(matID,potency,active) values(8,'10%','cannabis');
insert into RawMaterial(matID,potency,active) values(9,'10%','CBD');
insert into RawMaterial(matID,potency,active) values(10,'100%','CBD');

-- populate the Label table with samples
insert into Label(matID,labelSize) values(22,'large');
insert into Label(matID,labelSize) values(23,'small');

-- populate the Recipe_Uses table with samples
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(1,1,30,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(1,5,400,'mg');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(1,18,1,'bottle');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(8,14,10,'g');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(8,11,2,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(8,1,70,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(8,2,2,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(8,3,3,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(8,9,10,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(9,14,5,'g');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(9,11,1,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(9,1,35,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(9,2,1,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(9,3,1.5,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(9,9,5,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(10,14,1.5,'g');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(10,11,0.3,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(10,1,10.5,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(10,2,0.3,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(10,3,0.45,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(10,9,1.5,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(2,1,30,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(2,6,400,'mg');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(2,18,1,'bottle');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(3,1,30,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(3,7,400,'mg');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(3,18,1,'bottle');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(4,19,1,'bottle');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(4,8,5,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(4,4,3,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(4,12,2,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(5,19,1,'bottle');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(5,8,5,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(5,4,3,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(5,13,2,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(6,20,1,'bottle');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(6,17,13,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(6,16,3,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(6,15,2,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(6,6,1,'g');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(7,10,400,'mg');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(7,1,30,'mL');
insert into Recipe_Uses(recID,matID,quantity,recUnit) values(7,21,1,'bottle');

-- populate the OrderProductProducesProduct table with samples
insert into OrderProductProducesProduct(dateupdated,quantityRes,prodID) values(TO_DATE('19-NOV-16 12:56 P.M.','DD-MON-YY HH:MI P.M.'),5,1);
insert into OrderProductProducesProduct(dateupdated,quantityRes,prodID) values(TO_DATE('19-NOV-16 15:34 P.M.','DD-MON-YY HH:MI P.M.'),5,3);
insert into OrderProductProducesProduct(dateupdated,quantityRes,prodID) values(TO_DATE('19-NOV-16 10:42 A.M.','DD-MON-YY HH:MI A.M.'),20,2);
insert into OrderProductProducesProduct(dateupdated,quantityRes,prodID) values(TO_DATE('19-NOV-16 14:30 P.M.','DD-MON-YY HH:MI P.M.'),17,7);
insert into OrderProductProducesProduct(dateupdated,quantityRes,prodID) values(TO_DATE('19-NOV-16 13:56 P.M.','DD-MON-YY HH:MI P.M.'),4,6);

-- populate the Reserves table with samples
insert into Reserves(prodID,orderID,numProd) values(1,1,5);
insert into Reserves(prodID,orderID,numProd) values(3,2,5);
insert into Reserves(prodID,orderID,numProd) values(2,3,20);
insert into Reserves(prodID,orderID,numProd) values(7,4,17);
insert into Reserves(prodID,orderID,numProd) values(6,5,4);

-- populate the Filled_For table with samples
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 12:57 P.M.','DD-MON-YY HH:MI P.M.'),1,5,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 15:35 P.M.','DD-MON-YY HH:MI P.M.'),3,2,5,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 10:43 A.M.','DD-MON-YY HH:MI A.M.'),2,3,13,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 14:31 P.M.','DD-MON-YY HH:MI P.M.'),7,4,17,0);
insert into Filled_For(dateupdated,prodID,orderID,numFilled,isShipped) values(TO_DATE('19-NOV-16 13:57 P.M.','DD-MON-YY HH:MI P.M.'),6,5,4,0);

-- populate the Placed_For table with samples
insert into Placed_For(orderID,custID) values(1,5);
insert into Placed_For(orderID,custID) values(2,3);
insert into Placed_For(orderID,custID) values(3,4);
insert into Placed_For(orderID,custID) values(4,2);
insert into Placed_For(orderID,custID) values(5,1);