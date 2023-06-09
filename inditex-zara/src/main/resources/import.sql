DROP TABLE PRICES;
DROP TABLE BRAND;
CREATE SEQUENCE PRICES_ID_SEQ INCREMENT BY 1;
CREATE SEQUENCE BRAND_ID_SEQ INCREMENT BY 1;

CREATE TABLE BRAND("ID" NUMBER(38,0) NOT NULL , "CODE" VARCHAR2(8 CHAR) NOT NULL ,  CONSTRAINT "BRAND_PK" PRIMARY KEY ("ID"));
CREATE TABLE PRICES( "ID" NUMBER(38,0) NOT NULL ,"BRAND_ID" NUMBER(38,0) NOT NULL ,"START_DATE" TIMESTAMP (6),"END_DATE" TIMESTAMP (6), "PRICE_LIST" NUMBER(38,0), "PRODUCT_ID" NUMBER(38,0), "PRIORITY" NUMBER(38,0), "PRICE" NUMBER(18,2), "CURR" VARCHAR2(8 CHAR), CONSTRAINT "PRICES_PK" PRIMARY KEY (ID));

ALTER TABLE PRICES ADD FOREIGN KEY (BRAND_ID) REFERENCES BRAND(ID);

INSERT INTO BRAND ("ID", "CODE") VALUES(BRAND_ID_SEQ.NEXTVAL,'ZARA');
INSERT INTO PRICES ("ID", "BRAND_ID", "START_DATE", "END_DATE","PRICE_LIST","PRODUCT_ID","PRIORITY","PRICE","CURR") VALUES(PRICES_ID_SEQ.NEXTVAL,1,  {ts '2020-06-14 00:00:00.00'},  {ts '2020-12-31 23:59:59.00'} ,1,35455,0,35.50,'EUR');
INSERT INTO PRICES ("ID", "BRAND_ID", "START_DATE", "END_DATE","PRICE_LIST","PRODUCT_ID","PRIORITY","PRICE","CURR") VALUES(PRICES_ID_SEQ.NEXTVAL,1,  {ts '2020-06-14 15:00:00.00'}, {ts '2020-06-14 18:30:00.00'},2,35455,1,25.45,'EUR');
INSERT INTO PRICES ("ID", "BRAND_ID", "START_DATE", "END_DATE","PRICE_LIST","PRODUCT_ID","PRIORITY","PRICE","CURR") VALUES(PRICES_ID_SEQ.NEXTVAL,1,  {ts '2020-06-15 00:00:00.00'}, {ts '2020-06-15 11:00:00.00'},3,35455,1,30.50,'EUR');
INSERT INTO PRICES ("ID", "BRAND_ID", "START_DATE", "END_DATE","PRICE_LIST","PRODUCT_ID","PRIORITY","PRICE","CURR") VALUES(PRICES_ID_SEQ.NEXTVAL,1,  {ts '2020-06-15 16:00:00.00'}, {ts '2020-12-31 23:59:59.00'},4,35455,1,38.95,'EUR');


