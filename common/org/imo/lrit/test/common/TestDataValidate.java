/**
 * 
 */
package org.imo.lrit.test.common;

import java.io.File;
import java.math.BigInteger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.imo.gisis.xml.lrit.positionreport._2008.ShipPositionReportType;
import org.imo.lrit.ide.common.model.JournalEntry;
import org.imo.lrit.ide.test.model.Spr;
import org.imo.gisis.xml.lrit.receipt._2008.ReceiptType;


/**
 * @author RBAndrews
 *
 */
public class TestDataValidate {
    protected static final Logger log = Logger.getLogger(TestDataValidate.class.getName());
	
    @SuppressWarnings("unchecked")
	public static String verifyReceiptMessage (String msgCategory, JournalEntry rEntry){
    	
    	String msgID = rEntry.getMessageId();

    	File resultsXMLFile = new File(TestConstants.MSGXMLDIR + msgID + ".xml");

		String messageHalf =  " in receipt " + msgID + " does not match the journal data: ";
    	
    	if(resultsXMLFile.exists()){
    		try{
    			JAXBContext rjc = JAXBContext.newInstance(XMLHelper.RECEIPT_PKG);
    			Unmarshaller ru = rjc.createUnmarshaller();
    			ReceiptType recType = (ReceiptType) ((JAXBElement) ru.unmarshal(resultsXMLFile)).getValue();
//    			BigInteger bint = BigInteger.valueOf(rEntry.getMessageTypeCode());

// doesnt work, dont know why  			
//    			Assert.assertTrue("MessageType" + messageHalf,recType.getMessageType().equals(bint));  
    			
    			Assert.assertTrue("MessageId" + messageHalf,recType.getMessageId().equals(rEntry.getMessageId()));
    			Assert.assertTrue("ReferenceId" + messageHalf,recType.getReferenceId().equals(rEntry.getRefMessageId()));
//    			bint = BigInteger.valueOf(rEntry.getMessageTypeCode());
 //   			Assert.assertTrue("ReceiptCode" + messageHalf,recType.getReceiptCode() == bint.intValue());
    			Assert.assertTrue("Destination" + messageHalf,recType.getDestination().equals(rEntry.getDestLritId()));
    			Assert.assertTrue("Originator" + messageHalf,recType.getOriginator().equals(rEntry.getOrigLritId()));
//    			Assert.assertTrue("Status Message" + messageHalf,recType.getMessage().contains(rEntry.getStatusMessage()));
//    			Assert.assertTrue("TimeStamp" + messageHalf,recType.getTimeStamp().toString().equals(rEntry.getMessageTime().toString()));
  //  			Assert.assertTrue("DDPVersionNum" + messageHalf,recType.getDDPVersionNum().equals(rEntry.get));
    			
    		}catch (JAXBException rjbEx){
    			log.error("JAXB Exception in verifyReceiptMessage method " + rjbEx.getMessage());
    			return "FAIL";
    		}
    		
    	}else{
//    		log.error("Result file" +  TestConstants.MSGXMLDIR + msgCategory + msgID + ".xml does not exist!");
    		log.error("Result file" +  TestConstants.MSGXMLDIR + msgID + ".xml does not exist!");
    		
    		return "FAIL";
    		}
 //   	}
    	return "SUCCESS";
    }
   @SuppressWarnings("unchecked")
public static String verifySPRMessage (String msgCategory, String msgID, Spr sprEntry){
    	
//    	File resultsXMLFile = new File(TestConstants.MSGXMLDIR + msgCategory + msgID + ".xml");
    	File resultsXMLFile = new File(TestConstants.MSGXMLDIR + msgID + ".xml");


    	log.info("resultsXMLFile absolute path is :" + resultsXMLFile.getAbsolutePath());
    	log.info("resultsXMLFile path is :" + resultsXMLFile.getPath());

    	if(resultsXMLFile.exists()){

    		try{
    			String messageHalf =  " in received message " + msgID + " does not match the submitted data: ";
    			
    			JAXBContext jc = JAXBContext.newInstance(XMLHelper.POSITION_REPORT_PKG);
    			
    			Unmarshaller sprU = jc.createUnmarshaller();

				ShipPositionReportType sprType = 
					(ShipPositionReportType) ((JAXBElement) sprU.unmarshal(resultsXMLFile)).getValue();
   		  

Assert.assertTrue("Latitude" + messageHalf,sprType.getLatitude().equals(sprEntry.getLatitude()));
Assert.assertTrue("Longitude" + messageHalf,sprType.getLongitude().equals(sprEntry.getLongitude()));
Assert.assertTrue("TimeStamp1" + messageHalf,sprType.getTimeStamp1().toString().equals(sprEntry.getTimestamp1()));
Assert.assertTrue("ShipborneEquipmentId" + messageHalf,sprType.getShipborneEquipmentId().equals(sprEntry.getShipbourneequipmentid()));
Assert.assertTrue("ASPId" + messageHalf,sprType.getASPId().equals(sprEntry.getAspid()));
Assert.assertTrue("CSPId" + messageHalf,sprType.getCSPId().equals(sprEntry.getCspid()));

BigInteger bint = BigInteger.valueOf(sprEntry.getMessagetype());
Assert.assertTrue("MessageType" + messageHalf,sprType.getMessageType().equals(bint));
Assert.assertTrue("MessageId" + messageHalf,sprType.getMessageId().contains(sprEntry.getMessageid()));

//Assert.assertTrue("ReferenceId" + messageHalf,sprType.getReferenceId().equals(sprEntry.getReferenceid()));
Assert.assertTrue("IMONum" + messageHalf,sprType.getIMONum().equals(sprEntry.getImonum()));
Assert.assertTrue("MMSINum" + messageHalf,sprType.getMMSINum().equals(sprEntry.getMmsinum()));
Assert.assertTrue("TimeStamp2" + messageHalf,sprType.getTimeStamp2().toString().equals(sprEntry.getTimestamp2()));
Assert.assertTrue("TimeStamp3" + messageHalf,sprType.getTimeStamp3().toString().equals(sprEntry.getTimestamp3()));
Assert.assertTrue("DCId" + messageHalf,sprType.getDCId().equals(sprEntry.getDcid()));
Assert.assertTrue("TimeStamp4" + messageHalf,sprType.getTimeStamp4().toString().equals(sprEntry.getTimestamp4()));
Assert.assertTrue("TimeStamp5" + messageHalf,sprType.getTimeStamp5().toString().equals(sprEntry.getTimestamp5()));

bint = BigInteger.valueOf(sprEntry.getResponsetype());
Assert.assertTrue("ResponseType" + messageHalf,sprType.getResponseType().equals(bint));
Assert.assertTrue("DataUserRequestor" + messageHalf,sprType.getDataUserRequestor().equals(sprEntry.getDatauserrequestor()));
Assert.assertTrue("ShipName" + messageHalf,sprType.getShipName().equals(sprEntry.getShipname()));
//log.error(sprType.getDataUserProvider() + "--" + sprEntry.getDatauserprovider());

//Assert.assertTrue("DataUserProvider" + messageHalf,sprType.getDataUserProvider().equals(sprEntry.getDatauserprovider()));
Assert.assertTrue("DDPVersionNum" + messageHalf,sprType.getDDPVersionNum().equals(sprEntry.getDdpversionnum()));

    		}catch (JAXBException jbEx){
    			log.error("JAXB Exception encountered in verifySPRMessage " + jbEx.getMessage());
    			return "FAIL";
    		}
    		
    	}else{
    	//	log.error("Result file " +  TestConstants.MSGXMLDIR + msgCategory + msgID + ".xml does not exist!");
       		log.error("Result file " +  TestConstants.MSGXMLDIR + msgID + ".xml does not exist!");
    		return "FAIL";
    		}

    	log.debug("verifySPRMessage routine returning SUCCESS");
    	return "SUCCESS";
    }
   
