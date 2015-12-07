/**
 * DDPBean.java
 *
 * Last Update $Id: DDPBean.java,v 1.2 2008-08-12 13:38:22 rba Exp $
 *
 * History:
 * $Log: DDPBean.java,v $
 * Revision 1.2  2008-08-12 13:38:22  rba
 * Importing changes made to the standalone mockdc into this framework
 *
 * Revision 1.7  2008-07-18 18:00:58  lgl
 * Modified to use the new full DDP update type (3).
 *
 * Revision 1.6  2008-06-11 17:44:34  msr
 * Formatted and cleaned warnings
 *
 * Revision 1.5  2008-05-05 22:21:33  lgl
 * Many little changes.
 *
 * Revision 1.4  2008-05-05 19:36:49  lgl
 * Fixed bug in DDP notification message.
 *
 * Revision 1.3  2008-05-05 19:31:39  lgl
 * Changes required due to schema changes from LRIT AdHoc 3.
 *
 * Revision 1.2  2008-04-23 21:19:06  lgl
 * Fixed so that sending of a DDP Update actually works.
 *
 * Revision 1.1  2008-04-19 00:38:17  lgl
 * Many changes - still in state of flux.
 *
 */
package org.imo.lrit.ide.test.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.math.BigInteger;
import java.net.URL;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.imo.lrit.ide.test.context.TesterContext;
import org.imo.lrit.ide.test.util.JSFUtil;
import org.imo.lrit.ide.test.util.MsgUtil;

import org.apache.log4j.Logger;
import org.imo.gisis.xml.lrit._2008.IdeDDPPortType;
import org.imo.gisis.xml.lrit.ddpnotification._2008.DDPNotificationType;
import org.imo.gisis.xml.lrit.ddpupdate._2008.DDPUpdateType;
import org.imo.lrit.common.util.XMLHelper;

/**
 * Bean behind the ddp.jsp page. This should be a session bean so that its xml
 * and methods can be called from other jsps.
 */

@SuppressWarnings("unused")
public class DDPBean {

    private String xml;
    /**
     * A String array where the elements are defined as follows:
     * <pre>
     * [0] - the complete new version number of form n:m
     * [1] - the new regular version number of form n
     * [2] - the new immediate version number of form m
     * </pre>
     */
    private String[] newDDPVersion;
    private static TesterContext testCtxRef;
    private static Logger log = Logger.getLogger(DDPBean.class);

    /**
     * Gets the value of xml
     * 
     * @return the xml
     */
    public String getXml() {
        return xml;
    }

    /**
     * Sets the value of xml
     * 
     * @param xml
     *            the xml to set
     */
    public void setXml(String xml) {
        this.xml = xml;
    }

    public String sendDDPNotification() {
        String notification = createDDPNotification();
        String result = MsgUtil.sendDDPTypeXMLToIDE(notification);
        log.info("sendDDPNotification() returning " + result);
        return result;
    }

    public String sendDDPUpdate() {
        DDPUpdateType update = createDDPUpdate();
        if (update == null) {
            // FacesMessage will already be set
            return "fail";
        }
        try {
            URL wsdlURL = new URL(getTesterContext().getIdeDdpUrl() + "?wsdl");
            Service ideddpService = Service
                    .create(wsdlURL, new QName(XMLHelper.IDE_DDP_SERVICE_NS,
                                               XMLHelper.IDE_DDP_SERVICE_NAME));
            IdeDDPPortType port = (IdeDDPPortType) ideddpService
                    .getPort(new QName(XMLHelper.IDE_DDP_SERVICE_NS,
                                       XMLHelper.IDE_DDP_PORT_NAME),
                             IdeDDPPortType.class);
            SOAPBinding binding = (SOAPBinding) ((BindingProvider) port)
                    .getBinding();
            binding.setMTOMEnabled(true);
            port.ddpUpdate(update);
        } catch (Exception e) {
            FacesContext.getCurrentInstance()
                    .addMessage(
                                null,
                                new FacesMessage("Error sending DDP Update: "
                                        + e.getMessage()));
            return "fail";
        }
        getTesterContext().bumpSentCount(10);
        return "success";
    }

    private DDPUpdateType createDDPUpdate() {
        DDPUpdateType update = new DDPUpdateType();
        update.setMessageType(new BigInteger("10"));
        update.setMessageId(MsgUtil.createMsgId(getTesterContext()));
        update.setUpdateType(new BigInteger("3")); // full update
        update.setMessage("Here is the update!!");
        update.setTimeStamp(XMLHelper.calToXMLCal(new GregorianCalendar(TimeZone
                .getTimeZone("UTC"))));
        update.setDDPFileVersionNum(newDDPVersion[0]);
        File zipFile;
        try {
            zipFile = File.createTempFile("ddp_" + newDDPVersion, ".zip");
            log.debug("Creating zip output file to " + zipFile);
            ZipOutputStream zos = new ZipOutputStream(
                                                      new FileOutputStream(
                                                                           zipFile));
            zos.putNextEntry(new ZipEntry("DDP.zip"));
            byte[] xmlBytes = xml.getBytes();
            zos.write(xmlBytes, 0, xmlBytes.length);
            zos.closeEntry();
            zos.close();
        } catch (Exception e1) {
            log.error("Error writing zip file: ", e1);
            FacesContext.getCurrentInstance()
                    .addMessage(
                                null,
                                new FacesMessage(
                                                 "Error creating DDP zip file: "
                                                         + e1.getMessage()));
            return null;
        }

        update.setDDPFile(new DataHandler(new FileDataSource(zipFile)));
        update.setTest(new BigInteger("0"));
        return update;
    }

