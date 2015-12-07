
package org.imo.gisis.xml.lrit.positionrequest._2008;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.imo.gisis.xml.lrit.positionrequest._2008 package. 
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

    private final static QName _ShipPositionRequest_QNAME = new QName("http://gisis.imo.org/XML/LRIT/positionRequest/2008", "ShipPositionRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.imo.gisis.xml.lrit.positionrequest._2008
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ShipPositionRequestType }
     * 
     */
    public ShipPositionRequestType createShipPositionRequestType() {
        return new ShipPositionRequestType();
    }

    /**
     * Create an instance of {@link RequestDurationType }
     * 
     */
    public RequestDurationType createRequestDurationType() {
        return new RequestDurationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShipPositionRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gisis.imo.org/XML/LRIT/positionRequest/2008", name = "ShipPositionRequest")
    public JAXBElement<ShipPositionRequestType> createShipPositionRequest(ShipPositionRequestType value) {
        return new JAXBElement<ShipPositionRequestType>(_ShipPositionRequest_QNAME, ShipPositionRequestType.class, null, value);
    }

}
