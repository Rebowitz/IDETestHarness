//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-520 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.01.02 at 02:31:37 PM EST 
//


package org.imo.gisis.xml.lrit.ddp._2008;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContractingGovernment" type="{http://gisis.imo.org/XML/LRIT/ddp/2008}contractingGovernmentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Territory" type="{http://gisis.imo.org/XML/LRIT/ddp/2008}territoryType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CoastalStateStandingOrders">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="StandingOrder" type="{http://gisis.imo.org/XML/LRIT/ddp/2008}coastalStateStandingOrderType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Exclusions">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Exclusion" type="{http://gisis.imo.org/XML/LRIT/ddp/2008}exclusionType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DataCentres">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DataCentre" type="{http://gisis.imo.org/XML/LRIT/ddp/2008}dataCentreType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ASPs">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ASP" type="{http://gisis.imo.org/XML/LRIT/ddp/2008}aspType" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DDPServer" type="{http://gisis.imo.org/XML/LRIT/ddp/2008}ddpServerType"/>
 *         &lt;element name="IDE" type="{http://gisis.imo.org/XML/LRIT/ddp/2008}ideType"/>
 *         &lt;element name="LRITCoordinator" type="{http://gisis.imo.org/XML/LRIT/ddp/2008}lritCoordinatorType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="versionNum" use="required" type="{http://gisis.imo.org/XML/LRIT/types/2008}ddpVersionNumType" />
 *       &lt;attribute name="regularVersionPublishedAt" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="regularVersionImplementationAt" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="immediateVersionPublishedAt" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="immediateVersionImplementationAt" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="schemaVersion" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "contractingGovernment",
    "territory",
    "coastalStateStandingOrders",
    "exclusions",
    "dataCentres",
    "asPs",
    "ddpServer",
    "ide",
    "lritCoordinator"
})
@XmlRootElement(name = "DataDistributionPlan")
public class DataDistributionPlan {

    @XmlElement(name = "ContractingGovernment")
    protected List<ContractingGovernmentType> contractingGovernment;
    @XmlElement(name = "Territory")
    protected List<TerritoryType> territory;
    @XmlElement(name = "CoastalStateStandingOrders", required = true)
    protected DataDistributionPlan.CoastalStateStandingOrders coastalStateStandingOrders;
    @XmlElement(name = "Exclusions", required = true)
    protected DataDistributionPlan.Exclusions exclusions;
    @XmlElement(name = "DataCentres", required = true)
    protected DataDistributionPlan.DataCentres dataCentres;
    @XmlElement(name = "ASPs", required = true)
    protected DataDistributionPlan.ASPs asPs;
    @XmlElement(name = "DDPServer", required = true)
    protected DdpServerType ddpServer;
    @XmlElement(name = "IDE", required = true)
    protected IdeType ide;
    @XmlElement(name = "LRITCoordinator", required = true)
    protected LritCoordinatorType lritCoordinator;
    @XmlAttribute(required = true)
    protected String versionNum;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar regularVersionPublishedAt;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar regularVersionImplementationAt;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar immediateVersionPublishedAt;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar immediateVersionImplementationAt;
    @XmlAttribute(required = true)
    protected BigDecimal schemaVersion;

    /**
     * Gets the value of the contractingGovernment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contractingGovernment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContractingGovernment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContractingGovernmentType }
     * 
     * 
     */
    public List<ContractingGovernmentType> getContractingGovernment() {
        if (contractingGovernment == null) {
            contractingGovernment = new ArrayList<ContractingGovernmentType>();
        }
        return this.contractingGovernment;
    }

    /**
     * Gets the value of the territory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the territory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTerritory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TerritoryType }
     * 
     * 
     */
    public List<TerritoryType> getTerritory() {
        if (territory == null) {
            territory = new ArrayList<TerritoryType>();
        }
        return this.territory;
    }

    /**
     * Gets the value of the coastalStateStandingOrders property.
     * 
     * @return
     *     possible object is
     *     {@link DataDistributionPlan.CoastalStateStandingOrders }
     *     
     */
    public DataDistributionPlan.CoastalStateStandingOrders getCoastalStateStandingOrders() {
        return coastalStateStandingOrders;
    }

    /**
     * Sets the value of the coastalStateStandingOrders property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataDistributionPlan.CoastalStateStandingOrders }
     *     
     */
    public void setCoastalStateStandingOrders(DataDistributionPlan.CoastalStateStandingOrders value) {
        this.coastalStateStandingOrders = value;
    }

    /**
     * Gets the value of the exclusions property.
     * 
     * @return
     *     possible object is
     *     {@link DataDistributionPlan.Exclusions }
     *     
     */
    public DataDistributionPlan.Exclusions getExclusions() {
        return exclusions;
    }

    /**
     * Sets the value of the exclusions property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataDistributionPlan.Exclusions }
     *     
     */
    public void setExclusions(DataDistributionPlan.Exclusions value) {
        this.exclusions = value;
    }

    /**
     * Gets the value of the dataCentres property.
     * 
     * @return
     *     possible object is
     *     {@link DataDistributionPlan.DataCentres }
     *     
     */
    public DataDistributionPlan.DataCentres getDataCentres() {
        return dataCentres;
    }

    /**
     * Sets the value of the dataCentres property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataDistributionPlan.DataCentres }
     *     
     */
    public void setDataCentres(DataDistributionPlan.DataCentres value) {
        this.dataCentres = value;
    }

