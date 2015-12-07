
package org.imo.gisis.xml.lrit.pricingnotification._2008;

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
 * The "Pricing Notification" message is sent by the IDE to each
 * Data Centre after it has received a "Pricing Update" from a Data
 * Centre.  The "Pricing Notification" indicates that new pricing
 * information is available.  
 * 
 * Receiving Data Centres are expected to send a subsequent "Pricing 
 * Request" message back to the IDE in order to receive the new 
 * pricing information.  The new pricing information is then sent by
 * the IDE, to the Data Centre, in the form of a "Pricing Update" message.
 *             
 * 
 * <p>Java class for PricingNotificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PricingNotificationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageType" type="{http://gisis.imo.org/XML/LRIT/pricingNotification/2008}messageTypeType"/>
 *         &lt;element name="MessageId" type="{http://gisis.imo.org/XML/LRIT/types/2008}msgIDType"/>
 *         &lt;element name="Message" type="{http://gisis.imo.org/XML/LRIT/types/2008}messageType"/>
 *         &lt;element name="TimeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PricingVersionNum" type="{http://gisis.imo.org/XML/LRIT/types/2008}pricingVersionNumType"/>
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
@XmlType(name = "PricingNotificationType", propOrder = {
    "messageType",
    "messageId",
    "message",
    "timeStamp",
    "pricingVersionNum",
    "ddpVersionNum"
})
public class PricingNotificationType {

    @XmlElement(name = "MessageType", required = true)
    protected BigInteger messageType;
    @XmlElement(name = "MessageId", required = true)
    protected String messageId;
    @XmlElement(name = "Message", required = true)
    protected String message;
    @XmlElement(name = "TimeStamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeStamp;
    @XmlElement(name = "PricingVersionNum", required = true)
    protected BigInteger pricingVersionNum;
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
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
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
     * Gets the value of the pricingVersionNum property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPricingVersionNum() {
        return pricingVersionNum;
    }

    /**
     * Sets the value of the pricingVersionNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPricingVersionNum(BigInteger value) {
        this.pricingVersionNum = value;
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
