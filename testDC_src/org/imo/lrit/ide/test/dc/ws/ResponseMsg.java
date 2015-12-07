/**
 * 
 */
package org.imo.lrit.ide.test.dc.ws;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPMessage;

import org.imo.gisis.xml.lrit._2008.Response;
import org.imo.gisis.xml.lrit._2008.ResponseType;
import org.imo.lrit.common.util.XMLHelper;
import org.w3c.dom.Document;

/**
 * Create a receipt message, originating from the IDE.
 * 
 * @author llawrenc
 * 
 */
public class ResponseMsg extends Response {
    private Response resp;

    public ResponseMsg(ResponseType resptype) {
        this.resp = new Response();
        resp.setResponse(resptype);
    }
    
    public SOAPMessage toSOAPMessage() {
        SOAPMessage msg;
        try {
            JAXBContext jc = JAXBContext
                    .newInstance(XMLHelper.RESPONSE_PKG);
            Marshaller m = jc.createMarshaller();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            m.marshal(resp, doc);
            msg = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL)
                    .createMessage();
            SOAPBody body = msg.getSOAPBody();
            body.addDocument(doc);
        } catch (Exception e) {
            throw new RuntimeException("Error creating Response: ", e);
        }
        return msg;
    }

    /**
     * @param obj
     * @return
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        return resp.equals(obj);
    }

    /**
     * @return
     * @see org.imo.gisis.xml.lrit._2008.Response#getResponse()
     */
    public ResponseType getResponse() {
        return resp.getResponse();
    }

    /**
     * @return
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return resp.hashCode();
    }

    /**
     * @param value
     * @see org.imo.gisis.xml.lrit._2008.Response#setResponse(org.imo.gisis.xml.lrit._2008.ResponseType)
     */
    public void setResponse(ResponseType value) {
        resp.setResponse(value);
    }

    /**
     * @return
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return resp.toString();
    }
}
