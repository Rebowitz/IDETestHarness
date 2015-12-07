/**
 * MsgUtil.java
 *
 * Last Update $Id: MsgUtil.java,v 1.3 2008-08-12 13:38:22 rba Exp $
 *
 * History:
 * $Log: MsgUtil.java,v $
 * Revision 1.3  2008-08-12 13:38:22  rba
 * Importing changes made to the standalone mockdc into this framework
 *
 * Revision 1.4  2008-05-05 22:21:33  lgl
 * Many little changes.
 *
 * Revision 1.3  2008-05-05 19:31:39  lgl
 * Changes required due to schema changes from LRIT AdHoc 3.
 *
 * Revision 1.2  2008-04-19 00:38:17  lgl
 * Many changes - still in state of flux.
 *
 * Revision 1.1  2008-04-04 14:07:53  lgl
 * Initial checkin
 *
 */
package org.imo.lrit.ide.test.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;

import org.imo.lrit.ide.test.context.TesterContext;

import org.apache.log4j.Logger;
import org.imo.gisis.xml.lrit._2008.IdeService;
import org.imo.lrit.common.util.XMLHelper;

/**
 * This class contains utility methods for use in creating LRIT SOAP messages.
 */
public class MsgUtil {

    private static final Logger log = Logger.getLogger(MsgUtil.class);
    private static String[] pkgs = new String[] {
            XMLHelper.DDP_NOTIFICATION_PKG, XMLHelper.DDP_UPDATE_PKG,
            XMLHelper.JOURNAL_REPORT_PKG, XMLHelper.POSITION_REPORT_PKG,
            XMLHelper.POSITION_REQUEST_PKG, XMLHelper.PRICING_REQUEST_PKG,
            XMLHelper.PRICING_UPDATE_PKG, XMLHelper.RECEIPT_PKG,
            XMLHelper.RESPONSE_PKG, XMLHelper.SAR_SURPIC_PKG,
            XMLHelper.SYSTEM_STATUS_PKG };
    private static String jaxbContextPath;

    static {
        StringBuffer sb = new StringBuffer();
        for (String s : pkgs) {
            sb.append(s).append(":");
        }
        sb.deleteCharAt(sb.length() - 1);
        jaxbContextPath = sb.toString();
    }

