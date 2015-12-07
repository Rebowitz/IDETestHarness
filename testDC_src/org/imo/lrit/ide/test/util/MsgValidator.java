/**
 * 
 */
package org.imo.lrit.ide.test.util;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.log4j.Logger;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sun.xml.ws.util.ByteArrayBuffer;

/**
 * @author llawrenc
 * 
 */
public class MsgValidator {

    private static final Map<String, MsgValidator> validators;
    private static final Logger log = Logger.getLogger(MsgValidator.class);
    static {
        validators = new HashMap<String, MsgValidator>();
    }

    public static MsgValidator getMsgValidator(WebServiceContext wsContext,
            String wsdlPath) {
        if (!validators.containsKey(wsdlPath)) {
            MsgValidator val = new MsgValidator(wsContext, wsdlPath);
            validators.put(wsdlPath, val);
        }
        return validators.get(wsdlPath);
    }

    // Save Schema with object rather than Validator since Schema is thread
    // safe and Validator is not.
    final Schema schema;

    /**
     * Creates new validator for the specified web service context based upon
     * the specified WSDL.
     * 
     * @param wsdlPath
     *            The ServletContext relative path to the WSDL (ex.
     *            "WEB-INF/etc/ide.wsdl".
     */
    private MsgValidator(WebServiceContext wsContext, String wsdlPath) {
        if (wsContext == null) {
            throw new RuntimeException("Web service context not injected.");
        }
        MessageContext msgContext = wsContext.getMessageContext();
        ServletContext servletContext = (ServletContext) msgContext
                .get(MessageContext.SERVLET_CONTEXT);
        if (servletContext == null) {
            throw new RuntimeException("No servlet context!?");
        }
        URL wsdlURL = null;
        try {
            wsdlURL = servletContext.getResource(wsdlPath);
        } catch (MalformedURLException e1) {
            throw new RuntimeException("Unable to locate WSDL URL", e1);
        }
        InputStream wsdlStream = servletContext.getResourceAsStream(wsdlPath);

        // Build a Schema object using all of the schemas listed in the WSDL
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder docBuilder = dbf.newDocumentBuilder();
            Document wsdlDoc = docBuilder.newDocument();
            Transformer xformer = TransformerFactory.newInstance()
                    .newTransformer();
            xformer.transform(new StreamSource(wsdlStream),
                              new DOMResult(wsdlDoc));
            NodeList schemaNodes = wsdlDoc
                    .getElementsByTagNameNS(XMLConstants.W3C_XML_SCHEMA_NS_URI,
                                            "schema");
            // debugNodeList(schemaNodes, "Schema Nodes: ");
            int nSchemas = schemaNodes.getLength();
            Source[] schemas = new Source[nSchemas];
            Document schemaDoc;
            Element schemaElement;
            for (int i = 0; i < nSchemas; i++) {
                schemaDoc = docBuilder.newDocument();
                NamedNodeMap nsDecs = getNamespaces(schemaNodes.item(i));
                schemaElement = (Element) schemaDoc.importNode(schemaNodes
                        .item(i), true);
                for (int j = 0; j < nsDecs.getLength(); j++) {
                    Node n = schemaDoc.importNode(nsDecs.item(j), true);
                    // debugNode(n, "nsDecs " + j + ":");
                    Attr a = (Attr) n;
                    schemaElement.setAttributeNodeNS(a);
                }
                // debugElement(schemaElement, "Schema Element: ");
                schemaDoc.appendChild(schemaElement);
                schemas[i] = new DOMSource(schemaDoc, wsdlURL.toExternalForm());
            }
            SchemaFactory schemaFac = SchemaFactory
                    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            schema = schemaFac.newSchema(schemas);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        validators.put(wsdlPath, this);
    }

    public String validateErrs(SOAPMessage soapmsg) {
        try {
            return validateErrs(new DOMSource(soapmsg.getSOAPBody().getFirstChild()));
        } catch (SOAPException e) {
            return ("Invalid SOAP message format");
        }
    }

