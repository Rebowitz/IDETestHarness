
package org.imo.lrit.ide.testToIDE;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ShipPositionReportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ShipPositionReportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Latitude" type="{http://gisis.imo.org/XML/LRIT/types/2008}latitudeType"/>
 *         &lt;element name="Longitude" type="{http://gisis.imo.org/XML/LRIT/types/2008}longitudeType"/>
 *         &lt;element name="TimeStamp1" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ShipborneEquipmentId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ASPId" type="{http://gisis.imo.org/XML/LRIT/types/2008}lritIDType"/>
 *         &lt;element name="CSPId" type="{http://gisis.imo.org/XML/LRIT/types/2008}lritIDType"/>
 *         &lt;element name="MessageType" type="{http://gisis.imo.org/XML/LRIT/positionReport/2008}messageTypeType"/>
 *         &lt;element name="MessageId" type="{http://gisis.imo.org/XML/LRIT/types/2008}msgIDType"/>
 *         &lt;element name="ReferenceId" type="{http://gisis.imo.org/XML/LRIT/types/2008}refIDType"/>
 *         &lt;element name="IMONum" type="{http://gisis.imo.org/XML/LRIT/types/2008}imoNumType"/>
 *         &lt;element name="MMSINum" type="{http://gisis.imo.org/XML/LRIT/types/2008}mmsiNumType" minOccurs="0"/>
 *         &lt;element name="TimeStamp2" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="TimeStamp3" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="DCId" type="{http://gisis.imo.org/XML/LRIT/types/2008}lritIDType"/>
 *         &lt;element name="TimeStamp4" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="TimeStamp5" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ResponseType" type="{http://gisis.imo.org/XML/LRIT/types/2008}responseTypeType"/>
 *         &lt;element name="DataUserRequestor" type="{http://gisis.imo.org/XML/LRIT/types/2008}lritIDType"/>
 *         &lt;element name="ShipName" type="{http://gisis.imo.org/XML/LRIT/types/2008}shipNameType" minOccurs="0"/>
 *         &lt;element name="DataUserProvider" type="{http://gisis.imo.org/XML/LRIT/types/2008}lritIDType"/>
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
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipPositionReportType", namespace = "http://gisis.imo.org/XML/LRIT/positionReport/2008", propOrder = {
    "latitude",
    "longitude",
    "timeStamp1",
    "shipborneEquipmentId",
    "aspId",
    "cspId",
    "messageType",
    "messageId",
    "referenceId",
    "imoNum",
    "mmsiNum",
    "timeStamp2",
    "timeStamp3",
    "dcId",
    "timeStamp4",
    "timeStamp5",
    "responseType",
    "dataUserRequestor",
    "shipName",
    "dataUserProvider",
    "ddpVersionNum"
})
public class ShipPositionReportType {

    @XmlElement(name = "Latitude", required = true)
    protected String latitude;
    @XmlElement(name = "Longitude", required = true)
    protected String longitude;
    @XmlElement(name = "TimeStamp1", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeStamp1;
    @XmlElement(name = "ShipborneEquipmentId", required = true)
    protected String shipborneEquipmentId;
    @XmlElement(name = "ASPId", required = true)
    protected String aspId;
    @XmlElement(name = "CSPId", required = true)
    protected String cspId;
    @XmlElement(name = "MessageType", required = true)
    protected Integer messageType;
    @XmlElement(name = "MessageId", required = true)
    protected String messageId;
    @XmlElement(name = "ReferenceId", required = true)
    protected String referenceId;
    @XmlElement(name = "IMONum", required = true)
    protected String imoNum;
    @XmlElement(name = "MMSINum")
    protected String mmsiNum;
    @XmlElement(name = "TimeStamp2", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeStamp2;
    @XmlElement(name = "TimeStamp3", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeStamp3;
    @XmlElement(name = "DCId", required = true)
    protected String dcId;
    @XmlElement(name = "TimeStamp4", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeStamp4;
    @XmlElement(name = "TimeStamp5", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeStamp5;
    @XmlElement(name = "ResponseType", required = true)
    protected Integer responseType;
    @XmlElement(name = "DataUserRequestor", required = true)
    protected String dataUserRequestor;
    @XmlElement(name = "ShipName")
    protected String shipName;
    @XmlElement(name = "DataUserProvider", required = true)
    protected String dataUserProvider;
    @XmlElement(name = "DDPVersionNum", required = true)
    protected String ddpVersionNum;
    @XmlAttribute
    protected Integer test;

    /**
     * Gets the value of the latitude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatitude(String value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the longitude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongitude(String value) {
        this.longitude = value;
    }

    /**
     * Gets the value of the timeStamp1 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeStamp1() {
        return timeStamp1;
    }

    /**
     * Sets the value of the timeStamp1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeStamp1(XMLGregorianCalendar value) {
        this.timeStamp1 = value;
    }

    /**
     * Gets the value of the shipborneEquipmentId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipborneEquipmentId() {
        return shipborneEquipmentId;
    }

    /**
     * Sets the value of the shipborneEquipmentId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipborneEquipmentId(String value) {
        this.shipborneEquipmentId = value;
    }

    /**
     * Gets the value of the aspId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getASPId() {
        return aspId;
    }

    /**
     * Sets the value of the aspId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setASPId(String value) {
        this.aspId = value;
    }

    /**
     * Gets the value of the cspId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSPId() {
        return cspId;
    }

    /**
     * Sets the value of the cspId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSPId(String value) {
        this.cspId = value;
    }

    /**
     * Gets the value of the messageType property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public Integer getMessageType() {
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
    public void setMessageType(Integer value) {
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
     * Gets the value of the referenceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Sets the value of the referenceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceId(String value) {
        this.referenceId = value;
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
     * Gets the value of the mmsiNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMMSINum() {
        return mmsiNum;
    }

    /**
     * Sets the value of the mmsiNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMMSINum(String value) {
        this.mmsiNum = value;
    }

    /**
     * Gets the value of the timeStamp2 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeStamp2() {
        return timeStamp2;
    }

    /**
     * Sets the value of the timeStamp2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeStamp2(XMLGregorianCalendar value) {
        this.timeStamp2 = value;
    }

    /**
     * Gets the value of the timeStamp3 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeStamp3() {
        return timeStamp3;
    }

    /**
     * Sets the value of the timeStamp3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeStamp3(XMLGregorianCalendar value) {
        this.timeStamp3 = value;
    }

    /**
     * Gets the value of the dcId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDCId() {
        return dcId;
    }

    /**
     * Sets the value of the dcId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDCId(String value) {
        this.dcId = value;
    }

    /**
     * Gets the value of the timeStamp4 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeStamp4() {
        return timeStamp4;
    }

    /**
     * Sets the value of the timeStamp4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeStamp4(XMLGregorianCalendar value) {
        this.timeStamp4 = value;
    }

    /**
     * Gets the value of the timeStamp5 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeStamp5() {
        return timeStamp5;
    }

    /**
     * Sets the value of the timeStamp5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeStamp5(XMLGregorianCalendar value) {
        this.timeStamp5 = value;
    }

    /**
     * Gets the value of the responseType property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public Integer getResponseType() {
        return responseType;
    }

    /**
     * Sets the value of the responseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setResponseType(Integer value) {
        this.responseType = value;
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
     * Gets the value of the shipName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipName() {
        return shipName;
    }

    /**
     * Sets the value of the shipName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipName(String value) {
        this.shipName = value;
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
     *     {@link Integer }
     *     
     */
    public Integer getTest() {
        if (test == null) {
            return new Integer("0");
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
    public void setTest(Integer value) {
        this.test = value;
    }

}
