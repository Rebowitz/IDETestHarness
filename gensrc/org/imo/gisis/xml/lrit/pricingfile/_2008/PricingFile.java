//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-520 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.01.02 at 02:31:37 PM EST 
//


package org.imo.gisis.xml.lrit.pricingfile._2008;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
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
 *         &lt;element name="PriceList" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="dataProviderID" type="{http://gisis.imo.org/XML/LRIT/pricingFile/2008}lritIDTypeList"/>
 *                   &lt;element name="BreakDown" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Poll" type="{http://gisis.imo.org/XML/LRIT/types/2008}priceValueType"/>
 *                             &lt;element name="PeriodicRateChange" type="{http://gisis.imo.org/XML/LRIT/types/2008}priceValueType"/>
 *                             &lt;element name="PositionReport" type="{http://gisis.imo.org/XML/LRIT/types/2008}priceValueType"/>
 *                             &lt;element name="ArchivePositionReport" type="{http://gisis.imo.org/XML/LRIT/types/2008}priceValueType"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="currency" type="{http://gisis.imo.org/XML/LRIT/types/2008}currencyType" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="dataCentreID" use="required" type="{http://gisis.imo.org/XML/LRIT/types/2008}lritIDType" />
 *                 &lt;attribute name="issueDate" type="{http://www.w3.org/2001/XMLSchema}date" />
 *                 &lt;attribute name="effectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
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
    "priceList"
})
@XmlRootElement(name = "PricingFile")
public class PricingFile {

    @XmlElement(name = "PriceList", required = true)
    protected List<PricingFile.PriceList> priceList;
    @XmlAttribute(required = true)
    protected BigDecimal schemaVersion;

    /**
     * Gets the value of the priceList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the priceList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPriceList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PricingFile.PriceList }
     * 
     * 
     */
    public List<PricingFile.PriceList> getPriceList() {
        if (priceList == null) {
            priceList = new ArrayList<PricingFile.PriceList>();
        }
        return this.priceList;
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
     *         &lt;element name="dataProviderID" type="{http://gisis.imo.org/XML/LRIT/pricingFile/2008}lritIDTypeList"/>
     *         &lt;element name="BreakDown" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Poll" type="{http://gisis.imo.org/XML/LRIT/types/2008}priceValueType"/>
     *                   &lt;element name="PeriodicRateChange" type="{http://gisis.imo.org/XML/LRIT/types/2008}priceValueType"/>
     *                   &lt;element name="PositionReport" type="{http://gisis.imo.org/XML/LRIT/types/2008}priceValueType"/>
     *                   &lt;element name="ArchivePositionReport" type="{http://gisis.imo.org/XML/LRIT/types/2008}priceValueType"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="currency" type="{http://gisis.imo.org/XML/LRIT/types/2008}currencyType" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="dataCentreID" use="required" type="{http://gisis.imo.org/XML/LRIT/types/2008}lritIDType" />
     *       &lt;attribute name="issueDate" type="{http://www.w3.org/2001/XMLSchema}date" />
     *       &lt;attribute name="effectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "dataProviderID",
        "breakDown"
    })
    public static class PriceList {

        @XmlList
        @XmlElement(required = true)
        protected List<String> dataProviderID;
        @XmlElement(name = "BreakDown", required = true)
        protected List<PricingFile.PriceList.BreakDown> breakDown;
        @XmlAttribute(required = true)
        protected String dataCentreID;
        @XmlAttribute
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar issueDate;
        @XmlAttribute
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar effectiveDate;

        /**
         * Gets the value of the dataProviderID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the dataProviderID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDataProviderID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getDataProviderID() {
            if (dataProviderID == null) {
                dataProviderID = new ArrayList<String>();
            }
            return this.dataProviderID;
        }

        /**
         * Gets the value of the breakDown property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the breakDown property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBreakDown().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PricingFile.PriceList.BreakDown }
         * 
         * 
         */
        public List<PricingFile.PriceList.BreakDown> getBreakDown() {
            if (breakDown == null) {
                breakDown = new ArrayList<PricingFile.PriceList.BreakDown>();
            }
            return this.breakDown;
        }

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
         * Gets the value of the issueDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getIssueDate() {
            return issueDate;
        }

        /**
         * Sets the value of the issueDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setIssueDate(XMLGregorianCalendar value) {
            this.issueDate = value;
        }

        /**
         * Gets the value of the effectiveDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEffectiveDate() {
            return effectiveDate;
        }

        /**
         * Sets the value of the effectiveDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEffectiveDate(XMLGregorianCalendar value) {
            this.effectiveDate = value;
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
         *         &lt;element name="Poll" type="{http://gisis.imo.org/XML/LRIT/types/2008}priceValueType"/>
         *         &lt;element name="PeriodicRateChange" type="{http://gisis.imo.org/XML/LRIT/types/2008}priceValueType"/>
         *         &lt;element name="PositionReport" type="{http://gisis.imo.org/XML/LRIT/types/2008}priceValueType"/>
         *         &lt;element name="ArchivePositionReport" type="{http://gisis.imo.org/XML/LRIT/types/2008}priceValueType"/>
         *       &lt;/sequence>
         *       &lt;attribute name="currency" type="{http://gisis.imo.org/XML/LRIT/types/2008}currencyType" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "poll",
            "periodicRateChange",
            "positionReport",
            "archivePositionReport"
        })
        public static class BreakDown {

            @XmlElement(name = "Poll")
            protected float poll;
            @XmlElement(name = "PeriodicRateChange")
            protected float periodicRateChange;
            @XmlElement(name = "PositionReport")
            protected float positionReport;
            @XmlElement(name = "ArchivePositionReport")
            protected float archivePositionReport;
            @XmlAttribute
            protected String currency;

            /**
             * Gets the value of the poll property.
             * 
             */
            public float getPoll() {
                return poll;
            }

            /**
             * Sets the value of the poll property.
             * 
             */
            public void setPoll(float value) {
                this.poll = value;
            }

            /**
             * Gets the value of the periodicRateChange property.
             * 
             */
            public float getPeriodicRateChange() {
                return periodicRateChange;
            }

            /**
             * Sets the value of the periodicRateChange property.
             * 
             */
            public void setPeriodicRateChange(float value) {
                this.periodicRateChange = value;
            }

            /**
             * Gets the value of the positionReport property.
             * 
             */
            public float getPositionReport() {
                return positionReport;
            }

            /**
             * Sets the value of the positionReport property.
             * 
             */
            public void setPositionReport(float value) {
                this.positionReport = value;
            }

            /**
             * Gets the value of the archivePositionReport property.
             * 
             */
            public float getArchivePositionReport() {
                return archivePositionReport;
            }

            /**
             * Sets the value of the archivePositionReport property.
             * 
             */
            public void setArchivePositionReport(float value) {
                this.archivePositionReport = value;
            }

            /**
             * Gets the value of the currency property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCurrency() {
                return currency;
            }

            /**
             * Sets the value of the currency property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCurrency(String value) {
                this.currency = value;
            }

        }

    }

}
