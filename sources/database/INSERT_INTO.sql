INSERT INTO TBL_PROJECT (PK_id, TXT_title, REAL_projectPrice, REAL_projectDeposite) VALUES (?,'Frankreich',100,200);
INSERT INTO TBL_PROJECT (PK_id, TXT_title, REAL_projectPrice, REAL_projectDeposite) VALUES (?,'Deutschland',200,300);

INSERT INTO TBL_GUEST (PK_id, ID_project, TXT_guestName) VALUES (?,1,'Kim');
INSERT INTO TBL_GUEST (PK_id, ID_project, TXT_guestName) VALUES (?,2,'Markus');

INSERT INTO TBL_OTHEREXPENSE (FK_id, REAL_spend, TXT_reason, TXT_when, ID_guest, ID_project) VALUES (?, 200, 'NotForFoodAndDrinks', '02/04/2013', 1, 1);
INSERT INTO TBL_OTHEREXPENSE (FK_id, REAL_spend, TXT_reason, TXT_when, ID_guest, ID_project) VALUES (?, 300, 'NotForFoodAndDrinks2', '02/04/2014', 2, 2);

INSERT INTO TBL_DRINKS (FK_id, INT_nights, ID_guest, ID_project) VALUES (?, 3, 1, 1);
INSERT INTO TBL_DRINKS (FK_id, INT_nights, ID_guest, ID_project) VALUES (?, 2, 2, 2);

INSERT INTO TBL_STAY (FK_id, INT_nights, ID_guest, ID_project) VALUES (?, 2, 1, 1);
INSERT INTO TBL_STAY (FK_id, INT_nights, ID_guest, ID_project) VALUES (?, 2, 2, 2);

INSERT INTO TBL_FOOD (FK_id, INT_nights, ID_guest, ID_project) VALUES (?, 2, 1, 1);
INSERT INTO TBL_FOOD (FK_id, INT_nights, ID_guest, ID_project) VALUES (?, 2, 2, 2);

INSERT INTO TBL_PREPAID (FK_id, REAL_prepaid, ID_guest, ID_project) VALUES (?, 200.0, 1, 1);
INSERT INTO TBL_PREPAID (FK_id, REAL_prepaid, ID_guest, ID_project) VALUES (?, 300.0, 2, 2);

INSERT INTO TBL_DRINKEXPENSE (FK_id, REAL_spend, TXT_reason, TXT_when, ID_guest, ID_project) VALUES (?, 100.0, 'Drink', '02/04/2013', 1, 1);
INSERT INTO TBL_DRINKEXPENSE (FK_id, REAL_spend, TXT_reason, TXT_when, ID_guest, ID_project) VALUES (?, 300.0, 'Drink', '02/04/2013', 1, 1);
INSERT INTO TBL_DRINKEXPENSE (FK_id, REAL_spend, TXT_reason, TXT_when, ID_guest, ID_project) VALUES (?, 500.0, 'Drink', '02/04/2013', 2, 2);
INSERT INTO TBL_DRINKEXPENSE (FK_id, REAL_spend, TXT_reason, TXT_when, ID_guest, ID_project) VALUES (?, 8000.0, 'Drink', '02/04/2013', 2, 2);
INSERT INTO TBL_FOODEXPENSE (FK_id, REAL_spend, TXT_reason, TXT_when, ID_guest, ID_project) VALUES (?, 200.0, 'Food', '02/04/2013', 2, 2);
INSERT INTO TBL_FOODEXPENSE (FK_id, REAL_spend, TXT_reason, TXT_when, ID_guest, ID_project) VALUES (?, 300.0, 'Food', '02/04/2013', 2, 2);
INSERT INTO TBL_FOODEXPENSE (FK_id, REAL_spend, TXT_reason, TXT_when, ID_guest, ID_project) VALUES (?, 400.0, 'Food', '02/04/2013', 1, 1);
INSERT INTO TBL_FOODEXPENSE (FK_id, REAL_spend, TXT_reason, TXT_when, ID_guest, ID_project) VALUES (?, 500.0, 'Food', '02/04/2013', 1, 1);