
package org.imo.gisis.xml.lrit.journalreport._2008;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for JournalReportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JournalReportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageType" type="{http://gisis.imo.org/XML/LRIT/journalReport/2008}messageTypeType"/>
 *         &lt;element name="MessageId" type="{http://gisis.imo.org/XML/LRIT/types/2008}msgIDType"/>
 *         &lt;element name="Message" type="{http://gisis.imo.org/XML/LRIT/types/2008}messageType"/>
 *         &lt;element name="TimeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Originator" type="{http://gisis.imo.org/XML/LRIT/types/2008}lritIDType"/>
 *         &lt;element name="JournalFile" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="DDPVersionNum" type="{http://gisis.imo.org/XML/LRIT/types/2008}ddpVersionNumType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="test" type="{http://gisis.imo.org/XML/LRIT/types/2008}testType" default="0" />
 *       &lt;attribute name="schemaVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JournalReportType", propOrder = {
    "messageType",
    "messageId",
    "message",
    "timeStamp",
    "originator",
    "journalFile",
    "ddpVersionNum"
})
public class JournalReportType {

    @XmlElement(name = "MessageType", required = true)
    protected BigInteger messageType;
    @XmlElement(name = "MessageId", required = true)
    protected String messageId;
    @XmlElement(name = "Message", required = true)
    protected String message;
    @XmlElement(name = "TimeStamp", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeStamp;
    @XmlElement(name = "Originator", required = true)
    protected String originator;
    @XmlElement(name = "JournalFile", required = true)
    @XmlMimeType("application/zip")
    protected DataHandler journalFile;
    @XmlElement(name = "DDPVersionNum", required = true)
    protected String ddpVersionNum;
    @XmlAttribute
    protected BigInteger test;
    @XmlAttribute(required = true)
    protected BigDecimal schemaVersion;

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
     * Gets the value of the journalFile property.
     * 
     * @return
     *     possible object is
     *     {@link DataHandler }
     *     
     */
    public DataHandler getJournalFile() {
        return journalFile;
    }

    /**
     * Sets the value of the journalFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataHandler }
     *     
     */
    public void setJournalFile(DataHandler value) {
        this.journalFile = value;
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

    /**
     * Gets the value of the schemaVersion property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSchemaVersion() {
        return schemaVersion;
    }

    /**
     * Sets the value of the schemaVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSchemaVersion(BigDecimal value) {
        this.schemaVersion = value;
    }

}
