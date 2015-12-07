/**
 * TestDataReadWrite.java
 *
 * Last Update $Id: TestDataReadWrite.java,v 1.11 2008-08-12 14:05:35 rba Exp $
 *
 * History:
 * $Log: TestDataReadWrite.java,v $
 * Revision 1.11  2008-08-12 14:05:35  rba
 * New class created to better organize code and to eliminate unneeded code being included in the mockdc war file
 *
 * Revision 1.10  2008-08-12 13:44:21  rba
 * Changes supporting an enhanced test.
 *
 * Revision 1.9  2008-07-30 14:10:33  rba
 * Continuted changes in support of the reconciliation process.
 *
 * Revision 1.8  2008-07-29 21:05:13  rba
 * Coding of the Receipt Message Reconciliation process.
 *
 * Revision 1.7  2008-07-29 20:18:05  rba
 * Selected the same class from a different set of files.
 *
 * Revision 1.6  2008-07-29 20:15:04  rba
 * Reworking of the parsing of the xml message received by the test DC
 *
 * Revision 1.5  2008-07-29 16:21:18  rba
 * Adding debug statements.
 *
 * Revision 1.4  2008-07-29 14:23:22  rba
 * Contains new methods to support reconciliation process.
 *
 * Revision 1.3  2008-07-22 21:52:39  rba
 * Completed coding of SPR test.
 *
 * Revision 1.2  2008-07-15 19:18:20  rba
 * Last set of modifications which actually resulted in the TestHarness working!
 *
 * Revision 1.1.1.1  2008-07-01 17:47:54  rba
 * Initial import of IDETestHarness
 *
 */

package org.imo.lrit.test.common;

import java.io.*;
//import java.lang.ClassLoader;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.log4j.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

//import org.imo.lrit.ide.testToIDE.ShipPositionReportType;


public class TestDataReadWrite{
    
    protected static final Logger log = Logger.getLogger(TestDataReadWrite.class.getName());

 
    
    public static Document readResultXML(File resultfileHandle) throws IOException{
   
    	Document xmlDoc = null;
    
    	log.debug("Entered readResultXML method");
    	    	
	    try{

	    	DocumentBuilderFactory docBF = DocumentBuilderFactory.newInstance();
	    	docBF.setNamespaceAware(true);
	    	DocumentBuilder dBuilder = docBF.newDocumentBuilder();

	    	xmlDoc = dBuilder.parse(resultfileHandle);
	
	    }catch (IOException io){
		    log.error( " " + io.getMessage());	    	
	    }catch (Throwable t){
	    	log.error( " " + t.getMessage());
	    }
		return xmlDoc;
    }
    
    
    
    public static String readTestXML (String fileString) throws IOException{ 
        

        StringBuffer sb= new StringBuffer();
        
        try{        
            Reader testInput = new FileReader(fileString);

            char[] b = new char[1024];
            int n;
            
            while((n = testInput.read(b)) > 0){
                sb.append(b, 0, n);
            }
        }catch(IOException e){
            log.fatal("UNABLE TO READ TESTXML FILE-" + fileString + e);
        }
       
        return sb.toString();
    }
    
    public static void writeXMLFile (String xmlFileName, String xmlDirectoryName, 
            String xmlString) throws IOException{

        String xmlFileDir = xmlDirectoryName + xmlFileName;
        try{
            FileWriter rfw = new FileWriter(xmlFileDir);
            rfw.write(xmlString);
            rfw.flush();
            rfw.close();
        }
        catch ( IOException e ){
            log.fatal("UNABLE TO WRITE TESTXML FILE-" + xmlFileName + e);
        }

    }
   
    
    public static String writeReceivedXML (JAXBContext pContext,Object pObject,String pFileName)
                throws JAXBException,IOException {
        try{
        FileWriter fw = new FileWriter(pFileName);
        
        Marshaller marshaller = pContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.marshal(pObject, fw);
        
        fw.close();
        }
        catch(IOException e){
            log.fatal("UNABLE TO WRITE RECEIVED XML -" + pFileName + e);           
        }
        return ("File " + pFileName + "saved");
    }
  
    
 }
