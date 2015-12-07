/**
 * SendSoapTestMessage.java
 *
 * Last Update $Id: SendSoapTestMessage.java,v 1.1.1.1 2008-07-01 17:47:54 rba Exp $
 *
 * History:
 * $Log: SendSoapTestMessage.java,v $
 * Revision 1.1.1.1  2008-07-01 17:47:54  rba
 * Initial import of IDETestHarness
 *
 */
package org.imo.lrit.test.common;

/**
 * 
 */

import javax.xml.soap.MessageFactory;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPException;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceException;
import java.net.URL;
import java.io.*;

import org.imo.lrit.ide.testToIDE.IdeService;
import org.imo.lrit.test.common.XMLHelper;
import org.w3c.dom.Document;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;


public class SendSoapTestMessage extends TestBase{

    public SendSoapTestMessage(String arg0)
    {
        super(arg0);
    } 
    
    protected void setUp() throws Exception {
        // super.setUp();
     }

     protected void tearDown() throws Exception {
         super.tearDown();
     }


    public static String SendMessageToIDE(URL ideURL, SOAPMessage soapmsg) throws SOAPException, IOException{
        String outcome = "";
        SOAPMessage genResponse = MessageFactory.newInstance().createMessage();
 

        String responseXML = "";
        try{
            IdeService svc = new IdeService(ideURL, new QName(
                XMLHelper.IDE_SERVICE_NS,XMLHelper.IDE_SERVICE_NAME));
            Dispatch<SOAPMessage> disp = svc.createDispatch(new QName(
                XMLHelper.IDE_SERVICE_NS,XMLHelper.IDE_PORT_NAME),
                SOAPMessage.class,Service.Mode.MESSAGE);
            genResponse = disp.invoke(soapmsg);
            responseXML = genResponse.getSOAPBody().toString();

            TestDataReadWrite.writeXMLFile("Response.xml",
              TestProperties("test.xml.spr.ideresponsefile.location"),responseXML);

            
        } catch (WebServiceException e) {
            log.debug("DataCentre not available: " + e);

                TestDataReadWrite.writeXMLFile("Response.xml",
                    TestProperties("test.xml.spr.ideresponsefile.location"),
                        TestConstants.WEBSERVICES_WEBEXCEPTION_SPR_ERROR);
             

              
        }
        catch (Exception unexpectedException) {
            log.debug("Caught an unexpected exception "
                    + "while sending SOAP message : ", unexpectedException);
            TestDataReadWrite.writeXMLFile("Response.xml",
                TestProperties("test.xml.spr.ideresponsefile.location"),
                    TestConstants.WEBSERVICES_UNEXPECTED_SPR_ERROR);
        }
        return outcome;

    }
    
    public static SOAPMessage createSOAPMessage(String body) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(body.getBytes());
        SOAPMessage soapmsg = MessageFactory.newInstance().createMessage();
        SOAPBody soapbody = soapmsg.getSOAPBody();
        Document doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder().parse(bais);
        soapbody.addDocument(doc);
        return soapmsg;
    }
   
 
}
