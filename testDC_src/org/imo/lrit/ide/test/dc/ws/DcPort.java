/**
 * 
 */
package org.imo.lrit.ide.test.dc.ws;

import java.io.ByteArrayOutputStream;
import javax.annotation.Resource;

import javax.jws.WebService;
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceContext;
//import javax.xml.ws.WebServiceException;

import org.imo.lrit.ide.test.context.ContextHelper;
import org.imo.lrit.ide.test.util.WSUtil;

import org.imo.lrit.ide.test.context.TesterContext;
import org.imo.lrit.ide.test.dc.ws.DcPort;

import org.apache.log4j.Logger;
import org.imo.gisis.xml.lrit._2008.DcPortType;
import org.imo.gisis.xml.lrit._2008.Response;
import org.imo.gisis.xml.lrit._2008.ResponseType;
import org.imo.gisis.xml.lrit.ddpnotification._2008.DDPNotificationType;
import org.imo.gisis.xml.lrit.ddpupdate._2008.DDPUpdateType;
import org.imo.gisis.xml.lrit.positionreport._2008.ShipPositionReportType;
import org.imo.gisis.xml.lrit.positionrequest._2008.ShipPositionRequestType;
import org.imo.gisis.xml.lrit.pricingnotification._2008.PricingNotificationType;
import org.imo.gisis.xml.lrit.pricingupdate._2008.PricingUpdateType;
import org.imo.gisis.xml.lrit.receipt._2008.ReceiptType;
import org.imo.gisis.xml.lrit.sarsurpicrequest._2008.SARSURPICType;
import org.imo.gisis.xml.lrit.systemstatus._2008.SystemStatusType;
import org.imo.lrit.common.util.XMLHelper;
import org.imo.lrit.test.common.TestDataReadWrite;
import org.imo.lrit.test.common.TestConstants;


import com.sun.xml.ws.developer.SchemaValidation;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;

/**
 * @author llawrenc
 * 
 */
@WebService(endpointInterface = "org.imo.gisis.xml.lrit._2008.DcPortType")
@SchemaValidation
public class DcPort implements DcPortType {
	
	

	
    static final Response resp;
    private static Logger log = Logger.getLogger(DcPort.class);

    private static TesterContext testCtxRef = null;

    static {
        resp = new Response();
        resp.setResponse(ResponseType.SUCCESS);
    }

    @Resource
    WebServiceContext wsContext;