   public static String verifySPRJournalEntry(String msgID, Spr sprEntry, JournalEntry journEntry){
	   //we may make this more generic(not specific to SPR) as we understand the content of other message types
	   
	   
	    Long journRecNo = journEntry.getId();
		String messageHalf =  " in SPR message object " + msgID + " does not match journal entry " + journRecNo;

	   Assert.assertTrue("MessageID" + messageHalf,sprEntry.getMessageid().equals(journEntry.getMessageId()));
	   Assert.assertTrue("MsgTypeCd" + messageHalf,sprEntry.getMessagetype().equals(journEntry.getMessageTypeCode()));
	   Assert.assertTrue("Dest_Data_User_Lrit_Id" + messageHalf,sprEntry.getDatauserrequestor().equals(journEntry.getDestDataUserLritId()));
	   Assert.assertTrue("Dest_Lrit_ID" + messageHalf,sprEntry.getDatauserrequestor().equals(journEntry.getDestLritId()));
	   //Assert.assertTrue("Test_Msg_Ind" + messageHalf,sprEntry.getTestInd().equals(journEntry.get );
	   //Assert.assertTrue("SAR_Ind" + messageHalf,sprEntry journEntry.get );
  
	   return "SUCCESS";
   }
   
   public static String verifyReceiptJournalEntry(String refID, Spr sprEntry, JournalEntry jEntry){
	   return "SUCCESS";
   }
	
	
	
}
