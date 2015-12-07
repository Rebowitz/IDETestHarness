/**
 * IDEServiceTest.java
 *
 * Last Update $Id: IdeServiceTest.java,v 1.11 2008-08-14 14:38:40 rba Exp $
 *
 * History:
 * $Log: IdeServiceTest.java,v $
 * Revision 1.11  2008-08-14 14:38:40  rba
 * Stupid comparison tricks.
 *
 * Revision 1.10  2008-08-14 14:19:32  rba
 * Change in AssertTest validation equations
 *
 * Revision 1.9  2008-08-12 14:05:35  rba
 * New class created to better organize code and to eliminate unneeded code being included in the mockdc war file
 *
 * Revision 1.8  2008-07-30 14:10:33  rba
 * Continuted changes in support of the reconciliation process.
 *
 * Revision 1.7  2008-07-29 21:05:13  rba
 * Coding of the Receipt Message Reconciliation process.
 *
 * Revision 1.6  2008-07-29 20:36:59  rba
 * Repaired hibernate query string construction
 *
 * Revision 1.5  2008-07-29 14:22:56  rba
 * Another iteration of the main test method. Contains reconciliation process.
 *
 * Revision 1.4  2008-07-22 21:52:39  rba
 * Completed coding of SPR test.
 *
 * Revision 1.3  2008-07-15 19:27:16  rba
 * Latest version of the test.
 *
 * Revision 1.2  2008-07-07 14:23:57  rba
 * Latest version
 *
 */
package org.imo.lrit.test.ideservicetest;

import com.sun.xml.ws.client.ClientTransportException;

import org.imo.lrit.ide.test.model.TestMain;
import org.imo.lrit.ide.test.model.Spr;
import org.imo.lrit.ide.test.model.TestMetadata;
//import org.imo.lrit.ide.test.model.JournalEntry;
import org.imo.lrit.ide.common.model.JournalEntry;
import org.imo.lrit.test.common.TestBase;

import java.util.*;
import org.apache.log4j.Logger;

import junit.framework.TestSuite;
import junit.framework.Test;
import junit.framework.Assert;

import javax.xml.soap.*;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.cfg.Configuration;
import org.imo.lrit.ide.testToIDE.ShipPositionReportType;
import org.imo.lrit.ide.testToIDE.IdePortType;
import org.imo.lrit.ide.testToIDE.IdeService;
import org.imo.lrit.ide.testToIDE.Response;
import org.imo.lrit.ide.testToIDE.ResponseType;
import org.imo.lrit.test.common.TestConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.imo.lrit.test.common.TestDataValidate;

/*
 * IdeServiceTest JUnit test case
 */
public class IdeServiceTest extends TestBase {

	protected static final Logger log = Logger.getLogger(IdeServiceTest.class
			.getName());
	public SOAPMessage soapMsg;

	private Configuration cfg1;
	private Configuration cfg2;
	private SessionFactory factory_journal;
	private SessionFactory factory_testdata;

