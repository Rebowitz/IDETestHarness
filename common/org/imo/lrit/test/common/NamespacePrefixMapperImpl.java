package org.imo.lrit.test.common;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;


public class NamespacePrefixMapperImpl extends NamespacePrefixMapper{

    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix){
        
        //W3c to show a prefix of "xsi"
        if("http://www.w3.org/2001/XMLSchema-instance".equals(namespaceUri))
            return "xs";
        
        if("http://gisis.imo.org/XML/LRIT/types/2008".equals(namespaceUri))
            return "lrit";
        
        if("http://gisis.imo.org/XML/LRIT/positionReport/2008".equals(namespaceUri))
            return "";
        
        return suggestion;
    }
    
}
