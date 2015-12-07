//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-520 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.01.02 at 02:31:37 PM EST 
//


package org.imo.gisis.xml.lrit.ddp._2008;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataCentreInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataCentreInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DataCentreID" type="{http://gisis.imo.org/XML/LRIT/types/2008}dataCentreLRITIDType"/>
 *         &lt;element name="ContactPoint" type="{http://gisis.imo.org/XML/LRIT/ddp/2008}contactPointType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="dcInfoID" use="required" type="{http://gisis.imo.org/XML/LRIT/ddp/2008}dcInfoIDType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataCentreInfoType", propOrder = {
    "dataCentreID",
    "contactPoint"
})
public class DataCentreInfoType {

    @XmlElement(name = "DataCentreID", required = true)
    protected String dataCentreID;
    @XmlElement(name = "ContactPoint")
    protected List<ContactPointType> contactPoint;
    @XmlAttribute(required = true)
    protected String dcInfoID;

    /**
     * Gets the value of the dataCentreID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataCentreID() {
        return dataCentreID;
    }

    /**
     * Sets the value of the dataCentreID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataCentreID(String value) {
        this.dataCentreID = value;
    }

    /**
     * Gets the value of the contactPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contactPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContactPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContactPointType }
     * 
     * 
     */
    public List<ContactPointType> getContactPoint() {
        if (contactPoint == null) {
            contactPoint = new ArrayList<ContactPointType>();
        }
        return this.contactPoint;
    }

    /**
     * Gets the value of the dcInfoID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDcInfoID() {
        return dcInfoID;
    }

    /**
     * Sets the value of the dcInfoID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDcInfoID(String value) {
        this.dcInfoID = value;
    }

}
