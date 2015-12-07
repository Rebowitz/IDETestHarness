/**
 * 
 */
package org.imo.lrit.ide.test.util;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.log4j.Logger;

/**
 * @author llawrenc
 * 
 */
public class WSUtil {
    private static final Logger log = Logger.getLogger(WSUtil.class);

    /**
     * Get an attibute from the ServletContext from a web service managed class.
     * 
     * @param wsc
     *            the WebServiceContext injected into the web service managed
     *            class
     * @param name
     *            the name of the ServletContext attribute
     * @return the requested Attribute, or null if there is no such named
     *         attribute in the ServletContext.
     * @throws RuntimeException
     *             if either the WebServiceContext or the ServletContext are
     *             null.
     */
    @SuppressWarnings("unchecked")
    public static Object getServletContextAttribute(WebServiceContext wsc, String name) {
        if (wsc == null) {
            throw new RuntimeException("Web service context not injected.");
        }
        MessageContext msgContext = wsc.getMessageContext();
        ServletContext servletContext = (ServletContext) msgContext
                .get(MessageContext.SERVLET_CONTEXT);
        if (servletContext == null) {
            throw new RuntimeException("No servlet context!?");
        }
        return servletContext.getAttribute(name);
    }

    /**
     * Gets an attribute from the ServletRequest associated with the current
     * context.
     * 
     * @param wsContext
     *            the WebServiceContext
     * @param attrName
     *            the name of the attribute to return.
     * @return the Object associated with attrName, or null if there is none.
     */
    public static Object getRequestAttribute(WebServiceContext wsContext,
            String attrName) {
        MessageContext msgContext = wsContext.getMessageContext();
        ServletRequest req = (ServletRequest) msgContext
                .get(MessageContext.SERVLET_REQUEST);
        if (log.isDebugEnabled()) {
            log.debug("Request Attributes:");
            for (Enumeration e = req.getAttributeNames(); e.hasMoreElements();) {
                String name = (String)e.nextElement();
                log.debug("Attribute " + name + ", value: " + req.getAttribute(name));
            }
        }
        Object attr = req.getAttribute(attrName);
        log.debug(String.format("Attribute '%s', returning '%s'", attrName,
                                attr));
        return attr;
    }

    /**
     * Gets the servletPath init parameter from this web service's servlet init
     * params.
     * 
     * @param wsContext
     *            the WebServiceContext
     * @return the "servletPath" init param from this WebServiceContext's
     *         servlet.
     */
    public static String getServletPath(WebServiceContext wsContext) {

        MessageContext msgContext = wsContext.getMessageContext();
        ServletRequest req = (ServletRequest) msgContext
                .get(MessageContext.SERVLET_REQUEST);
        HttpServletRequest hsr = (HttpServletRequest) req;
        String servletPath = hsr.getServletPath();
        // strip off leading slash
        servletPath = servletPath.substring(1, servletPath.length());
        log.debug("getServletPath() returning " + servletPath);
        return servletPath;
    }

}
