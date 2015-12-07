
    create table SPR (
        TEST_ID_FK1 number(10,0) not null,
        TEST_DESCRIPTION varchar2(100 char),
        MESSAGE_TYPE number(10,0),
        LATITUDE varchar2(10 char),
        LONGITUDE varchar2(10 char),
        TIMESTAMP1 timestamp,
        SHIPBOURNE_EQUIPMENT_ID varchar2(25 char),
        ASP_ID varchar2(4 char),
        CSP_ID varchar2(4 char),
        MESSAGE_ID varchar2(25 char),
        REFERENCE_ID varchar2(25 char),
        MMSI_NUM varchar2(9 char),
        IMO_NUM number(10,0),
        TIMESTAMP2 timestamp,
        TIMESTAMP3 timestamp,
        DC_ID varchar2(4 char),
        TIMESTAMP4 timestamp,
        TIMESTAMP5 timestamp,
        RESPONSE_TYPE number(10,0),
        DATA_USER_REQUESTOR varchar2(4 char),
        SHIP_NAME varchar2(50 char),
        DDP_VERSION_NUM varchar2(256 char),
        primary key (TEST_ID_FK1)
    );

    create table TEST_METADATA (
        TEST_ID_FK2 number(19,0) not null,
        RESP_MSG_TYPE number(10,0),
        QUANTITY number(10,0),
		LOCATION varchar2(2 char),
        primary key (TEST_ID_FK2)
    );

    create table TestMain (
        TEST_ID number(10,0) not null,
        MSG_NUM number(10,0),
        MSG_TYPE varchar2(50 char),
        TEST_DESCRIPTION varchar2(100 char),
        ACTIVE_TEST varchar2(1 char),
        SUCCESSFAIL number(10,0),
        primary key (TEST_ID)
    );
