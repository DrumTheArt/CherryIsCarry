INSERT INTO TBL_HOUSE (PK_id, TXT_title, REAL_price, REAL_deposite) VALUES (?,'Frankreich',100,200);
INSERT INTO TBL_HOUSE (PK_id, TXT_title, REAL_price, REAL_deposite) VALUES (?,'Deutschland',200,300);

INSERT INTO TBL_GUEST (PK_id, ID_house, TXT_name) VALUES (?,1,'Kim');
INSERT INTO TBL_GUEST (PK_id, ID_house, TXT_name) VALUES (?,2,'Markus');

INSERT INTO TBL_EXPENSE (FK_id, REAL_spend, TXT_reason, TXT_when, ID_guest, ID_house) VALUES (?, 200, 'ForFoodAndDrinks', '02/04/2013', 1, 1);
INSERT INTO TBL_EXPENSE (FK_id, REAL_spend, TXT_reason, TXT_when, ID_guest, ID_house) VALUES (?, 300, 'ForFoodAndDrinks2', '02/04/2014', 2, 2);

INSERT INTO TBL_DRINKS (FK_id, INT_nights, ID_guest, ID_house) VALUES (?, 3, 1, 1);
INSERT INTO TBL_DRINKS (FK_id, INT_nights, ID_guest, ID_house) VALUES (?, 2, 2, 2);

INSERT INTO TBL_STAY (FK_id, INT_nights, ID_guest, ID_house) VALUES (?, 2, 1, 1);
INSERT INTO TBL_STAY (FK_id, INT_nights, ID_guest, ID_house) VALUES (?, 2, 2, 2);

INSERT INTO TBL_FOOD (FK_id, INT_nights, ID_guest, ID_house) VALUES (?, 2, 1, 1);
INSERT INTO TBL_FOOD (FK_id, INT_nights, ID_guest, ID_house) VALUES (?, 2, 2, 2);

INSERT INTO TBL_PREPAID (FK_id, REAL_prepaid, ID_guest, ID_house) VALUES (?, 200.0, 1, 1);
INSERT INTO TBL_PREPAID (FK_id, REAL_prepaid, ID_guest, ID_house) VALUES (?, 300.0, 2, 2);