	public IdeServiceTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		log.info("Set-up: Configuring the test case");
		cfg1 = Configuration.class.newInstance().configure("hibernate.cfg.xml");
		cfg2 = Configuration.class.newInstance()
				.configure("hibernate2.cfg.xml");
		factory_journal = cfg1.buildSessionFactory();
		factory_testdata = cfg2.buildSessionFactory();
		// log4j configuration
	}

	// end of JUnit setUp Method
	//
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("IdeServiceTest");
		suite.addTest(new IdeServiceTest("testShipPositionReport"));
		return suite;
	}
	
	public void clearIDEJournal(){
		/*The IDE Journal needs to be cleared before each run of any tests to 
		 * remove debris from previous tests that can cause false test failures.
		 */
		Session clean_journal = null;
		try {
			clean_journal = factory_journal.openSession();
		} catch (Exception e) {
			log.fatal("Unable to connect to IDE Journal Database");
		}		
		
		log.info("Clearing IDE Journal records");

		
		Query clean_query = clean_journal.createQuery(TestConstants.CLEAN_IDE_JOURNAL);
		
		int rows = clean_query.executeUpdate();

		log.info("Deleted " + rows + " from the Journal table");
		
		if(rows == 0){
			log.error("clearIDEJournal method did not clear any rows");
		}else{
			log.info("clearIDEJournal method cleared IDE Journal");
		}
		
		clean_journal.close();
	
		return;
		
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	public void testShipPositionReport() throws java.lang.Exception {

		/* connect to two databases, IDE and Testdata */

		log.info("========================================================");
		log.info("STARTING SHIP POSITION REPORT TEST");
		log.info("========================================================");


		clearIDEJournal();
		
		Session session_journal = null;
		Session session_testdata = null;
		Session session_testdata2 = null;
		Session session_testdata3 = null;
		try {
			session_journal = factory_journal.openSession();
		} catch (Exception e) {
			log.fatal("Unable to connect to IDE Journal Database");
		}

		try {
			session_testdata = factory_testdata.openSession();
		} catch (Exception e2) {
			log.fatal("Unable to connect to Test Data database");
		}
		try {
			session_testdata2 = factory_testdata.openSession();
		} catch (Exception e2) {
			log.fatal("Unable to connect to Test Data database");
		}
		try {
			session_testdata3 = factory_testdata.openSession();
		} catch (Exception e2) {
			log.fatal("Unable to connect to Test Data database");
		}
		/*
		 * Pull all the Ship Position Report test records from the TestMain
		 * table
		 */

		System.out.println("Running TestMain Query. Good Luck Jim!");

		Query q = session_testdata.createQuery(TestConstants.SPRTEST_ACTIVE);

		Iterator testIter = q.iterate();

		// ok we get a list of the master test records
		while (testIter.hasNext()) {
			TestMain tmain = (TestMain) testIter.next();


			log.info("Testing iteration loop");
			Long tcid = tmain.gettestid();

			log.info(tcid);

			System.out.println("Running SPR test number" + tcid);
			
			/* Get the test ship position report based on the test id code */

			List<Spr> sprList  = session_testdata2.createCriteria(Spr.class).add(
					Restrictions.eq("testid", tcid.intValue())).list();
			
			//the database should only contain one record for each test
			Spr tspr = sprList.get(0);
			
			log.info("Query for test data in SPR table: " + tcid);

			ShipPositionReportType sprt = new ShipPositionReportType();

			log.info("Creating SPR for sending");

			sprt.setLatitude(tspr.getLatitude());
			sprt.setLongitude(tspr.getLongitude());

			DatatypeFactory dtf = DatatypeFactory.newInstance();

			XMLGregorianCalendar xgc = dtf.newXMLGregorianCalendar(tspr
					.getTimestamp1());
			sprt.setTimeStamp1(xgc);
			sprt.setShipborneEquipmentId(tspr.getShipbourneequipmentid());
			sprt.setASPId(tspr.getAspid());
			sprt.setCSPId(tspr.getCspid());
			sprt.setMessageType(tspr.getMessagetype());
			sprt.setMessageId(tspr.getMessageid());

			if (tspr.getReferenceid() == null) {
				sprt.setReferenceId("");
			} else {
				sprt.setReferenceId(tspr.getReferenceid());
			}

			sprt.setIMONum(tspr.getImonum());
			sprt.setMMSINum(tspr.getMmsinum());

			xgc = dtf.newXMLGregorianCalendar(tspr.getTimestamp2());
			sprt.setTimeStamp2(xgc);

			xgc = dtf.newXMLGregorianCalendar(tspr.getTimestamp3());
			sprt.setTimeStamp3(xgc);

			sprt.setDCId(tspr.getDcid());

			xgc = dtf.newXMLGregorianCalendar(tspr.getTimestamp4());
			sprt.setTimeStamp4(xgc);

			xgc = dtf.newXMLGregorianCalendar(tspr.getTimestamp5());
			sprt.setTimeStamp5(xgc);

			sprt.setResponseType(tspr.getResponsetype());
			sprt.setDataUserRequestor(tspr.getDatauserrequestor());
			sprt.setShipName(tspr.getShipname());
			sprt.setDataUserProvider(tspr.getDcid());
			sprt.setDDPVersionNum(tspr.getDdpversionnum());

			// set it for test only
			sprt.setTest(1);

			log.info("sending the soap message");

			IdeService ideSvc = new IdeService();
			IdePortType idePtype = ideSvc.getIdePort();

			try {
				log.info(idePtype.toString());
				Response response = idePtype.shipPositionReport(sprt);

				ResponseType resptype = response.getResponse();

				log.info("Soap Message response is " + resptype.toString());

			} catch (ClientTransportException exception) {
				exception.printStackTrace();
				if (log.isDebugEnabled()) {
					log.error(exception.getMessage(), exception);
				}
			}// end try & catch block

			/*
			 * 
			 * Reconciliation Get test metadata, this will tell us if there
			 * should be a message record or a message and receipt records in
			 * the dbase and on the file system
			 */

			try{
			 java.lang.Thread.currentThread().sleep(TestConstants.SPRTEST_TIMEOUT_INTERVAL);
			}catch (Exception te){
				te.printStackTrace();
			}
			
			
			log.info("TestMetadata query is " + TestConstants.SPRTEST_GET_TEST_METADATA + tcid);
			
			Query metadata = session_testdata3
					.createQuery(TestConstants.SPRTEST_GET_TEST_METADATA + tcid);

			log.info("Object returns query as " + metadata.getQueryString());
			
			List tmd = metadata.list();
			Iterator tmdi = tmd.iterator();
			String result = "";

			
			while (tmdi.hasNext()) {
				TestMetadata tMetadata = (TestMetadata) tmdi.next();
				Long tmcode = tMetadata.getRespmsgtype();
				Long testqty = tMetadata.getQuantity();
				String location = tMetadata.getLocation();
				String fsindicator = new String("fs");
				int fstestcount = 0;
				int dbtestcount = 0;
				String refmsgID = tspr.getMessageid();
				log.info("location sought is " + location);
				log.info("Message code is " + tmcode);
				/*
				 * The metadata in the test db will tell us what type of record
				 * (receipt-7, spr-1,2,3) to look for and also where to look for
				 * it(db-database,fs-file system
				 */


					/*
					 * if this is a broadcast message, we may have multiple
					 * files to examine on the file system.
					 */
					if (tmcode == 7) {
						/*
						 * we need to obtain the receipt message id as that will
						 * be the name of the results file stored on the file
						 * system. The receipt message will contain the original
						 * message id inside it listed as ReferenceId.
						 */
						Query qj = session_journal
								.createQuery(TestConstants.SPRTEST_GET_RECEIPTS_BY_REFID + "'" + refmsgID + "'");
						
						log.info("Object returns query as " + qj.getQueryString());
						
						log.info("Pulling receipt records from the journal for message " + refmsgID);

						Iterator jeIter = qj.iterate();
						
						/*testing has shown that it can take up to 15 seconds for the records to get
						 * into the database under adverse conditions
						 */
						
						try{
							 java.lang.Thread.currentThread().sleep(15000); //15000 milliseconds
							}catch (Exception te){
								te.printStackTrace();
							}
							
							
						while (jeIter.hasNext()) {
							
							JournalEntry jEntry = (JournalEntry) jeIter.next();
							log.info("Accessing Journal entry, getting Receipt information");
							
							log.info("location sought is " + location);
							
							if (location.compareTo(fsindicator) >= 0) {
								result = TestDataValidate
										.verifyReceiptMessage("SPR",jEntry);
								if (result.equals("SUCCESS")) {
									log.info(result + ": Verified Receipt Message "
											+ refmsgID);
									fstestcount++;
								} else {
									log.info(result
											+ ": Unable to verify Receipt Message "
											+ refmsgID);
								}
							} else { //looking for receipts in the database

			  				    result = TestDataValidate.verifyReceiptJournalEntry(tspr.getMessageid(), tspr, jEntry);					
								if (result.equals("SUCCESS")) {
									log.info(result + ": Verified Journal Receipt Record "
											+ refmsgID);
									dbtestcount++;
								} else {
									log.info(result
											+ ": Unable to verify Journal Receipt Record "
											+ refmsgID);
								}
							}
						}//end while jeIter.hasNext loop
						
							Assert.assertTrue("Number of receipts (" + fstestcount
								+ ") found for test " + tcid
								+ " does not match number in test database: "
								+ testqty, testqty.intValue() == fstestcount);


							Assert.assertTrue("Number of receipts (" + dbtestcount
									+ ") found in the journal for test " + tcid
									+ " does not match number in test database: "
									+ testqty, testqty.intValue() == dbtestcount);							
						

					} else { //for successful messages
						log.info("Constructed query is: " + TestConstants.SPRTEST_GET_POSREP_RECS + "'" + refmsgID + "'");
						
						Query queryj = session_journal.createQuery(TestConstants.SPRTEST_GET_POSREP_RECS + "'" + refmsgID + "'");
//						log.info("Query reported by object is " + query.getQueryString());
						
						Iterator jIter = queryj.iterate();
					

					while (jIter.hasNext()) {
						log.info("Processing testmetadata record");
					JournalEntry jEntry2 = (JournalEntry) jIter.next();						
						

							String verifyresult = TestDataValidate.verifySPRMessage("SPR", tspr.getMessageid(),tspr);
							if (verifyresult.equals("SUCCESS")) {
								log.info(verifyresult + ": Verified Ship Position Report Message " + tspr.getMessageid()
										+ " received at Mock DC");
								Assert.assertTrue("Ship Position Report not received at Mock DC", verifyresult.equals("SUCCESS"));								
							} else {
								log.info(verifyresult + ": Unable to verify Ship Position Report Message " + tspr.getMessageid()
										+ " received at Mock DC");
								Assert.assertTrue("Ship Position Report not received at Mock DC", verifyresult.equals("SUCCESS"));
							}

							verifyresult = TestDataValidate.verifySPRJournalEntry("SPR",tspr,jEntry2);
							if (verifyresult.equals("SUCCESS")) {
								log.info(verifyresult + ": Verified Ship Position Report Message " + tspr.getMessageid()
										+ " Journal Entry");
								Assert.assertTrue("Verified Ship Position Report Message " + tspr.getMessageid() 
										+ "in Journal", verifyresult.equals("SUCCESS"));
							} else {
								log.info(verifyresult + ": Unable to verify Ship Position Report Message " + tspr.getMessageid()
										+ " Journal Entry");
								Assert.assertTrue("Unable to verify Ship Position Report Message " + tspr.getMessageid() 
										+ "in Journal", verifyresult.equals("SUCCESS"));
							}
						}
					}
				}
			}
		 session_journal.close();
		 session_testdata.close();
		 session_testdata2.close();
		 session_testdata3.close();
	
	
	
	}  

	/**
	 * Auto generated test method
	 */
	public void testStartShipPositionReport() throws java.lang.Exception {

	}

	/**
	 * Auto generated test method
	 */
	public void testShipPositionRequest() throws java.lang.Exception {

	}

	/**
	 * Auto generated test method
	 */
	public void testStartShipPositionRequest() throws java.lang.Exception {

	}

	/**
	 * Auto generated test method
	 */
	public void testSARSURPICRequest() throws java.lang.Exception {

	}

	/**
	 * Auto generated test method
	 */
	public void testStartSARSURPICRequest() throws java.lang.Exception {

	}

	/**
	 * Auto generated test method
	 */
	public void testReceipt() throws java.lang.Exception {

	}

	/**
	 * Auto generated test method
	 */
	public void testStartReceipt() throws java.lang.Exception {

	}

	/**
	 * Auto generated test method
	 */
	public void testSystemStatus() throws java.lang.Exception {

	}

	/**
	 * Auto generated test method
	 */
	public void testStartSystemStatus() throws java.lang.Exception {

	}

	/**
	 * Auto generated test method
	 */
	public void testJournalReport() throws java.lang.Exception {

	}

	/**
	 * Auto generated test method
	 */
	public void testStartJournalReport() throws java.lang.Exception {
	}

	/**
	 * Auto generated test method
	 */
	public void testPricingRequest() throws java.lang.Exception {

	}

	/**
	 * Auto generated test method
	 */
	public void testStartPricingRequest() throws java.lang.Exception {

	}

	/**
	 * Auto generated test method
	 */
	public void testPricingUpdate() throws java.lang.Exception {

	}

	/**
	 * Auto generated test method
	 */
	public void testStartPricingUpdate() throws java.lang.Exception {

	}

	public void receiveResultShipPositionReport(
			org.imo.lrit.ide.testToIDE.Response result) {
	}

	public void receiveErrorShipPositionReport(java.lang.Exception e) {
		fail();
	}

	public void receiveResultShipPositionRequest(
			org.imo.lrit.ide.testToIDE.Response result) {
	}

	public void receiveErrorShipPositionRequest(java.lang.Exception e) {
		fail();
	}

	public void receiveResultSARSURPICRequest(
			org.imo.lrit.ide.testToIDE.Response result) {
	}

	public void receiveErrorSARSURPICRequest(java.lang.Exception e) {
		fail();
	}

	public void receiveResultReceipt(org.imo.lrit.ide.testToIDE.Response result) {
	}

	public void receiveErrorReceipt(java.lang.Exception e) {
		fail();
	}

	public void receiveResultSystemStatus(
			org.imo.lrit.ide.testToIDE.Response result) {
	}

	public void receiveErrorSystemStatus(java.lang.Exception e) {
		fail();
	}

	public void receiveResultJournalReport(
			org.imo.lrit.ide.testToIDE.Response result) {
	}

	public void receiveErrorJournalReport(java.lang.Exception e) {
		fail();
	}

	public void receiveResultPricingRequest(
			org.imo.lrit.ide.testToIDE.Response result) {
	}

	public void receiveErrorPricingRequest(java.lang.Exception e) {
		fail();
	}

	public void receiveResultPricingUpdate(
			org.imo.lrit.ide.testToIDE.Response result) {
	}

	public void receiveErrorPricingUpdate(java.lang.Exception e) {
		fail();
	}

}
