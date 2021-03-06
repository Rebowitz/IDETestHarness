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
 * <p>Java class for aspInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="aspInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ASPID" type="{http://gisis.imo.org/XML/LRIT/types/2008}aspLRITIDType"/>
 *         &lt;element name="Conditions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContactPoint" type="{http://gisis.imo.org/XML/LRIT/ddp/2008}contactPointType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="aspInfoID" use="required" type="{http://gisis.imo.org/XML/LRIT/ddp/2008}aspInfoIDType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aspInfoType", propOrder = {
    "aspid",
    "conditions",
    "contactPoint"
})
public class AspInfoType {

    @XmlElement(name = "ASPID", required = true)
    protected String aspid;
    @XmlElement(name = "Conditions")
    protected String conditions;
    @XmlElement(name = "ContactPoint")
    protected List<ContactPointType> contactPoint;
    @XmlAttribute(required = true)
    protected String aspInfoID;

    /**
     * Gets the value of the aspid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getASPID() {
        return aspid;
    }

    /**
     * Sets the value of the aspid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setASPID(String value) {
        this.aspid = value;
    }

    /**
     * Gets the value of the conditions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConditions() {
        return conditions;
    }

    /**
     * Sets the value of the conditions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConditions(String value) {
        this.conditions = value;
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
     * Gets the value of the aspInfoID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAspInfoID() {
        return aspInfoID;
    }

    /**
     * Sets the value of the aspInfoID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAspInfoID(String value) {
        this.aspInfoID = value;
    }

}