    public String validateErrs(Source source) {
        log.debug("validateErrs starting with source: " + source);
        Source useSource;
        try {
            if (!DOMSource.class.isInstance(source)
                    && !SAXSource.class.isInstance(source)) {
                DocumentBuilderFactory dbf = DocumentBuilderFactory
                        .newInstance();
                dbf.setNamespaceAware(true);
                Document docSource = dbf.newDocumentBuilder().newDocument();

                TransformerFactory.newInstance().newTransformer()
                        .transform(source, new DOMResult(docSource));
                useSource = new DOMSource(docSource);
            } else {
                useSource = source;
            }
            Validator validator = schema.newValidator();
            validator.validate(useSource);
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.debug("Got Exception while parsing: ");
                e.printStackTrace();
                log.debug("Stack trace end");
            }
            return "Parse error: " + rootCauseMsg(e);
        }
        return null;
    }

    private void debugAttributes(NamedNodeMap nnm, String label) {
        if (!log.isDebugEnabled()) {
            return;
        }
        if (nnm == null) {
            log.debug(label + "NamedNodeMap is null");
            return;
        }
        int nbr = nnm.getLength();
        log.debug(label + "Number of attributes: " + nbr);
        for (int i = 1; i <= nbr; i++) {
            Attr attr = (Attr) nnm.item(i - 1);
            log.debug(label + "  prefix: " + attr.getPrefix() + ", name: "
                    + attr.getName() + ", value: " + attr.getValue());
        }

    }

    private void debugDOM(DOMSource ds, String label) {
        if (!log.isDebugEnabled()) {
            return;
        }
        try {
            ByteArrayBuffer bos = new ByteArrayBuffer();
            StreamResult sr = new StreamResult(bos);
            Transformer trans = TransformerFactory.newInstance()
                    .newTransformer();
            trans.transform(ds, sr);
            log.debug(label + bos.toString());
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void debugElement(Element e, String label) {
        if (!log.isDebugEnabled()) {
            return;
        }
        if (e == null) {
            log.debug(label + "Element is null");
            return;
        }
        log.debug(label + "name: " + e.getNodeName());
        NamedNodeMap attrs = e.getAttributes();
        debugAttributes(attrs, label + "Attributes: ");
    }

    private void debugNode(Node n, String label) {
        if (!log.isDebugEnabled()) {
            return;
        }
        debugDOM(new DOMSource(n), label);
    }

    private void debugNodeList(NodeList nl, String label) {
        if (!log.isDebugEnabled()) {
            return;
        }
        int nbr = nl.getLength();
        log.debug(label + "Number of nodes: " + nbr);
        for (int i = 1; i <= nbr; i++) {
            debugDOM(new DOMSource(nl.item(i - 1)), label + "Node " + i + ": ");
        }

    }

    /**
     * Get the namespaces in effect for the scope of the passed Node.
     * 
     * @param e
     *            the node to process.
     * @return A NamedNodeMap of the namespaces in effect for the specified node
     *         if the node is type ELEMENT_NODE, else null.
     */
    private NamedNodeMap getNamespaces(Node e) {
        if (e.getNodeType() != Node.ELEMENT_NODE) {
            return null;
        }

        Node n = e.cloneNode(true);
        NamedNodeMap attrs = n.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            Attr attr = (Attr) attrs.item(i);
            String prefix = attr.getPrefix();
            String name = attr.getLocalName();
            if (prefix == null || !prefix.equals("xmlns")) {
                attrs.removeNamedItem(name);
            }
        }
        // debugAttributes(attrs, " getNamespaces Attributes: ");

        Node parent = e.getParentNode();
        if (parent != null) {
            NamedNodeMap parentAttrs = getNamespaces(parent);
            // debugAttributes(parentAttrs,
            // " getNamespaces Parent Attributes: ");
            if (parentAttrs != null) {
                // override parent namespace specifications with local ones
                // of the same name.
                for (int i = 0; i < attrs.getLength(); i++) {
                    parentAttrs.setNamedItem(attrs.item(i).cloneNode(true));
                }
                // debugAttributes(parentAttrs, " getNamespaces Returning: ");
                return parentAttrs;
            }
        }
        // debugAttributes(attrs, " getNamespaces Returning: ");
        return attrs;

    }

    private String rootCauseMsg(Throwable e) {
        Throwable cause;
        while ((cause = e.getCause()) != null) {
            e = cause;
        }
        return e.getMessage();
    }
}
