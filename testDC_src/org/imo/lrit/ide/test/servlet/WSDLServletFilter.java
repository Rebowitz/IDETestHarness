/**
 * WSDLServletFilter.java
 *
 * Last Update $Id: WSDLServletFilter.java,v 1.1 2008-07-14 21:55:07 rba Exp $
 *
 * History:
 * $Log: WSDLServletFilter.java,v $
 * Revision 1.1  2008-07-14 21:55:07  rba
 * Making the testDC as mockiest of the mockDC as possible.
 *
 * Revision 1.2  2008-04-30 19:59:12  swk
 * Cleaned up warnings
 *
 * Revision 1.1  2008-04-23 21:18:10  lgl
 * Initial checkin.
 *
 */
package org.imo.lrit.ide.test.servlet;

import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.log4j.Logger;

/**
 * This class is a Servlet Filter whose purpose is to replace the soap12:address
 * element in any WSDL being returned by it's associated Servlet with the
 * original requestURL, and to be able to have each request associated with the
 * correct servletPath. Without this filter, the JAX-WS framework creates only a
 * single WSDL per service/port type. In that WSDL, the &lt;soap12:address&gt;
 * element location will always be the last defined for this type of port in the
 * sun-jaxws.xml file. When a client wants to send to the server, using any of
 * the mapped url-patterns, it first pulls the WSDL from the server. The client
 * then uses the &lt;soap12:address&gt; from the WSDL to actually send the
 * request. Because the WSDL returned always contains the address associated
 * with the last mapped entry in un-jaxws.xml, teh actual requests to any mapped
 * url associated with the port type all are sent to the server using the
 * address in the WSDL, not the original address, and the server cannot
 * determine what the original URL was that the client was trying to access.
 * <p>
 * This filter makes it possible to configure more than one url path to the same
 * WS port type, enabling the server to determine what the url the client
 * actually sent to by querying the request.getServletPath().
 * <p>
 * Following is an example of this filter's use in a web.xml file:
 * 
 * <pre>
 *    &lt;filter&gt;
 *        &lt;filter-name&gt;WSDL Filter&lt;/filter-name&gt;
 *        &lt;filter-class&gt;mil.uscg.lrit.mockdc.servlet.WSDLServletFilter&lt;/filter-class&gt;
 *    &lt;/filter&gt;
 *    &lt;filter-mapping&gt;
 *        &lt;filter-name&gt;WSDL Filter&lt;/filter-name&gt;
 *        &lt;servlet-name&gt;dcService&lt;/servlet-name&gt;
 *    &lt;/filter-mapping&gt;
 *    &lt;servlet&gt;
 *        &lt;servlet-name&gt;dcService&lt;/servlet-name&gt;
 *        &lt;servlet-class&gt;com.sun.xml.ws.transport.http.servlet.WSServlet&lt;/servlet-class&gt;
 *        &lt;load-on-startup&gt;1&lt;/load-on-startup&gt;
 *    &lt;/servlet&gt;
 *    &lt;servlet-mapping&gt;
 *        &lt;servlet-name&gt;dcService&lt;/servlet-name&gt;
 *        &lt;url-pattern&gt;/dc1/*&lt;/url-pattern&gt;
 *    &lt;/servlet-mapping&gt;
 *    &lt;servlet-mapping&gt;
 *        &lt;servlet-name&gt;dcService&lt;/servlet-name&gt;
 *        &lt;url-pattern&gt;/dc2/*&lt;/url-pattern&gt;
 *    &lt;/servlet-mapping&gt;
 * </pre>
 * 
 * Both of these URLs must also be mapped in sun-jaxws.xml as follows:
 * 
 * <pre>
 *    &lt;endpoint
 *        name=&quot;dc&quot;
 *        interface=&quot;org.imo.gisis.xml.lrit._2008.DcPortType&quot;
 *        implementation=&quot;mil.uscg.lrit.mockdc.ws.DcPortProvider&quot;
 *        wsdl=&quot;WEB-INF/wsdl/DC.wsdl&quot;
 *        binding=&quot;http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/&quot;
 *        service=&quot;{http://gisis.imo.org/XML/LRIT/2008}dcService&quot;
 *        port=&quot;{http://gisis.imo.org/XML/LRIT/2008}dcPort&quot;
 *        url-pattern=&quot;/dc1&quot; /&gt;
 *    &lt;endpoint
 *        name=&quot;dc&quot;
 *        interface=&quot;org.imo.gisis.xml.lrit._2008.DcPortType&quot;
 *        implementation=&quot;mil.uscg.lrit.mockdc.ws.DcPortProvider&quot;
 *        wsdl=&quot;WEB-INF/wsdl/DC.wsdl&quot;
 *        binding=&quot;http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/&quot;
 *        service=&quot;{http://gisis.imo.org/XML/LRIT/2008}dcService&quot;
 *        port=&quot;{http://gisis.imo.org/XML/LRIT/2008}dcPort&quot;
 *        url-pattern=&quot;/dc2&quot; /&gt;
 * </pre>
 * 
 * Within the Service Endpoint Implementation, to figure out which url was
 * addressed, do the following:
 * 
 * <pre>
 * MessageContext msgContext = wsContext.getMessageContext();
 * ServletRequest req = (ServletRequest) msgContext
 *         .get(MessageContext.SERVLET_REQUEST);
 * HttpServletRequest hsr = (HttpServletRequest) req;
 * String servletPath = hsr.getServletPath();
 * </pre>
 * 
 * With the above mappings, servletPath will be either '/dc1' or 'dc2'.
 */