    public String createDDPNotification() {
        DDPNotificationType ddpnotify = new DDPNotificationType();
        String[] newVersion = bumpRegularDDPVersion(getTesterContext().getDdpVersion());
        ddpnotify.setMessageType(new BigInteger("8"));
        ddpnotify.setMessageId(MsgUtil.createMsgId(getTesterContext()));
        ddpnotify.setUpdateType(new BigInteger("0")); // regular update
        ddpnotify.setMessage("DDP version " + newVersion[1]
                + " now ready for pickup!");
        ddpnotify.setTimeStamp(XMLHelper
                .calToXMLCal(new GregorianCalendar(TimeZone.getTimeZone("UTC"))));
        ddpnotify.setVersionNum(newVersion[1]);
        ddpnotify.setTest(new BigInteger("0"));
        try {
            return MsgUtil.TypeToString(DDPNotificationType.class, ddpnotify,
                                        XMLHelper.DDP_NOTIFICATION_NS,
                                        XMLHelper.DDP_NOTIFICATION_LOCAL_NAME);
        } catch (Exception e) {
            throw new RuntimeException("JAXB Exception: ", e);
        }
    }

    private TesterContext getTesterContext() {
        if (testCtxRef == null) {
            log.debug("PosrepBean getting new TesterContext");
            testCtxRef = (TesterContext) JSFUtil
                    .getManagedBean("TesterContext");
        }
        return testCtxRef;
    }

    /**
     * Resets this bean for generation of a new DDP version.
     * 
     * @return null if there was no problem, else "fail". In the case where
     *         "fail" is returned, an FacesMessage will have been set.
     */
    public String newDDP() {
        ServletContext sc = JSFUtil.getServletContext();
        String filename = sc.getRealPath("/WEB-INF/xml/DDP.xml");
        StringBuffer sb = new StringBuffer();
        newDDPVersion = bumpRegularDDPVersion(getTesterContext().getDdpVersion());

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String ln = reader.readLine();
            while (ln != null) {
                if (ln.indexOf("@") != -1) {
                    String baseUrl = getWebAppURL();
                    ln = ln.replaceAll("@DDPVERSION@", newDDPVersion[0]);
                    // DataCentre replacements
                    ln = ln.replaceAll("@DC1_LRIT_ID@", getTesterContext()
                            .getDc1LritId());
                    ln = ln.replaceAll("@DC1_URL@", getTesterContext().getDc1Url());
                    ln = ln.replaceAll("@DC2_LRIT_ID@", getTesterContext().getDestDuLritId());
                    ln = ln.replaceAll("@DC2_URL@", getTesterContext().getDc2Url());
                    // DDP server replacements
                    ln = ln.replaceAll("@DDP_URL@", getTesterContext().getDdpUrl());
                    // IDE replacements
                    ln = ln.replaceAll("@IDE_DDP_URL@", getTesterContext().getIdeDdpUrl());
                    ln = ln.replaceAll("@IDE_DC_URL@", getTesterContext().getIdeUrl());
                    // DataUser replacements
                    ln = ln.replaceAll("@DU1_LRIT_ID@", getTesterContext()
                            .getDc1DuLritId());
                    ln = ln.replaceAll("@DU2_LRIT_ID@", "0550");
                }
                sb.append(ln + "\n");
                ln = reader.readLine();
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance()
                    .addMessage(
                                null,
                                new FacesMessage("Error reading DDP xml file: "
                                        + e.getMessage()));
            return "fail";
        }
        xml = sb.toString();
        return null;
    }

    /**
     * Gets the next major DDP version based upon the current version in the
     * DataCentreContext.
     * 
     * @return a String array where the elements are defined as follows:
     * <pre>
     * [0] - the complete new version number of form n:m
     * [1] - the new regular version number of form n
     * [2] - the new immediate version number of form m
     * </pre>
     */
    private String[] bumpRegularDDPVersion(String currVersion) {
        String[] ret = new String[3];
        int colonIdx = currVersion.indexOf(":");
        String regVer = currVersion.substring(0, colonIdx);
        ret[2] = currVersion.substring(colonIdx+1);
        int majorVersion = Integer.parseInt(regVer);
        majorVersion++;
        ret[1] = Integer.toString(majorVersion);
        ret[0] = ret[1] + ":" + ret[2];
        return ret;
    }

    private String getWebAppURL() {
        HttpServletRequest req = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        return String.format("%s://%s:%d%s", req.getScheme(), req
                .getServerName(), req.getServerPort(), req.getContextPath());

    }
}
