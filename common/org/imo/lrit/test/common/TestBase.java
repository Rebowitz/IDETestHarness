/**
 * TestBase.java
 *
 * Last Update $Id: TestBase.java,v 1.1.1.1 2008-07-01 17:47:54 rba Exp $
 *
 * History:
 * $Log: TestBase.java,v $
 * Revision 1.1.1.1  2008-07-01 17:47:54  rba
 * Initial import of IDETestHarness
 *
 */
package org.imo.lrit.test.common;

/**
 * 
 */
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
//import java.io.IOException;
import java.util.Properties;

public class TestBase extends TestCase
//public class TestBase extends TestCase implements TestBaseInterface
{
    public static final Logger log = Logger.getLogger(TestBase.class.getName());
    public static Properties testProps = new Properties();
    
    public TestBase(String arg0)
    {
        super(arg0);
       
        log.debug("TestBase(arg0) called");
        log.debug("arg0 : " + arg0);
    } 
    
    protected void setUp() throws Exception{ 
       

        try {
            log.debug("***********Running setUp Method in TestBase");
            // create and load default properties

            FileInputStream baseProps = new FileInputStream(TestConstants.WEBSERVICES_TEST_CONFIG_FILE);

            testProps.load(baseProps);
            baseProps.close();            
           PropertyConfigurator.configure(testProps.getProperty("test.log4j.propertiesfile.location"));
            
        }   catch (Exception ex) {
            log.fatal("Exception loading program properties file: ",ex);
            ex.printStackTrace();
        }
        
    }
    public static String TestProperties(String propertyName){
        
        String propertyValue = testProps.getProperty(propertyName);
        return propertyValue;
    }
    
}