    /*
     * (non-Javadoc)
     * 
     * @see org.imo.gisis.xml.lrit._2008.DcPortType#ddpNotification(org.imo.gisis.xml.lrit.ddpnotification._2008.DDPNotificationType)
     */
    public Response ddpNotification(DDPNotificationType params) {
        log.info("Got DDPNotificationType");
        return resp;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.imo.gisis.xml.lrit._2008.DcPortType#ddpUpdate(org.imo.gisis.xml.lrit.ddpupdate._2008.DDPUpdateType)
     */
    public Response ddpUpdate(DDPUpdateType params) {
        log.info("Got DDPUpdateType");
        return resp;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.imo.gisis.xml.lrit._2008.DcPortType#pricingNotification(org.imo.gisis.xml.lrit.pricingnotification._2008.PricingNotificationType)
     */
    public Response pricingNotification(PricingNotificationType params) {
        log.info("Got PricingNotificationType");
        TesterContext testCtx = getTestCtx();
        int msgType = params.getMessageType().intValue();
        testCtx.bumpRcvCount(msgType, WSUtil.getServletPath(wsContext));        
        return resp;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.imo.gisis.xml.lrit._2008.DcPortType#pricingUpdate(org.imo.gisis.xml.lrit.pricingupdate._2008.PricingUpdateType)
     */
    public Response pricingUpdate(PricingUpdateType params) {
        log.info("Got PricingUpdateType");
        return resp;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.imo.gisis.xml.lrit._2008.DcPortType#receipt(org.imo.gisis.xml.lrit.receipt._2008.ReceiptType)
     */
    public Response receipt(ReceiptType receipt) {
        log.info("Got ReceiptType");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            JAXBElement<ReceiptType> element = new JAXBElement<ReceiptType>(
              new QName(XMLHelper.RECEIPT_NS,XMLHelper.RECEIPT_LOCAL_NAME),ReceiptType.class,receipt);
            JAXBContext jaxbctx = JAXBContext
                    .newInstance(XMLHelper.RECEIPT_PKG);
            Marshaller m = jaxbctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(element, baos);
            String xmlString = baos.toString();

          String filename = element.getValue().getMessageId();
          filename += ".xml";
          log.info("xmlString is:" + xmlString);
          
          TestDataReadWrite.writeXMLFile(filename, TestConstants.MSGXMLDIR, xmlString);            
            
            
        } catch (Exception e) {
            throw new RuntimeException("JAXB Exception: ", e);
        }


        return resp;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.imo.gisis.xml.lrit._2008.DcPortType#sarsurpicRequest(org.imo.gisis.xml.lrit.sarsurpicrequest._2008.SARSURPICType)
     */
    public Response sarsurpicRequest(SARSURPICType params) {
        log.info("Got SARSURPICType");
        return resp;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.imo.gisis.xml.lrit._2008.DcPortType#shipPositionReport(org.imo.gisis.xml.lrit.positionreport._2008.ShipPositionReportType)
     */
    public Response shipPositionReport(ShipPositionReportType posrep) {
        log.info("Got ShipPositionReportType");
        
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            JAXBElement<ShipPositionReportType> element = new JAXBElement<ShipPositionReportType>(
                    new QName(XMLHelper.POSITION_REPORT_NS,"ShipPositionReport"),ShipPositionReportType.class,posrep);
            JAXBContext jaxbctx = JAXBContext
                    .newInstance(XMLHelper.POSITION_REPORT_PKG);
            Marshaller m = jaxbctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(element, baos);
            
            String xmlString = baos.toString();
//            xmlString = element.getValue().toString();
            String filename = element.getValue().getMessageId();
            filename += ".xml";
            log.info("xmlString is:" + xmlString);
            
 //           TesterContext testCtx = getTestCtx();
 //           int msgType = posrep.getMessageType().intValue();
 //           testCtx.bumpRcvCount(msgType, WSUtil.getServletPath(wsContext));   
            
            TestDataReadWrite.writeXMLFile(filename, TestConstants.MSGXMLDIR, xmlString);
            
        } catch (Exception e) {
            throw new RuntimeException("JAXB Exception: ", e);
        }

        return resp;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.imo.gisis.xml.lrit._2008.DcPortType#shipPositionRequest(org.imo.gisis.xml.lrit.positionrequest._2008.ShipPositionRequestType)
     */
    public Response shipPositionRequest(ShipPositionRequestType posreq) {
        log.info("Got ShipPositionRequestType");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            JAXBElement<ShipPositionRequestType> element = new JAXBElement<ShipPositionRequestType>(
            new QName(XMLHelper.POSITION_REQUEST_NS,XMLHelper.POSITION_REQUEST_LOCAL_NAME),
                ShipPositionRequestType.class,posreq);

            JAXBContext jaxbctx = JAXBContext
                    .newInstance(XMLHelper.POSITION_REQUEST_PKG);
            Marshaller m = jaxbctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(element, baos);
        } catch (Exception e) {
            throw new RuntimeException("JAXB Exception: ", e);
        }

        return resp;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.imo.gisis.xml.lrit._2008.DcPortType#systemStatus(org.imo.gisis.xml.lrit.systemstatus._2008.SystemStatusType)
     */
    public Response systemStatus(SystemStatusType params) {
        log.info("Got SystemStatusType");
        return resp;
    }
    private TesterContext getTestCtx() {
        if (testCtxRef == null) {
            testCtxRef = (TesterContext) WSUtil
                    .getServletContextAttribute(wsContext,
                                                ContextHelper.TESTER_CONTEXT);
        }
        log.debug(testCtxRef + " getTestCtx() returning ref");
        return testCtxRef;
    }


}
