
package org.imo.gisis.xml.lrit.ddprequest._2008;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DDPRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DDPRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageType" type="{http://gisis.imo.org/XML/LRIT/ddpRequest/2008}messageTypeType"/>
 *         &lt;element name="MessageId" type="{http://gisis.imo.org/XML/LRIT/types/2008}msgIDType"/>
 *         &lt;element name="UpdateType">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;enumeration value="0"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ArchivedDDPVersionNum" type="{http://gisis.imo.org/XML/LRIT/types/2008}ddpVersionNumType" minOccurs="0"/>
 *         &lt;element name="ArchivedDDPTimeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
@XmlType(name = "DDPRequestType", propOrder = {
    "messageType",
    "messageId",
    "updateType",
    "archivedDDPVersionNum",
    "archivedDDPTimeStamp",
    "originator",
    "timeStamp",
    "ddpVersionNum"
})
public class DDPRequestType {

    @XmlElement(name = "MessageType", required = true)
    protected BigInteger messageType;
    @XmlElement(name = "MessageId", required = true)
    protected String messageId;
    @XmlElement(name = "UpdateType", required = true)
    protected BigInteger updateType;
    @XmlElement(name = "ArchivedDDPVersionNum")
    protected String archivedDDPVersionNum;
    @XmlElement(name = "ArchivedDDPTimeStamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar archivedDDPTimeStamp;
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
     * Gets the value of the updateType property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUpdateType() {
        return updateType;
    }

    /**
     * Sets the value of the updateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUpdateType(BigInteger value) {
        this.updateType = value;
    }

    /**
     * Gets the value of the archivedDDPVersionNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArchivedDDPVersionNum() {
        return archivedDDPVersionNum;
    }

    /**
     * Sets the value of the archivedDDPVersionNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArchivedDDPVersionNum(String value) {
        this.archivedDDPVersionNum = value;
    }

    /**
     * Gets the value of the archivedDDPTimeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getArchivedDDPTimeStamp() {
        return archivedDDPTimeStamp;
    }

    /**
     * Sets the value of the archivedDDPTimeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setArchivedDDPTimeStamp(XMLGregorianCalendar value) {
        this.archivedDDPTimeStamp = value;
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