    public static <T> String TypeToString(Class<T> type, T typeRef, String ns,
            String localName) throws JAXBException {
        JAXBElement<T> element = new JAXBElement<T>(new QName(ns, localName),
                                                    type, typeRef);
        JAXBContext jaxbctx = JAXBContext.newInstance(jaxbContextPath);
        Marshaller m = jaxbctx.createMarshaller();
        try {
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (PropertyException e) {
            // ignore if can't format the way we want
            System.err.println("Error setting formatted property");
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        m.marshal(element, baos);
        return baos.toString();
    }

    /**
     * Convert an XML String to a message "Type", suitable for passing to one of
     * the IdePortType methods.
     * 
     * @param <T>
     *            the type (ex. ShipPositionReportType)
     * @param xml
     *            the xml to be converted
     * @return an object of type T
     * @throws JAXBException
     *             if the conversion fails.
     */
    @SuppressWarnings("unchecked")
    public static <T> T StringToType(String xml) throws JAXBException {
        JAXBElement<T> elt;
        JAXBContext jaxbctx = JAXBContext.newInstance(jaxbContextPath);
        Unmarshaller um = jaxbctx.createUnmarshaller();
        ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());
        elt = (JAXBElement<T>) um.unmarshal(bais);
        return elt.getValue();
    }

    /**
     * Create a MessageId using the DataCentre Id defined in the TesterContext
     * and the specified time.
     * 
     * @param dcc
     *            the TesterContext
     * @param curr
     *            the time to use for the MessageId
     * @return the MessageId.
     */
    public static String createMsgId(TesterContext dcc, Calendar curr) {
        return String.format("%04d%04d%02d%02d%02d%02d%02d%05d", Integer
                .parseInt(dcc.getDc1LritId()), curr.get(Calendar.YEAR), curr
                .get(Calendar.MONTH) + 1, curr.get(Calendar.DAY_OF_MONTH), curr
                .get(Calendar.HOUR_OF_DAY), curr.get(Calendar.MINUTE), curr
                .get(Calendar.SECOND), dcc.getMsgIdSuffix());
    }

    /**
     * Create a MessageId using the DataCentre Id defined in the TesterContext
     * and the current time.
     * 
     * @param dcc
     *            a reference to the TesterContext
     * @return the MessageId
     */
    public static String createMsgId(TesterContext dcc) {
        GregorianCalendar curr = new GregorianCalendar(TimeZone
                .getTimeZone("UTC"));
        return String.format("%04d%04d%02d%02d%02d%02d%02d%05d", Integer
                .parseInt(dcc.getDc1LritId()), curr.get(Calendar.YEAR), curr
                .get(Calendar.MONTH) + 1, curr.get(Calendar.DAY_OF_MONTH), curr
                .get(Calendar.HOUR_OF_DAY), curr.get(Calendar.MINUTE), curr
                .get(Calendar.SECOND), dcc.getMsgIdSuffix());
    }

    /**
     * Parses an integer field from LRIT message XML.
     * 
     * @param xml
     *            the LRIT message XML
     * @return the message type, or 0 if it cannot be parsed.
     */
    public static int parseIntField(String field, String xml) {
        String startTag = field + ">";
        int start = xml.indexOf(startTag) + startTag.length();
        int end = xml.indexOf("</", start);
        if (start == -1 || end == -1) {
            log.warn("Unable to parse field '" + field + "' from xml: " + xml);
            return 0;
        }
        String fld = xml.substring(start, end);
        log.debug("Found value for field '" + field + "': " + fld);
        return Integer.parseInt(fld);
    }

    /**
     * Parses a String field from LRIT message XML.
     * 
     * @param xml
     *            the LRIT message XML
     * @return the message type, or null if it cannot be parsed.
     */
    public static String parseField(String field, String xml) {
        String startTag = field + ">";
        int start = xml.indexOf(startTag) + startTag.length();
        int end = xml.indexOf("</", start);
        if (start == -1 || end == -1) {
            log.warn("Unable to parse field '" + field + "' from xml: " + xml);
            return null;
        }
        String fld = xml.substring(start, end);
        log.debug("Found value for field '" + field + "': " + fld);
        return fld;
    }

    /**
     * Sends an XML String (as derived from one of the LRIT types) to the IDE.
     * This method also bumps the sent message count for the type of message
     * sent.
     * 
     * @param xml
     *            the XML to send
     * @return "success" or "fail". In the case of "fail" a message will have
     *         been written to FacesMessages.
     */
    public static String sendDCTypeXMLToIDE(String xml) {
        IdeService svc;
        log.debug("Sending to IDE DC interface: " + xml);
        TesterContext testerCtx = (TesterContext) JSFUtil
                .getManagedBean("TesterContext");
        String ideURL = testerCtx.getIdeUrl();
        try {
            svc = new IdeService(new URL(ideURL + "?wsdl"),
                                 new QName(XMLHelper.IDE_SERVICE_NS,
                                           "ideService"));
            Dispatch<Source> disp = svc
                    .createDispatch(new QName(XMLHelper.IDE_SERVICE_NS,
                                              XMLHelper.IDE_PORT_NAME),
                                    Source.class, Service.Mode.PAYLOAD);
            StreamSource xmlSource = new StreamSource(new StringReader(xml));
            // Don't bother checking response - should be meaningless.
            disp.invoke(xmlSource);
        } catch (MalformedURLException e) {
            FacesContext.getCurrentInstance()
                    .addMessage(
                                null,
                                new FacesMessage("Invalid IDE DC URL: "
                                        + e.getMessage()));
            return "fail";
        } catch (RuntimeException re) {
            FacesContext.getCurrentInstance()
                    .addMessage(
                                null,
                                new FacesMessage("Error sending to IDE: "
                                        + re.getMessage()));
            return "fail";
        }
        testerCtx.bumpSentCount(MsgUtil.parseIntField("MessageType", xml));
        return "success";
    }
    
    /**
     * Sends an XML String (as derived from one of the LRIT types) to the IDE.
     * This method also bumps the sent message count for the type of message
     * sent.
     * 
     * @param xml
     *            the XML to send
     * @return "success" or "fail". In the case of "fail" a message will have
     *         been written to FacesMessages.
     */
    public static String sendDDPTypeXMLToIDE(String xml) {
        IdeService svc;
        log.debug("Sending to IDE DDP interface: " + xml);
        TesterContext testerCtx = (TesterContext) JSFUtil
                .getManagedBean("TesterContext");
        String ideURL = testerCtx.getIdeDdpUrl();
        try {
            svc = new IdeService(new URL(ideURL + "?wsdl"),
                                 new QName(XMLHelper.IDE_DDP_SERVICE_NS,
                                           XMLHelper.IDE_DDP_SERVICE_NAME));
            Dispatch<Source> disp = svc
                    .createDispatch(new QName(XMLHelper.IDE_DDP_SERVICE_NS,
                                              XMLHelper.IDE_DDP_PORT_NAME),
                                    Source.class, Service.Mode.PAYLOAD);
            StreamSource xmlSource = new StreamSource(new StringReader(xml));
            // Don't bother checking response - should be meaningless.
            disp.invoke(xmlSource);
        } catch (MalformedURLException e) {
            FacesContext.getCurrentInstance()
                    .addMessage(
                                null,
                                new FacesMessage("Invalid IDE DDP interface URL: "
                                        + e.getMessage()));
            return "fail";
        } catch (RuntimeException re) {
            FacesContext.getCurrentInstance()
                    .addMessage(
                                null,
                                new FacesMessage("Error sending to IDE: "
                                        + re.getMessage()));
            return "fail";
        }
        testerCtx.bumpSentCount(MsgUtil.parseIntField("MessageType", xml));
        return "success";
    }


    public static <T> String typeToXML(Class<T> clazz, T o, String namespace,
            String localname) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            JAXBElement<T> element = new JAXBElement<T>(new QName(namespace,
                                                                  localname),
                                                        clazz, (T) o);
            JAXBContext jaxbctx = JAXBContext.newInstance(clazz.getPackage()
                    .getName());
            Marshaller m = jaxbctx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(element, baos);
        } catch (Exception e) {
            throw new RuntimeException("JAXB Exception: ", e);
        }
        return baos.toString();
    }
}
