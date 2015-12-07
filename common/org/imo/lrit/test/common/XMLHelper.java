/**
 * 
 */
package org.imo.lrit.test.common;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * A helper class containing constants and static methods useful for dealing
 * with LRIT XML.
 * 
 * @author llawrenc
 * 
 */
public class XMLHelper {
    public static final String DC_PORT_NAME = "dcPort";
    public static final String DC_SERVICE_NAME = "dcService";
    public static final String DC_SERVICE_NS = "http://gisis.imo.org/XML/LRIT/2008";
    public static final String DDP_NOTIFICATION_LOCAL_NAME = "DDPNotification";
    public static final String DDP_NOTIFICATION_NS = "http://gisis.imo.org/XML/LRIT/ddpNotification/2008";
    public static final String DDP_NOTIFICATION_PKG = "org.imo.gisis.xml.lrit.ddpnotification._2008";
    public static final String DDP_PORT_NAME = "ddpPort";
    public static final String DDP_REQUEST_LOCAL_NAME = "DDPRequest";
    public static final String DDP_REQUEST_NS = "http://gisis.imo.org/XML/LRIT/ddpRequest/2008";
    public static final String DDP_REQUEST_PKG = "org.imo.gisis.xml.lrit.ddprequest._2008";
    public static final String DDP_SERVICE_NAME = "ddpService";
    public static final String DDP_SERVICE_NS = "http://gisis.imo.org/XML/LRIT/2008";
    public static final String DDP_UPDATE_LOCAL_NAME = "DDPUpdate";
    public static final String DDP_UPDATE_NS = "http://gisis.imo.org/XML/LRIT/ddpUpdate/2008";
    public static final String DDP_UPDATE_PKG = "org.imo.gisis.xml.lrit.ddpupdate._2008";
    public static final String IDE_PORT_NAME = "idePort";
    public static final String IDE_SERVICE_NAME = "ideService";
    public static final String IDE_SERVICE_NS = "http://gisis.imo.org/XML/LRIT/2008";
    public static final String JOURNAL_REPORT_LOCAL_NAME = "JournalReport";
    public static final String JOURNAL_REPORT_NS = "http://gisis.imo.org/XML/LRIT/journalReport/2008";
    public static final String JOURNAL_REPORT_PKG = "org.imo.gisis.xml.lrit.journalreport._2008";
    public static final String POSITION_REPORT_LOCAL_NAME = "ShipPositionReport";
    public static final String POSITION_REPORT_NS = "http://gisis.imo.org/XML/LRIT/positionReport/2008";
    public static final String POSITION_REPORT_PKG = "org.imo.gisis.xml.lrit.positionreport._2008";
    public static final String POSITION_REQUEST_LOCAL_NAME = "ShipPositionRequest";
    public static final String POSITION_REQUEST_NS = "http://gisis.imo.org/XML/LRIT/positionRequest/2008";
    public static final String POSITION_REQUEST_PKG = "org.imo.gisis.xml.lrit.positionrequest._2008";
    public static final String PRICING_REQUEST_LOCAL_NAME = "PricingRequest";
    public static final String PRICING_REQUEST_NS = "http://gisis.imo.org/XML/LRIT/pricingRequest/2008";
    public static final String PRICING_REQUEST_PKG = "org.imo.gisis.xml.lrit.pricingrequest._2008";
    public static final String PRICING_UPDATE_LOCAL_NAME = "PricingUpdate";
    public static final String PRICING_UPDATE_NS = "http://gisis.imo.org/XML/LRIT/pricingUpdate/2008";
    public static final String PRICING_UPDATE_PKG = "org.imo.gisis.xml.lrit.pricingupdate._2008";
    public static final String RECEIPT_LOCAL_NAME = "Receipt";
    public static final String RECEIPT_NS = "http://gisis.imo.org/XML/LRIT/receipt/2008";
    public static final String RECEIPT_PKG = "org.imo.gisis.xml.lrit.receipt._2008";
    public static final String RESPONSE_LOCAL_NAME = "Response";
    public static final String RESPONSE_NS = "http://gisis.imo.org/XML/LRIT/2008";
    public static final String RESPONSE_PKG = "org.imo.gisis.xml.lrit._2008";
    public static final String SAR_SURPIC_LOCAL_NAME = "SARSURPICRequest";
    public static final String SAR_SURPIC_NS = "http://gisis.imo.org/XML/LRIT/sarSurpicRequest/2008";
    public static final String SAR_SURPIC_PKG = "org.imo.gisis.xml.lrit.sarsurpicrequest._2008";
    public static final String SYSTEM_STATUS_LOCAL_NAME = "SystemStatus";
    public static final String SYSTEM_STATUS_NS = "http://gisis.imo.org/XML/LRIT/systemStatus/2008";
    public static final String SYSTEM_STATUS_PKG = "org.imo.gisis.xml.lrit.systemstatus._2008";
    public static final String XML_SCHEMA_NS = "http://www.w3.org/2001/XMLSchema";

    public static XMLGregorianCalendar gcToXMLgc(GregorianCalendar gc) {
        DatatypeFactory dtf;
        try {
            dtf = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException("Unable to obtain DatatypeFactory:", e);
        }
        XMLGregorianCalendar xmlgc = dtf.newXMLGregorianCalendar(gc
                .get(Calendar.YEAR), gc.get(Calendar.MONTH) + 1, gc
                .get(Calendar.DAY_OF_MONTH), gc.get(Calendar.HOUR_OF_DAY), gc
                .get(Calendar.MINUTE), gc.get(Calendar.SECOND), gc
                .get(Calendar.MILLISECOND), gc.get(Calendar.ZONE_OFFSET));
        return xmlgc;
    }
}
