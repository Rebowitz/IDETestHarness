/**
 * TestConstants.java
 *
 * Last Update $Id: TestConstants.java,v 1.10 2008-09-02 17:20:55 rba Exp $
 *
 * History:
 * $Log: TestConstants.java,v $
 * Revision 1.10  2008-09-02 17:20:55  rba
 * File showing unchecked mods, so I'm checking it in.
 *
 * Revision 1.9  2008-08-12 13:44:21  rba
 * Changes supporting an enhanced test.
 *
 * Revision 1.8  2008-07-30 14:10:33  rba
 * Continuted changes in support of the reconciliation process.
 *
 * Revision 1.7  2008-07-29 14:23:51  rba
 * Contains additions to support the reconciliation process.
 *
 * Revision 1.6  2008-07-22 21:52:39  rba
 * Completed coding of SPR test.
 *
 * Revision 1.5  2008-07-18 14:00:03  rba
 * Periodic update. Added sql for select records from test database.
 *
 * Revision 1.4  2008-07-15 19:18:21  rba
 * Last set of modifications which actually resulted in the TestHarness working!
 *
 * Revision 1.3  2008-07-10 16:52:26  rba
 * Adding to the repository.  It was missed for some reason or other.
 *
 * Revision 1.2  2008-07-09 17:19:27  rba
 * Addition of testDC code base, jar files.
 *
 * Revision 1.1.1.1  2008-07-01 17:47:54  rba
 * Initial import of IDETestHarness
 *
 */
package org.imo.lrit.test.common;

/**
 * 
 */
public class TestConstants {
    // Properties file name and key names
    public static final String WEBSERVICES_TEST_CONFIG_FILE = "/configuration/webservices.test.properties";
    public static final String WEBSERVICES_TEST_LOG_FILE = "IDETestHarness.log";
    
    
    
    public static final String WEBSERVICES_WEBEXCEPTION_SPR_ERROR = "IDE Webservice ShipPositionReport did not respond.";
    public static final String WEBSERVICES_UNEXPECTED_SPR_ERROR = "Unexpected error caught in ShipPositionReport test";
    public static final String WEBSERVICES_IDE_WSDL_LOCATION = "file:/home/randrews/lrit_common/etc/IDE-DC.wsdl";
    public static final String WEBSERVICES_DC_WSDL_LOCATION = "file:/home/randrews/lrit_common/etc/DC.wsdl";
    
    
    //hibernate queries
    public static final String SPRTEST_ACTIVE = "from TestMain tm where tm.testid > 0 and tm.msgType = 'SPR' and tm.activeTest = 'Y' order by tm.testid";
    public static final String SPRTEST_GETID = "from Spr spr where spr.testid = ";
    public static final String SPRTEST_GET_TEST_METADATA = "from TestMetadata tmd where tmd.testid = ";
    public static final String SPRTEST_GET_RECEIPTS_BY_REFID = "from JournalEntry jn where jn.refMessageId = ";
    public static final String SPRTEST_GET_POSREP_RECS = "from JournalEntry jn where jn.messageId = ";
    public static final String CLEAN_IDE_JOURNAL = "delete from JournalEntry where id > 0";
    public static final Integer SPRTEST_TIMEOUT_INTERVAL = 5000;
    
    
    //directory trees
    public static final String MSGXMLDIR = "/opt/tomcat_farm/tomcat4/temp/";

}
