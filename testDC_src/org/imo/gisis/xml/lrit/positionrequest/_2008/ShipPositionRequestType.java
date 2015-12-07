
package org.imo.gisis.xml.lrit.positionrequest._2008;

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
 * The ShipPositionRequest message is used to request positional data
 * for a specific ship.
 * 
 *             
 * 
 * <p>Java class for ShipPositionRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShipPositionRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageType" type="{http://gisis.imo.org/XML/LRIT/positionRequest/2008}messageTypeType"/>
 *         &lt;element name="MessageId" type="{http://gisis.imo.org/XML/LRIT/types/2008}msgIDType"/>
 *         &lt;element name="IMONum" type="{http://gisis.imo.org/XML/LRIT/types/2008}imoNumType"/>
 *         &lt;element name="DataUserProvider" type="{http://gisis.imo.org/XML/LRIT/types/2008}lritIDType"/>
 *         &lt;element name="AccessType" type="{http://gisis.imo.org/XML/LRIT/positionRequest/2008}accessTypeType"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="Port" type="{http://gisis.imo.org/XML/LRIT/types/2008}locodeType"/>
 *           &lt;element name="PortFacility" type="{http://gisis.imo.org/XML/LRIT/types/2008}imoPortFacilityNumberType"/>
 *           &lt;element name="Place" type="{http://gisis.imo.org/XML/LRIT/types/2008}placeCodeType"/>
 *         &lt;/choice>
 *         &lt;element name="Distance" type="{http://gisis.imo.org/XML/LRIT/positionRequest/2008}distanceType"/>
 *         &lt;element name="RequestType" type="{http://gisis.imo.org/XML/LRIT/positionRequest/2008}requestTypeType"/>
 *         &lt;element name="RequestDuration" type="{http://gisis.imo.org/XML/LRIT/positionRequest/2008}requestDurationType" minOccurs="0"/>
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
@XmlType(name = "ShipPositionRequestType", propOrder = {
    "messageType",
    "messageId",
    "imoNum",
    "dataUserProvider",
    "accessType",
    "port",
    "portFacility",
    "place",
    "distance",
    "requestType",
    "requestDuration",
    "dataUserRequestor",
    "timeStamp",
    "ddpVersionNum"
})
public class ShipPositionRequestType {

    @XmlElement(name = "MessageType", required = true)
    protected BigInteger messageType;
    @XmlElement(name = "MessageId", required = true)
    protected String messageId;
    @XmlElement(name = "IMONum", required = true)
    protected String imoNum;
    @XmlElement(name = "DataUserProvider", required = true)
    protected String dataUserProvider;
    @XmlElement(name = "AccessType", required = true)
    protected BigInteger accessType;
    @XmlElement(name = "Port")
    protected String port;
    @XmlElement(name = "PortFacility")
    protected String portFacility;
    @XmlElement(name = "Place")
    protected String place;
    @XmlElement(name = "Distance")
    protected int distance;
    @XmlElement(name = "RequestType", required = true)
    protected BigInteger requestType;
    @XmlElement(name = "RequestDuration")
    protected RequestDurationType requestDuration;
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
     * Gets the value of the imoNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIMONum() {
        return imoNum;
    }

    /**
     * Sets the value of the imoNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIMONum(String value) {
        this.imoNum = value;
    }

    /**
     * Gets the value of the dataUserProvider property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataUserProvider() {
        return dataUserProvider;
    }

    /**
     * Sets the value of the dataUserProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataUserProvider(String value) {
        this.dataUserProvider = value;
    }

    /**
     * Gets the value of the accessType property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAccessType() {
        return accessType;
    }

    /**
     * Sets the value of the accessType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAccessType(BigInteger value) {
        this.accessType = value;
    }

    /**
     * Gets the value of the port property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPort(String value) {
        this.port = value;
    }

    /**
     * Gets the value of the portFacility property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortFacility() {
        return portFacility;
    }

    /**
     * Sets the value of the portFacility property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortFacility(String value) {
        this.portFacility = value;
    }

    /**
     * Gets the value of the place property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlace() {
        return place;
    }

    /**
     * Sets the value of the place property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlace(String value) {
        this.place = value;
    }

    /**
     * Gets the value of the distance property.
     * 
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Sets the value of the distance property.
     * 
     */
    public void setDistance(int value) {
        this.distance = value;
    }

    /**
     * Gets the value of the requestType property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRequestType() {
        return requestType;
    }

    /**
     * Sets the value of the requestType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRequestType(BigInteger value) {
        this.requestType = value;
    }

    /**
     * Gets the value of the requestDuration property.
     * 
     * @return
     *     possible object is
     *     {@link RequestDurationType }
     *     
     */
    public RequestDurationType getRequestDuration() {
        return requestDuration;
    }

    /**
     * Sets the value of the requestDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestDurationType }
     *     
     */
    public void setRequestDuration(RequestDurationType value) {
        this.requestDuration = value;
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
