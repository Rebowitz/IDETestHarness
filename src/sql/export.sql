--------------------------------------------------------
--  File created - Monday-June-09-2008   
--------------------------------------------------------

--------------------------------------------------------
--  DDL for Table TEST_METADATA
--------------------------------------------------------

  CREATE TABLE "RANDREWS"."TEST_METADATA" 
   (	"TEST_ID_FK2" NUMBER, 
	"RESP_MSG_TYPE" NUMBER, 
	"QUANTITY" NUMBER,
	"LOCATION" VARCHAR2(2)
   ) ;
 
--------------------------------------------------------
--  DDL for Table SPR
--------------------------------------------------------

  CREATE TABLE "RANDREWS"."SPR" 
   (	"TEST_ID_FK1" NUMBER(10,0), 
	"TEST _DESCRIPTION" VARCHAR2(100), 
	"MESSAGE_TYPE" NUMBER(10,0), 
	"LATITUDE" VARCHAR2(10), 
	"LONGITUDE" VARCHAR2(10), 
	"TIMESTAMP1" TIMESTAMP (6), 
	"SHIPBOURNE_EQUIPMENT_ID" VARCHAR2(25), 
	"ASP_ID" VARCHAR2(4), 
	"CSP_ID" VARCHAR2(4), 
	"MESSAGE_ID" VARCHAR2(25), 
	"REFERENCE_ID" VARCHAR2(25), 
	"MMSI_NUM" VARCHAR2(9), 
	"IMO_NUM" NUMBER(10,0), 
	"TIMESTAMP2" TIMESTAMP (6), 
	"TIMESTAMP3" TIMESTAMP (6), 
	"DC_ID" VARCHAR2(4), 
	"TIMESTAMP4" TIMESTAMP (6), 
	"TIMESTAMP5" TIMESTAMP (6), 
	"RESPONSE_TYPE" NUMBER(10,0), 
	"DATA_USER_REQUESTOR" VARCHAR2(4), 
	"SHIP_NAME" VARCHAR2(50), 
	"DATA_USER_PROVIDER" VARCHAR2(4), 
	"DDP_VERSION_NUM" VARCHAR2(256)
   ) ;
 
--------------------------------------------------------
--  DDL for Table TEST_MAIN
--------------------------------------------------------

  CREATE TABLE "RANDREWS"."TEST_MAIN" 
   (	"TEST_ID" NUMBER, 
	"MSG_NUM" NUMBER(38,0), 
	"MSG_TYPE" VARCHAR2(50), 
	"TEST_DESCRIPTION" VARCHAR2(100), 
	"ACTIVE_TEST" CHAR(1), 
	"SUCCESSFAIL" NUMBER
   ) ;
 
---------------------------------------------------
--   DATA FOR TABLE TEST_METADATA
--   FILTER = none used
---------------------------------------------------
-- INSERTING into TEST_METADATA

---------------------------------------------------
--   END DATA FOR TABLE TEST_METADATA
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE SPR
--   FILTER = none used
---------------------------------------------------
-- INSERTING into SPR

---------------------------------------------------
--   END DATA FOR TABLE SPR
---------------------------------------------------

---------------------------------------------------
--   DATA FOR TABLE TEST_MAIN
--   FILTER = none used
---------------------------------------------------
-- INSERTING into TEST_MAIN

---------------------------------------------------
--   END DATA FOR TABLE TEST_MAIN
---------------------------------------------------

--------------------------------------------------------
--  Constraints for Table TEST_MAIN
--------------------------------------------------------

  ALTER TABLE "RANDREWS"."TEST_MAIN" MODIFY ("TEST_ID" NOT NULL ENABLE);
 
  ALTER TABLE "RANDREWS"."TEST_MAIN" MODIFY ("MSG_NUM" NOT NULL ENABLE);
 
  ALTER TABLE "RANDREWS"."TEST_MAIN" MODIFY ("MSG_TYPE" NOT NULL ENABLE);
 
  ALTER TABLE "RANDREWS"."TEST_MAIN" MODIFY ("TEST_DESCRIPTION" NOT NULL ENABLE);
 
  ALTER TABLE "RANDREWS"."TEST_MAIN" MODIFY ("ACTIVE_TEST" NOT NULL ENABLE);
 
  ALTER TABLE "RANDREWS"."TEST_MAIN" ADD CONSTRAINT "TEST_MAIN_CHK1" CHECK (
ACTIVE_TEST IN ('Y', 'N')
) ENABLE;
 
  ALTER TABLE "RANDREWS"."TEST_MAIN" ADD CONSTRAINT "TEST_MAIN_PK" PRIMARY KEY ("TEST_ID") ENABLE;
 
--------------------------------------------------------
--  Constraints for Table SPR
--------------------------------------------------------

  ALTER TABLE "RANDREWS"."SPR" ADD CONSTRAINT "SPR_PK" PRIMARY KEY ("TEST_ID_FK1") ENABLE;
 
  ALTER TABLE "RANDREWS"."SPR" MODIFY ("TEST _DESCRIPTION" NOT NULL ENABLE);
 
  ALTER TABLE "RANDREWS"."SPR" MODIFY ("MESSAGE_TYPE" NOT NULL ENABLE);
 
  ALTER TABLE "RANDREWS"."SPR" MODIFY ("TIMESTAMP1" NOT NULL ENABLE);
 
  ALTER TABLE "RANDREWS"."SPR" MODIFY ("SHIPBOURNE_EQUIPMENT_ID" NOT NULL ENABLE);
 
  ALTER TABLE "RANDREWS"."SPR" MODIFY ("ASP_ID" NOT NULL ENABLE);
 
  ALTER TABLE "RANDREWS"."SPR" MODIFY ("CSP_ID" NOT NULL ENABLE);
 
  ALTER TABLE "RANDREWS"."SPR" MODIFY ("TEST_ID_FK1" NOT NULL ENABLE);
 
--------------------------------------------------------
--  Constraints for Table TEST_METADATA
--------------------------------------------------------

  ALTER TABLE "RANDREWS"."TEST_METADATA" MODIFY ("TEST_ID_FK2" NOT NULL ENABLE);
 
--------------------------------------------------------
--  DDL for Index TEST_MAIN_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "RANDREWS"."TEST_MAIN_PK" ON "RANDREWS"."TEST_MAIN" ("TEST_ID") 
  ;
 
--------------------------------------------------------
--  DDL for Index SPR_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "RANDREWS"."SPR_PK" ON "RANDREWS"."SPR" ("TEST_ID_FK1") 
  ;
 
--------------------------------------------------------
--  Ref Constraints for Table SPR
--------------------------------------------------------

  ALTER TABLE "RANDREWS"."SPR" ADD CONSTRAINT "SPR_TEST_MAIN_FK1" FOREIGN KEY ("TEST_ID_FK1")
	  REFERENCES "RANDREWS"."TEST_MAIN" ("TEST_ID") ENABLE;
 
--------------------------------------------------------
--  Ref Constraints for Table TEST_METADATA
--------------------------------------------------------

  ALTER TABLE "RANDREWS"."TEST_METADATA" ADD CONSTRAINT "TEST_METADATA_TEST_MAIN_FK1" FOREIGN KEY ("TEST_ID_FK2")
	  REFERENCES "RANDREWS"."TEST_MAIN" ("TEST_ID") ENABLE;
 