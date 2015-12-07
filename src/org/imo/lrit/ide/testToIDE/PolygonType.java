
package org.imo.lrit.ide.testToIDE;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  A list of geographic positions (at least three) forming a closed polygon. Coordinates are expressed in longitude followed by latitude, in decimal degrees to two decimal places. The last set of coordinates should exactly match the first, although this cannot be enforced by the schema. 
 * 
 * <p>Java class for polygonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="polygonType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Caption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PosList" type="{http://gisis.imo.org/XML/LRIT/types/2008}polygonPosListType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="areaID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "polygonType", namespace = "http://gisis.imo.org/XML/LRIT/types/2008", propOrder = {
    "caption",
    "posList"
})
public class PolygonType {

    @XmlElement(name = "Caption")
    protected String caption;
    @XmlElement(name = "PosList", required = true)
    protected String posList;
    @XmlAttribute(required = true)
    protected String areaID;

    /**
     * Gets the value of the caption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaption() {
        return caption;
    }

    /**
     * Sets the value of the caption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaption(String value) {
        this.caption = value;
    }

    /**
     * Gets the value of the posList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosList() {
        return posList;
    }

    /**
     * Sets the value of the posList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosList(String value) {
        this.posList = value;
    }

    /**
     * Gets the value of the areaID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaID() {
        return areaID;
    }

    /**
     * Sets the value of the areaID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaID(String value) {
        this.areaID = value;
    }

}