public class WSDLServletFilter implements Filter {

    class FilterOutputStream extends ServletOutputStream {
        private ByteArrayOutputStream baos;

        public FilterOutputStream() {
            baos = new ByteArrayOutputStream();
        }

        @Override
        public String toString() {
            return baos.toString();
        }

        @Override
        public void write(byte[] b) throws IOException {
            baos.write(b);
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            baos.write(b, off, len);
        }

        @Override
        public void write(int b) throws IOException {
            baos.write(b);
        }

    }

    class ServletResponseWrapper extends HttpServletResponseWrapper {
        boolean gotWriter;
        private FilterOutputStream outputStream;
        private CharArrayWriter outputWriter;

        public ServletResponseWrapper(HttpServletResponse resp) {
            super(resp);
            outputWriter = new CharArrayWriter();
            outputStream = new FilterOutputStream();
        }

        @Override
        public ServletOutputStream getOutputStream() {
            log.debug("getOutputStream() starting");
            gotWriter = false;
            return outputStream;
        }

        public String getStringResponse() throws IOException {
            if (gotWriter) {
                outputWriter.flush();
                return outputWriter.toString();
            } else {
                outputStream.flush();
                return outputStream.toString();
            }
        }

        @Override
        public PrintWriter getWriter() {
            log.debug("getWriter() starting");
            gotWriter = true;
            return new PrintWriter(outputWriter);
        }

        @Override
        public String toString() {
            return outputWriter.toString();
        }
    }

    private static final Logger log = Logger.getLogger(WSDLServletFilter.class);

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
        // noop
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpreq = (HttpServletRequest) req;
        String queryString = httpreq.getQueryString();
        String requestURL = httpreq.getRequestURL().toString();
        String servletPath = httpreq.getServletPath();
        log.debug("Request URL: " + requestURL + ", Query String: "
                + queryString + ", Servlet Path: " + servletPath);
        if (queryString != null && queryString.compareToIgnoreCase("wsdl") == 0) {
            log.debug("Filtering wsdl response");
            PrintWriter out = resp.getWriter();
            ServletResponseWrapper wrapper = new ServletResponseWrapper(
                                                                        (HttpServletResponse) resp);
            chain.doFilter(req, wrapper);
            log.debug("back from chain - response contentType: "
                    + resp.getContentType());
            CharArrayWriter caw = new CharArrayWriter();
            String respString = wrapper.getStringResponse();
            // log.debug("Response before conversion: " + respString);
            if (respString.contains("</soap12:address>")) {
                caw.write(wrapper.getStringResponse()
                        .replaceAll(
                                    "<soap12:address.*soap12:address>",
                                    "<soap12:address location=\"" + requestURL
                                            + "\"/>"));
            } else {
                caw.write(wrapper.getStringResponse()
                        .replaceAll(
                                    "<soap12:address[^>]+>",
                                    "<soap12:address location=\"" + requestURL
                                            + "\"/>"));
            }
            // log.debug("Response is: " + caw.toString());
            resp.setContentLength(caw.toString().length());
            resp.setContentType("application/soap+xml");
            out.write(caw.toString());
            out.close();
        } else {
            log.debug("Not doing any filtering");
            chain.doFilter(req, resp);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig arg0) throws ServletException {
        // noop
    }

}