    /**
     * Gets the value of the asPs property.
     * 
     * @return
     *     possible object is
     *     {@link DataDistributionPlan.ASPs }
     *     
     */
    public DataDistributionPlan.ASPs getASPs() {
        return asPs;
    }

    /**
     * Sets the value of the asPs property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataDistributionPlan.ASPs }
     *     
     */
    public void setASPs(DataDistributionPlan.ASPs value) {
        this.asPs = value;
    }

    /**
     * Gets the value of the ddpServer property.
     * 
     * @return
     *     possible object is
     *     {@link DdpServerType }
     *     
     */
    public DdpServerType getDDPServer() {
        return ddpServer;
    }

    /**
     * Sets the value of the ddpServer property.
     * 
     * @param value
     *     allowed object is
     *     {@link DdpServerType }
     *     
     */
    public void setDDPServer(DdpServerType value) {
        this.ddpServer = value;
    }

    /**
     * Gets the value of the ide property.
     * 
     * @return
     *     possible object is
     *     {@link IdeType }
     *     
     */
    public IdeType getIDE() {
        return ide;
    }

    /**
     * Sets the value of the ide property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdeType }
     *     
     */
    public void setIDE(IdeType value) {
        this.ide = value;
    }

    /**
     * Gets the value of the lritCoordinator property.
     * 
     * @return
     *     possible object is
     *     {@link LritCoordinatorType }
     *     
     */
    public LritCoordinatorType getLRITCoordinator() {
        return lritCoordinator;
    }

    /**
     * Sets the value of the lritCoordinator property.
     * 
     * @param value
     *     allowed object is
     *     {@link LritCoordinatorType }
     *     
     */
    public void setLRITCoordinator(LritCoordinatorType value) {
        this.lritCoordinator = value;
    }

    /**
     * Gets the value of the versionNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersionNum() {
        return versionNum;
    }

    /**
     * Sets the value of the versionNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersionNum(String value) {
        this.versionNum = value;
    }

    /**
     * Gets the value of the regularVersionPublishedAt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRegularVersionPublishedAt() {
        return regularVersionPublishedAt;
    }

    /**
     * Sets the value of the regularVersionPublishedAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRegularVersionPublishedAt(XMLGregorianCalendar value) {
        this.regularVersionPublishedAt = value;
    }

    /**
     * Gets the value of the regularVersionImplementationAt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRegularVersionImplementationAt() {
        return regularVersionImplementationAt;
    }

    /**
     * Sets the value of the regularVersionImplementationAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRegularVersionImplementationAt(XMLGregorianCalendar value) {
        this.regularVersionImplementationAt = value;
    }

    /**
     * Gets the value of the immediateVersionPublishedAt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getImmediateVersionPublishedAt() {
        return immediateVersionPublishedAt;
    }

    /**
     * Sets the value of the immediateVersionPublishedAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setImmediateVersionPublishedAt(XMLGregorianCalendar value) {
        this.immediateVersionPublishedAt = value;
    }

    /**
     * Gets the value of the immediateVersionImplementationAt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getImmediateVersionImplementationAt() {
        return immediateVersionImplementationAt;
    }

    /**
     * Sets the value of the immediateVersionImplementationAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setImmediateVersionImplementationAt(XMLGregorianCalendar value) {
        this.immediateVersionImplementationAt = value;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ASP" type="{http://gisis.imo.org/XML/LRIT/ddp/2008}aspType" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "asp"
    })
    public static class ASPs {

        @XmlElement(name = "ASP")
        protected List<AspType> asp;

        /**
         * Gets the value of the asp property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the asp property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getASP().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AspType }
         * 
         * 
         */
        public List<AspType> getASP() {
            if (asp == null) {
                asp = new ArrayList<AspType>();
            }
            return this.asp;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="StandingOrder" type="{http://gisis.imo.org/XML/LRIT/ddp/2008}coastalStateStandingOrderType" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "standingOrder"
    })
    public static class CoastalStateStandingOrders {

        @XmlElement(name = "StandingOrder")
        protected List<CoastalStateStandingOrderType> standingOrder;

        /**
         * Gets the value of the standingOrder property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the standingOrder property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStandingOrder().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CoastalStateStandingOrderType }
         * 
         * 
         */
        public List<CoastalStateStandingOrderType> getStandingOrder() {
            if (standingOrder == null) {
                standingOrder = new ArrayList<CoastalStateStandingOrderType>();
            }
            return this.standingOrder;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DataCentre" type="{http://gisis.imo.org/XML/LRIT/ddp/2008}dataCentreType" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "dataCentre"
    })
    public static class DataCentres {

        @XmlElement(name = "DataCentre")
        protected List<DataCentreType> dataCentre;

        /**
         * Gets the value of the dataCentre property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dataCentre property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDataCentre().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DataCentreType }
         * 
         * 
         */
        public List<DataCentreType> getDataCentre() {
            if (dataCentre == null) {
                dataCentre = new ArrayList<DataCentreType>();
            }
            return this.dataCentre;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Exclusion" type="{http://gisis.imo.org/XML/LRIT/ddp/2008}exclusionType" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "exclusion"
    })
    public static class Exclusions {

        @XmlElement(name = "Exclusion")
        protected List<ExclusionType> exclusion;

        /**
         * Gets the value of the exclusion property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the exclusion property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getExclusion().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExclusionType }
         * 
         * 
         */
        public List<ExclusionType> getExclusion() {
            if (exclusion == null) {
                exclusion = new ArrayList<ExclusionType>();
            }
            return this.exclusion;
        }

    }

}
