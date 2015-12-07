/**
 * DcPortProvider.java
 *
 * Created by  llawrenc
 * Last Update $Id: DcPortProvider.java,v 1.7 2008-07-22 21:52:39 rba Exp $
 *
 */
package org.imo.lrit.ide.test.dc.ws;

import java.io.ByteArrayOutputStream;
import java.util.Date;

import javax.annotation.Resource;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Provider;
import javax.xml.ws.Service;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;

import org.imo.lrit.ide.test.context.ContextHelper;
import org.imo.lrit.ide.test.context.TesterContext;

import org.imo.lrit.ide.test.context.RcvdMsg;
import org.imo.lrit.ide.test.util.MsgUtil;
import org.imo.lrit.ide.test.util.MsgValidator;
import org.imo.lrit.ide.test.util.WSUtil;
import org.apache.log4j.Logger;
import org.imo.gisis.xml.lrit._2008.ResponseType;
import org.imo.lrit.test.common.TestDataReadWrite;
import org.imo.lrit.test.common.TestConstants;

@WebServiceProvider(serviceName = "dcService", portName = "dcPort", targetNamespace = "http://gisis.imo.org/XML/LRIT/2008", wsdlLocation = "WEB-INF/wsdl/DC.wsdl")
@ServiceMode(Service.Mode.MESSAGE)
public class DcPortProvider implements Provider<SOAPMessage> {

    private static MsgValidator validator = null;
    private static final Logger log = Logger.getLogger(DcPortProvider.class);
    // We only need one of these because we always return the same thing.

    // We only need one of these because we always return the same thing.
    private static final SOAPMessage resp;
    private static TesterContext testCtxRef = null;

    @Resource
    WebServiceContext wsContext;

    private TesterContext getTestCtx() {
        if (testCtxRef == null) {
            testCtxRef = (TesterContext) WSUtil
                    .getServletContextAttribute(wsContext,
                                                ContextHelper.TESTER_CONTEXT);
        }
        log.debug("getTestCtx() returning ref: " + testCtxRef);
        return testCtxRef;
    }

    
    static {
        resp = (new ResponseMsg(ResponseType.SUCCESS)).toSOAPMessage();
    }

    public SOAPMessage invoke(SOAPMessage soapmsg) {
        log.debug("invoke() starting");
        if (validator == null) {
            // Have to wait until we have a web service context to do this
            validator = MsgValidator.getMsgValidator(wsContext,
                                                     "/WEB-INF/wsdl/DC.wsdl");
        }
        String errs;
        errs = validator.validateErrs(soapmsg);
        if (errs != null) {
            log.info("Validation error: " + errs);
            throw new RuntimeException(errs);
            // throw new SOAPFaultException(createValidationFault(errs));
        }
        ByteArrayOutputStream baos = null;
        baos = new ByteArrayOutputStream();
        try {
            soapmsg.writeTo(baos);
        } catch (Exception e) {
            log.error("Error interpreting SOAPMessage:", e);
        }
        String xml = baos.toString();
        int messageType = MsgUtil.parseIntField("MessageType", xml);
        RcvdMsg r = new RcvdMsg(WSUtil.getServletPath(wsContext), new Date(),
                                messageType, MsgUtil.parseField("MessageId",
                                                                xml), xml);
        
        log.info("message type is " + messageType);
        log.info("Received message is " + r.getXml());
        
        String xmlFileName = MsgUtil.parseField("MessageId", xml);
 //       String xmlFileName = element.getValue().getMessageId();
        xmlFileName += ".xml";
        
        try{
            TestDataReadWrite.writeXMLFile(xmlFileName, TestConstants.MSGXMLDIR, xml);       	
        }catch (Exception outex){
            log.error("Error writing xml message to disk:", outex);        	
        }

        TesterContext testCtx = getTestCtx();       
        testCtx.bumpRcvCount(messageType, WSUtil
                .getServletPath(wsContext));
        testCtx.addRcvdMsg(r);        
        
        
        return resp;
    }



}
