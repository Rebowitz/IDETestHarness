
package org.imo.lrit.ide.testToIDE;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.imo.lrit.ide.testToIDE package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PricingRequest_QNAME = new QName("http://gisis.imo.org/XML/LRIT/pricingRequest/2008", "PricingRequest");
    private final static QName _SystemStatus_QNAME = new QName("http://gisis.imo.org/XML/LRIT/systemStatus/2008", "SystemStatus");
    private final static QName _Receipt_QNAME = new QName("http://gisis.imo.org/XML/LRIT/receipt/2008", "Receipt");
    private final static QName _JournalReport_QNAME = new QName("http://gisis.imo.org/XML/LRIT/journalReport/2008", "JournalReport");
    private final static QName _SARSURPICRequest_QNAME = new QName("http://gisis.imo.org/XML/LRIT/sarSurpicRequest/2008", "SARSURPICRequest");
    private final static QName _ShipPositionReport_QNAME = new QName("http://gisis.imo.org/XML/LRIT/positionReport/2008", "ShipPositionReport");
    private final static QName _ShipPositionRequest_QNAME = new QName("http://gisis.imo.org/XML/LRIT/positionRequest/2008", "ShipPositionRequest");
    private final static QName _PricingUpdate_QNAME = new QName("http://gisis.imo.org/XML/LRIT/pricingUpdate/2008", "PricingUpdate");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.imo.lrit.ide.testToIDE
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link ReceiptType }
     * 
     */
    public ReceiptType createReceiptType() {
        return new ReceiptType();
    }

    /**
     * Create an instance of {@link SARSURPICType }
     * 
     */
    public SARSURPICType createSARSURPICType() {
        return new SARSURPICType();
    }

    /**
     * Create an instance of {@link SystemStatusType }
     * 
     */
    public SystemStatusType createSystemStatusType() {
        return new SystemStatusType();
    }

    /**
     * Create an instance of {@link ShipPositionRequestType }
     * 
     */
    public ShipPositionRequestType createShipPositionRequestType() {
        return new ShipPositionRequestType();
    }

    /**
     * Create an instance of {@link PolygonType }
     * 
     */
    public PolygonType createPolygonType() {
        return new PolygonType();
    }

    /**
     * Create an instance of {@link JournalReportType }
     * 
     */
    public JournalReportType createJournalReportType() {
        return new JournalReportType();
    }

    /**
     * Create an instance of {@link ShipPositionReportType }
     * 
     */
    public ShipPositionReportType createShipPositionReportType() {
        return new ShipPositionReportType();
    }

    /**
     * Create an instance of {@link RequestDurationType }
     * 
     */
    public RequestDurationType createRequestDurationType() {
        return new RequestDurationType();
    }

    /**
     * Create an instance of {@link PricingRequestType }
     * 
     */
    public PricingRequestType createPricingRequestType() {
        return new PricingRequestType();
    }

    /**
     * Create an instance of {@link PricingUpdateType }
     * 
     */
    public PricingUpdateType createPricingUpdateType() {
        return new PricingUpdateType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PricingRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gisis.imo.org/XML/LRIT/pricingRequest/2008", name = "PricingRequest")
    public JAXBElement<PricingRequestType> createPricingRequest(PricingRequestType value) {
        return new JAXBElement<PricingRequestType>(_PricingRequest_QNAME, PricingRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SystemStatusType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gisis.imo.org/XML/LRIT/systemStatus/2008", name = "SystemStatus")
    public JAXBElement<SystemStatusType> createSystemStatus(SystemStatusType value) {
        return new JAXBElement<SystemStatusType>(_SystemStatus_QNAME, SystemStatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceiptType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gisis.imo.org/XML/LRIT/receipt/2008", name = "Receipt")
    public JAXBElement<ReceiptType> createReceipt(ReceiptType value) {
        return new JAXBElement<ReceiptType>(_Receipt_QNAME, ReceiptType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JournalReportType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gisis.imo.org/XML/LRIT/journalReport/2008", name = "JournalReport")
    public JAXBElement<JournalReportType> createJournalReport(JournalReportType value) {
        return new JAXBElement<JournalReportType>(_JournalReport_QNAME, JournalReportType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SARSURPICType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gisis.imo.org/XML/LRIT/sarSurpicRequest/2008", name = "SARSURPICRequest")
    public JAXBElement<SARSURPICType> createSARSURPICRequest(SARSURPICType value) {
        return new JAXBElement<SARSURPICType>(_SARSURPICRequest_QNAME, SARSURPICType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShipPositionReportType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gisis.imo.org/XML/LRIT/positionReport/2008", name = "ShipPositionReport")
    public JAXBElement<ShipPositionReportType> createShipPositionReport(ShipPositionReportType value) {
        return new JAXBElement<ShipPositionReportType>(_ShipPositionReport_QNAME, ShipPositionReportType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShipPositionRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gisis.imo.org/XML/LRIT/positionRequest/2008", name = "ShipPositionRequest")
    public JAXBElement<ShipPositionRequestType> createShipPositionRequest(ShipPositionRequestType value) {
        return new JAXBElement<ShipPositionRequestType>(_ShipPositionRequest_QNAME, ShipPositionRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PricingUpdateType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gisis.imo.org/XML/LRIT/pricingUpdate/2008", name = "PricingUpdate")
    public JAXBElement<PricingUpdateType> createPricingUpdate(PricingUpdateType value) {
        return new JAXBElement<PricingUpdateType>(_PricingUpdate_QNAME, PricingUpdateType.class, null, value);
    }

}
