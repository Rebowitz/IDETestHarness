
package org.imo.gisis.xml.lrit.pricingnotification._2008;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.imo.gisis.xml.lrit.pricingnotification._2008 package. 
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

    private final static QName _PricingNotification_QNAME = new QName("http://gisis.imo.org/XML/LRIT/pricingNotification/2008", "PricingNotification");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.imo.gisis.xml.lrit.pricingnotification._2008
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PricingNotificationType }
     * 
     */
    public PricingNotificationType createPricingNotificationType() {
        return new PricingNotificationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PricingNotificationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://gisis.imo.org/XML/LRIT/pricingNotification/2008", name = "PricingNotification")
    public JAXBElement<PricingNotificationType> createPricingNotification(PricingNotificationType value) {
        return new JAXBElement<PricingNotificationType>(_PricingNotification_QNAME, PricingNotificationType.class, null, value);
    }

}
