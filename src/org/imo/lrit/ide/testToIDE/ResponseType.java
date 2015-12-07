
package org.imo.lrit.ide.testToIDE;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for responseType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="responseType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Success"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "responseType", namespace = "http://gisis.imo.org/XML/LRIT/2008")
@XmlEnum
public enum ResponseType {

    @XmlEnumValue("Success")
    SUCCESS("Success");
    private final String value;

    ResponseType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResponseType fromValue(String v) {
        for (ResponseType c: ResponseType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
