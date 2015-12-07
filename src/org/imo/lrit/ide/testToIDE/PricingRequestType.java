
package org.imo.lrit.ide.testToIDE;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * The “Pricing Request" message is sent to the IDE in response to
 * a "Pricing Notification" message received from the IDE.  This 
 * message requests that the IDE send a "Pricing Update" message
 * containing all of the most recent pricing information. 
 *             
 * 
 * <p>Java class for PricingRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PricingRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageType" type="{http://gisis.imo.org/XML/LRIT/pricingRequest/2008}messageTypeType"/>
 *         &lt;element name="MessageId" type="{http://gisis.imo.org/XML/LRIT/types/2008}msgIDType"/>
 *         &lt;element name="Originator" type="{http://gisis.imo.org/XML/LRIT/types/2008}lritIDType"/>
 *         &lt;element name="TimeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DDPVersionNum" type="{http://gisis.imo.org/XML/LRIT/types/2008}ddpVersionNumType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="test" type="{http://gisis.imo.org/XML/LRIT/types/2008}testType" default="0" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PricingRequestType", namespace = "http://gisis.imo.org/XML/LRIT/pricingRequest/2008", propOrder = {
    "messageType",
    "messageId",
    "originator",
    "timeStamp",
    "ddpVersionNum"
})
public class PricingRequestType {

    @XmlElement(name = "MessageType", required = true)
    protected BigInteger messageType;
    @XmlElement(name = "MessageId", required = true)
    protected String messageId;
    @XmlElement(name = "Originator", required = true)
    protected String originator;
    @XmlElement(name = "TimeStamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeStamp;
    @XmlElement(name = "DDPVersionNum", required = true)
    protected String ddpVersionNum;
    @XmlAttribute
    protected BigInteger test;

    /**
     * Gets the value of the messageType property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMessageType() {
        return messageType;
    }

    /**
     * Sets the value of the messageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMessageType(BigInteger value) {
        this.messageType = value;
    }

    /**
     * Gets the value of the messageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets the value of the messageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageId(String value) {
        this.messageId = value;
    }

    /**
     * Gets the value of the originator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginator() {
        return originator;
    }

    /**
     * Sets the value of the originator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginator(String value) {
        this.originator = value;
    }

    /**
     * Gets the value of the timeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the value of the timeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeStamp(XMLGregorianCalendar value) {
        this.timeStamp = value;
    }

    /**
     * Gets the value of the ddpVersionNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDDPVersionNum() {
        return ddpVersionNum;
    }

    /**
     * Sets the value of the ddpVersionNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDDPVersionNum(String value) {
        this.ddpVersionNum = value;
    }

    /**
     * Gets the value of the test property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTest() {
        if (test == null) {
            return new BigInteger("0");
        } else {
            return test;
        }
    }

    /**
     * Sets the value of the test property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTest(BigInteger value) {
        this.test = value;
    }

}
