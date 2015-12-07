
package org.imo.gisis.xml.lrit.sarsurpicrequest._2008;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SARSURPICType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SARSURPICType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageType" type="{http://gisis.imo.org/XML/LRIT/sarSurpicRequest/2008}messageTypeType"/>
 *         &lt;element name="MessageId" type="{http://gisis.imo.org/XML/LRIT/types/2008}msgIDType"/>
 *         &lt;choice>
 *           &lt;element name="SARCircularArea" type="{http://gisis.imo.org/XML/LRIT/sarSurpicRequest/2008}sarCircularAreaType"/>
 *           &lt;element name="SARRectangularArea" type="{http://gisis.imo.org/XML/LRIT/sarSurpicRequest/2008}sarRectangularAreaType"/>
 *         &lt;/choice>
 *         &lt;element name="NumberOfPositions" type="{http://gisis.imo.org/XML/LRIT/sarSurpicRequest/2008}numberOfPositionsType"/>
 *         &lt;element name="DataUserRequestor" type="{http://gisis.imo.org/XML/LRIT/types/2008}lritIDType"/>
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
@XmlType(name = "SARSURPICType", propOrder = {
    "messageType",
    "messageId",
    "sarCircularArea",
    "sarRectangularArea",
    "numberOfPositions",
    "dataUserRequestor",
    "timeStamp",
    "ddpVersionNum"
})
public class SARSURPICType {

    @XmlElement(name = "MessageType", required = true)
    protected BigInteger messageType;
    @XmlElement(name = "MessageId", required = true)
    protected String messageId;
    @XmlElement(name = "SARCircularArea")
    protected String sarCircularArea;
    @XmlElement(name = "SARRectangularArea")
    protected String sarRectangularArea;
    @XmlElement(name = "NumberOfPositions")
    protected int numberOfPositions;
    @XmlElement(name = "DataUserRequestor", required = true)
    protected String dataUserRequestor;
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
     * Gets the value of the sarCircularArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSARCircularArea() {
        return sarCircularArea;
    }

    /**
     * Sets the value of the sarCircularArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSARCircularArea(String value) {
        this.sarCircularArea = value;
    }

    /**
     * Gets the value of the sarRectangularArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSARRectangularArea() {
        return sarRectangularArea;
    }

    /**
     * Sets the value of the sarRectangularArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSARRectangularArea(String value) {
        this.sarRectangularArea = value;
    }

    /**
     * Gets the value of the numberOfPositions property.
     * 
     */
    public int getNumberOfPositions() {
        return numberOfPositions;
    }

    /**
     * Sets the value of the numberOfPositions property.
     * 
     */
    public void setNumberOfPositions(int value) {
        this.numberOfPositions = value;
    }

    /**
     * Gets the value of the dataUserRequestor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataUserRequestor() {
        return dataUserRequestor;
    }

    /**
     * Sets the value of the dataUserRequestor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataUserRequestor(String value) {
        this.dataUserRequestor = value;
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
