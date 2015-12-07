
package org.imo.gisis.xml.lrit._2008;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.2_01-hudson-189-
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "ddpService", targetNamespace = "http://gisis.imo.org/XML/LRIT/2008", wsdlLocation = "file:/home/randrews/lrit_common/etc/DDP.wsdl")
public class DdpService
    extends Service
{

    private final static URL DDPSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(org.imo.gisis.xml.lrit._2008.DdpService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = org.imo.gisis.xml.lrit._2008.DdpService.class.getResource(".");
            url = new URL(baseUrl, "file:/home/randrews/lrit_common/etc/DDP.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/home/randrews/lrit_common/etc/DDP.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        DDPSERVICE_WSDL_LOCATION = url;
    }

    public DdpService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DdpService() {
        super(DDPSERVICE_WSDL_LOCATION, new QName("http://gisis.imo.org/XML/LRIT/2008", "ddpService"));
    }

    /**
     * 
     * @return
     *     returns DdpPortType
     */
    @WebEndpoint(name = "ddpPort")
    public DdpPortType getDdpPort() {
        return super.getPort(new QName("http://gisis.imo.org/XML/LRIT/2008", "ddpPort"), DdpPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DdpPortType
     */
    @WebEndpoint(name = "ddpPort")
    public DdpPortType getDdpPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://gisis.imo.org/XML/LRIT/2008", "ddpPort"), DdpPortType.class, features);
    }

}
