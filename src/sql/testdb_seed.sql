
   CREATE TABLE "RANDREWS"."TESTMAIN" 
   (	"TEST_ID" NUMBER(10,0), 
	"MSG_TYPE" VARCHAR2(50 CHAR), 
	"TEST_DESCRIPTION" VARCHAR2(100 CHAR), 
	"ACTIVE_TEST" VARCHAR2(1 CHAR), 
	"SUCCESSFAIL" NUMBER(10,0)
   ) ;
 
  CREATE TABLE "RANDREWS"."TEST_METADATA" 
   (	"TEST_ID" NUMBER(19,0), 
	"MSG_TYPE_CODE" NUMBER(10,0), 
	"QUANTITY" NUMBER(10,0),
	"LOCATION" VARCHAR2(2)
   ) ;
 
  CREATE TABLE "RANDREWS"."SPR" 
   (	"TEST_ID" NUMBER(10,0), 
	"TEST_DESCRIPTION" VARCHAR2(100 CHAR), 
	"MESSAGE_TYPE" NUMBER(10,0), 
	"LATITUDE" VARCHAR2(11 CHAR), 
	"LONGITUDE" VARCHAR2(12 CHAR), 
	"TIMESTAMP1" VARCHAR2(19 CHAR), 
	"SHIPBORNE_EQUIPMENT_ID" VARCHAR2(25 CHAR), 
	"ASP_ID" VARCHAR2(4 CHAR), 
	"CSP_ID" VARCHAR2(4 CHAR), 
	"MESSAGE_ID" VARCHAR2(25 CHAR), 
	"REFERENCE_ID" VARCHAR2(25 CHAR), 
	"MMSI_NUM" VARCHAR2(9 CHAR), 
	"IMO_NUM" VARCHAR2(255 CHAR), 
	"TIMESTAMP2" VARCHAR2(19 CHAR), 
	"TIMESTAMP3" VARCHAR2(19 CHAR), 
	"DC_ID" VARCHAR2(4 CHAR), 
	"TIMESTAMP4" VARCHAR2(19 CHAR), 
	"TIMESTAMP5" VARCHAR2(19 CHAR), 
	"RESPONSE_TYPE" NUMBER(10,0), 
	"DATA_USER_REQUESTOR" VARCHAR2(7 CHAR), 
	"SHIP_NAME" VARCHAR2(50 CHAR), 
	"DDP_VERSION_NUM" VARCHAR2(4 CHAR), 
	"DATA_USER_PROVIDER" VARCHAR2(31)
   ) ;

Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (2,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (3,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (4,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (5,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (6,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (7,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (8,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (9,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (10,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (11,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (12,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (13,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (14,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (15,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (16,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (17,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (18,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (19,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (20,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (21,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (22,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (23,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (24,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (25,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (26,'SPR',null,'Y',0);
Insert into TESTMAIN (TEST_ID,MSG_TYPE,TEST_DESCRIPTION,ACTIVE_TEST,SUCCESSFAIL) values (1,'SPR','Valid SPR','Y',0);

Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (1,1,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (1,1,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (2,1,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (2,1,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (3,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (3,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (4,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (4,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (5,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (5,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (6,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (6,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (7,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (7,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (8,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (8,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (9,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (9,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (10,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (10,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (11,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (11,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (12,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (12,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (13,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (13,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (14,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (14,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (15,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (15,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (16,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (16,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (17,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (17,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (18,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (18,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (19,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (19,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (20,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (20,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (21,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (21,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (22,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (22,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (23,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (23,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (24,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (24,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (25,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (25,7,1,'db');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (26,7,1,'fs');
Insert into TEST_METADATA (TEST_ID,MSG_TYPE_CODE,QUANTITY,LOCATION) values (26,7,1,'db');


Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (2,null,1,'46.36.05.S','062.31.91.E','2002-07-21T06:45:55','932705785','0099','0199','00992002072106455500005',null,'791745329','7738591','2002-07-21T06:45:56','2002-07-21T06:45:57','3001','2002-07-21T06:45:58','2002-07-21T06:45:59',4,'3000','MELVILLE WECB USA','1:0','0022');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (3,null,1,'09.21.74.N','092.48.36.W','2005-12-01T02:11:46','744974103','0099','0199','00992005120102114600001',null,'276624465','9165293','2005-12-01T02:11:47','2005-12-01T02:11:48','3001','2005-12-01T02:11:49','2005-12-01T02:11:50',1,'ABADDUR','OVERSEAS MAREMAR WDC6975 USA','1:0','0022');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (4,null,1,'31.40.81.S','102.43.64.W','2004-08-23T20:15:44','937167688','0099','0199','00992004082320154400002',null,'451449223','7390521','2004-08-23T20:15:45','2004-08-23T20:15:46','3001','2004-08-23T20:15:47','2004-08-23T20:15:48',1,'3000','OVERSEAS WASHINGTON WFGV USA','9:9','0022');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (5,null,1,'35.46.08.S','065.03.83.W','2010-02-16T07:56:25','883080418','0099','0199','00992010021607562500003',null,'712973002','8003280','2010-02-16T07:56:26','2010-02-16T07:56:27','3001','2010-02-16T07:56:28','2010-02-16T07:56:29',1,'3000','VALIANT WCY6766 USA','1:0','0099');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (6,null,1,'31.42.47.S','158.22.79.W','2004-05-10T09:28:37','286914867','0099','0199','00992004051009283700004',null,'206700758','9056258','2004-05-10T09:28:38','2004-05-10T09:28:39','3001','2004-05-10T09:28:40','2004-05-10T09:28:41',1,'3000','GALE WIND WAZ9548 USA','1:0','%nk138)');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (7,null,1,'46.36.05.S','062.31.91.E','2002-07-21T06:45:55','932705785','0099','0199','00992002072106455500005',null,'791745329','7738591','2002-07-21T06:45:56','2002-07-21T06:45:57','3001','2002-07-21T06:45:58','2002-07-21T06:45:59',4,'3000','MELVILLE WECB USA','1:0','0022');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (8,null,1,'58.39.40.N','051.59.73.E','2001-04-05T02:05:21','791238879','0099','0199','00992001040502052100006',null,'342089160','9077276','2001-04-05T02:05:22','2001-04-05T02:05:23','3001','2001-04-05T02:05:24','2001-04-05T02:05:25',4,'ABADDUR','APL PHILIPPINES WCX8884 USA','1:0','0022');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (9,null,1,'52.30.68.N','024.11.84.W','2005-10-24T02:06:14','387995108','0099','0199','00992005102402061400007',null,'843186409','7733307','2005-10-24T02:06:15','2005-10-24T02:06:16','3001','2005-10-24T02:06:17','2005-10-24T02:06:18',4,'3000','STORMY SEA WSB7864 USA','9:9','0022');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (10,null,1,'10.38.81.S','110.01.01.W','2006-04-27T10:17:42','264941592','0099','0199','00992006042710174200008',null,'179520468','7912123','2006-04-27T10:17:43','2006-04-27T10:17:44','3001','2006-04-27T10:17:45','2006-04-27T10:17:46',4,'3000','MAJ STEPHEN W PLESS WHAU USA','1:0','0099');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (11,null,1,'50.56.43.N','122.49.10.E','2006-08-27T07:50:26','99231645','0099','0199','00992006082707502600009',null,'221753295','9106209','2006-08-27T07:50:27','2006-08-27T07:50:28','3001','2006-08-27T07:50:29','2006-08-27T07:50:30',4,'3000','SEA-LAND METEOR WDB9951 USA','1:0','Gobbledegook');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (12,null,2,'64.26.19.N','025.20.21.W','2009-05-05T19:44:25','237226353','0099','0199','00992009050519442500010',null,'840435167','9244673','2009-05-05T19:44:26','2009-05-05T19:44:27','3001','2009-05-05T19:44:28','2009-05-05T19:44:29',1,'3000','ALASKAN NAVIGATOR WDC6644 USA','1:0','0022');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (13,null,2,'07.48.59.S','145.51.25.W','2006-05-13T19:03:44','901023106','0099','0199','00992006051319034400011',null,'861931121','7223314','2006-05-13T19:03:45','2006-05-13T19:03:46','3001','2006-05-13T19:03:47','2006-05-13T19:03:48',1,'ABADDUR','CAPE MOHICAN WDOP USA','1:0','0022');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (14,null,2,'69.01.56.N','091.17.59.W','2001-06-07T21:34:45','98384901','0099','0199','00992001060721344500012',null,'146651631','8835231','2001-06-07T21:34:46','2001-06-07T21:34:47','3001','2001-06-07T21:34:48','2001-06-07T21:34:49',1,'3000','KA'' IMIMOANA WTEU USA','9:9','0022');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (15,null,2,'69.39.78.S','173.20.09.W','2000-02-14T16:51:47','28401898','0099','0199','00992000021416514700013',null,'763811025','1002349','2000-02-14T16:51:48','2000-02-14T16:51:49','3001','2000-02-14T16:51:50','2000-02-14T16:51:51',1,'3000','PRIDE OF BALTIMORE II WUW2120 U','1:0','0999');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (16,null,2,'72.41.28.S','070.11.89.W','2008-12-16T20:41:53','565754337','0099','0199','00992008121620415300014',null,'064254088','8993227','2008-12-16T20:41:54','2008-12-16T20:41:55','3001','2008-12-16T20:41:56','2008-12-16T20:41:57',1,'3000','NANCY FOSTER WTER USA','1:0','86t');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (17,null,2,'91.01.00.S','001.37.91.E','2006-09-18T08:23:48','18833152','0099','0199','00992006091808234800015',null,'940590177','6728068','2006-09-18T08:23:49','2006-09-18T08:23:50','3001','2006-09-18T08:23:51','2006-09-18T08:23:52',4,'3000','OREGON II WTDO USA','1:0','0022');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (18,null,2,'18.35.08.S','158.30.81.W','2008-05-08T16:31:06','371700756','0099','0199','00992008050816310600016',null,'335665979','1003524','2008-05-08T16:31:07','2008-05-08T16:31:08','3001','2008-05-08T16:31:09','2008-05-08T16:31:10',4,'8888','SEAHORSE II WDB 7459 USA','1:0','0022');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (19,null,2,'42.15.23.S','045.30.61.W','2005-07-24T21:33:11','188220497','0099','0199','00992005072421331100017',null,'231908466','8616934','2005-07-24T21:33:12','2005-07-24T21:33:13','3001','2005-07-24T21:33:14','2005-07-24T21:33:15',4,'3000','PRESIDENT ADAMS WRYW USA','9:9','0022');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (20,null,2,'61.43.29.S','004.15.19.E','2007-11-22T05:23:08','151192900','0099','0199','00992007112205230800018',null,'614209219','8121795','2007-11-22T05:23:09','2007-11-22T05:23:10','3001','2007-11-22T05:23:11','2007-11-22T05:23:12',4,'3000','MICHIGAN WRB4141 USA','1:0','0674');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (21,null,2,'10.55.88.N','061.51.05.E','2003-09-15T17:50:41','250636471','0099','0199','00992003091517604100019',null,'943802456','7226689','2003-09-15T17:50:42','2003-09-15T17:50:43','3001','2003-09-15T17:50:44','2003-09-15T17:50:45',4,'3000','GOPHER STATE WCJV USA','1:0','z7');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (22,null,3,'85.51.90.S','089.09.79.W','2008-07-18T03:26:24','93800083','0099','0199','00992008071803262400020',null,'118042662','6901969','2008-07-18T03:26:25','2008-07-18T03:26:26','3001','2008-07-18T03:26:27','2008-07-18T03:26:28',1,'3000','SEABULK POWER WGWA USA','1:0','0022');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (23,null,3,'03.53.55.N','067.31.38.W','2010-11-21T01:11:17','908160919','0099','0199','00992010112101111700021',null,'763602552','9243174','2010-11-21T01:11:18','2010-11-21T01:11:19','3001','2010-11-21T01:11:20','2010-11-21T01:11:21',1,'ABADDUR','YORKTOWN EXPRESS WDD6127 USA','1:0','0022');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (24,null,3,'06.36.16.N','111.36.53.W','2000-05-18T17:31:10','288149803','0099','0199','00992000051817311000022',null,'494451697','7437214','2000-05-18T17:31:11','2000-05-18T17:31:12','3001','2000-05-18T17:31:13','2000-05-18T17:31:14',1,'3000','WESTERN RANGER WBN3008 USA','9:9','0022');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (25,null,3,'10.41.59.N','161.02.14.W','2005-11-18T08:22:37','703607838','0099','0199','00992005111808223700023',null,'628910236','6421086','2005-11-18T08:22:38','2005-11-18T08:22:39','3001','2005-11-18T08:22:40','2005-11-18T08:22:41',1,'3000','TUSTUMENA WNGW USA','1:0','0501');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (26,null,3,'75.56.11.N','100.34.21.E','2009-01-12T14:10:28','264091937','0099','0199','00992009011214102800024',null,'628910236','6421086','2009-01-12T14:10:29','2009-01-12T14:10:30','3001','2009-01-12T14:10:31','2009-01-12T14:10:32',1,'3000','TUSTUMENA WNGW USA','1:0','!egads!Crap�in honor of dave.');
Insert into SPR (TEST_ID,TEST_DESCRIPTION,MESSAGE_TYPE,LATITUDE,LONGITUDE,TIMESTAMP1,SHIPBORNE_EQUIPMENT_ID,ASP_ID,CSP_ID,MESSAGE_ID,REFERENCE_ID,MMSI_NUM,IMO_NUM,TIMESTAMP2,TIMESTAMP3,DC_ID,TIMESTAMP4,TIMESTAMP5,RESPONSE_TYPE,DATA_USER_REQUESTOR,SHIP_NAME,DDP_VERSION_NUM,DATA_USER_PROVIDER) values (1,'Valid SPR',1,'59.48.58.N','017.46.96.E','2007-05-27T12:03:32','629973911','0099','0199','00992007052712033234341',null,'883869057','9126297','2007-05-27T12:03:33','2007-05-27T12:03:34','3001','2007-05-27T12:03:35','2007-05-27T12:03:36',1,'3000','Honor WDC6923 USA','1:0','0022');

  ALTER TABLE "RANDREWS"."TESTMAIN" MODIFY ("TEST_ID" NOT NULL ENABLE);
 
  ALTER TABLE "RANDREWS"."TESTMAIN" ADD PRIMARY KEY ("TEST_ID") ENABLE;

  ALTER TABLE "RANDREWS"."TEST_METADATA" MODIFY ("TEST_ID" NOT NULL ENABLE);
 
  ALTER TABLE "RANDREWS"."TEST_METADATA" ADD PRIMARY KEY ("TEST_ID") ENABLE;
 
  ALTER TABLE "RANDREWS"."SPR" MODIFY ("TEST_ID" NOT NULL DISABLE);
 
  ALTER TABLE "RANDREWS"."SPR" ADD PRIMARY KEY ("TEST_ID") DISABLE;
 
- 