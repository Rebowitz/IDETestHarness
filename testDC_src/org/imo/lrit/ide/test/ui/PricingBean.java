package org.imo.lrit.ide.test.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.text.SimpleDateFormat;
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
import org.imo.gisis.xml.lrit._2008.IdePortType;
import org.imo.gisis.xml.lrit.pricingrequest._2008.PricingRequestType;
import org.imo.gisis.xml.lrit.pricingupdate._2008.PricingUpdateType;
import org.imo.lrit.common.util.XMLHelper;

/**
 * @author SWKoepp
 *
 */
@SuppressWarnings("unused")
public class PricingBean {
    private static Logger log = Logger.getLogger(PricingBean.class);
    private static TesterContext testCtxRef;
    private static TesterContext testerCtx = null;
    private String pricingFileXml;
    private String pricingUpdateXml;
    private String messageType = "15";
    private String messageId = MsgUtil.createMsgId(getTesterCtx());
    private String message = "pricing update message";
    private String ddpVersion = "1:0";
    private String test = "0";

    /**
     * @return the test
     */
    public String getTest() {
        return test;
    }

    /**
     * @param test the test to set
     */
    public void setTest(String test) {
        this.test = test;
    }

    public String createPricingRequest() {
        TesterContext ctx = getTesterCtx();
        PricingRequestType type = new PricingRequestType();
        type.setDDPVersionNum(ctx.getDdpVersion());
        type.setMessageId(MsgUtil.createMsgId(ctx));
        type.setMessageType(new BigInteger("14"));
        type.setOriginator(ctx.getDc1LritId());
        type.setTest(new BigInteger("0"));
        type.setTimeStamp(XMLHelper.calToXMLCal(new GregorianCalendar(TimeZone
                .getTimeZone("UTC"))));

        try {
            return MsgUtil.TypeToString(PricingRequestType.class, type,
                                        XMLHelper.PRICING_REQUEST_NS,
                                        XMLHelper.PRICING_REQUEST_LOCAL_NAME);
        } catch (Exception e) {
            throw new RuntimeException("JAXB Exception: ", e);
        }
    }

    public String createPricingUpdate() {
        ServletContext sc = JSFUtil.getServletContext();
        String filename = sc.getRealPath("/WEB-INF/xml/PricingFile.xml");
        StringBuffer sb = new StringBuffer();

        try {
            pricingFileXml = generatePricingFileXml();
        } catch (Exception e) {
            log.error("Unable to create pricing update xml");
            return "Unable to create pricing update xml";
        }
        return null;
    }

    private String generatePricingFileXml() {
        StringBuffer buff = new StringBuffer();

        buff.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        buff.append("<PricingFile \n");
        buff
                .append("\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" \n");
        buff
                .append("\txmlns=\"http://gisis.imo.org/XML/LRIT/pricing/2008\" \n");
        buff
                .append("\txsi:schemaLocation=\""
                        + "http://gisis.imo.org/XML/LRIT/pricing/2008 Pricing.xsd\">\n");

        buff.append("<PriceList dataCentreID=\""
                + getTesterContext().getDc1LritId() + "\" "
                + "issueDate=\"2008-05-01\" effectiveDate=\"2008-05-01\">\n");
        buff.append("\t<dataProviderID>"+ getTesterContext().getDc1DuLritId() 
                    + "</dataProviderID>\n");
        buff.append("\t<BreakDown currency=\"USD\">\n"
                + "\t\t<Poll>2.00</Poll>\n"
                + "\t\t<PeriodicRateChange>2.01</PeriodicRateChange>\n"
                + "\t\t<PositionReport>2.02</PositionReport>\n"
                + "\t\t<ArchivePositionReport>2.03</ArchivePositionReport>\n"
                + "\t</BreakDown>\n");
        buff.append("</PriceList>\n");

        buff.append("</PricingFile>\n");

        return buff.toString();
    }

    /*
     * public String createPricingUpdate() { PricingUpdateType type =
     * createPricingUpdateType();
     * 
     * try { return MsgUtil.TypeToString(PricingUpdateType.class, type,
     * XMLHelper.PRICING_UPDATE_NS, XMLHelper.PRICING_UPDATE_LOCAL_NAME); }
     * catch (Exception e) { throw new RuntimeException("JAXB Exception: ", e); } }
     */
    private PricingUpdateType generatePricingUpdateTypeXml() {
        TesterContext ctx = getTesterCtx();
        PricingUpdateType type = new PricingUpdateType();
        type.setDDPVersionNum(getDdpVersion());
        type.setMessage(getMessage());
        type.setMessageId(getMessageId());
        type.setMessageType(new BigInteger(getMessageType()));
        type.setTest(new BigInteger(getTest()));
        type.setTimeStamp(XMLHelper.calToXMLCal(new GregorianCalendar(TimeZone
                .getTimeZone("UTC"))));
        return type;
    }

    private DataHandler generateUpdateFile() {

        File zipFile;
        try {
            zipFile = File.createTempFile("MockDcPricingFile", ".zip");
            log.debug("Creating zip output file to " + zipFile);
            ZipOutputStream zos = new ZipOutputStream(
                new FileOutputStream(zipFile));
            zos.putNextEntry(new ZipEntry("PricingUpdate.zip"));
            zos.write(pricingFileXml.getBytes(), 0,
                      pricingFileXml.getBytes().length);
            zos.closeEntry();
            zos.close();
        } catch (Exception e1) {
            log.error("Error writing zip file: ", e1);
            FacesContext.getCurrentInstance().addMessage(
                null, new FacesMessage(
                    "Error creating Pricing Update zip file: "
                    + e1.getMessage()));
            return null;
        }

        return new DataHandler(new FileDataSource(zipFile));
    }

    /**
     * @return the pricingFileXml
     */
    public String getPricingFileXml() {
        return pricingFileXml;
    }

    /**
     * @return the pricingUpdateXml
     */
    public String getPricingUpdateXml() {
        return pricingUpdateXml;
    }

    private TesterContext getTesterContext() {
        if (testCtxRef == null) {
            log.debug("PosrepBean getting new TesterContext");
            testCtxRef = (TesterContext) JSFUtil
                    .getManagedBean("TesterContext");
        }
        return testCtxRef;
    }

    private TesterContext getTesterCtx() {
        if (testerCtx == null) {
            log.debug("PosreqBean getting new TesterContext");
            testerCtx = (TesterContext) JSFUtil.getManagedBean("TesterContext");
        }
        return testerCtx;
    }

    private String getWebAppURL() {
        HttpServletRequest req = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        return String.format("%s://%s:%d%s", req.getScheme(), req
                .getServerName(), req.getServerPort(), req.getContextPath());

    }

    public String sendPricingUpdate() {
        PricingUpdateType update = generatePricingUpdateTypeXml();
        if (update == null) {
            // FacesMessage will already be set
            return "fail";
        }
        // Add Update File
        update.setPricingFile(generateUpdateFile());

        try {
            URL wsdlURL = new URL(getTesterContext().getIdeUrl() + "?wsdl");
            Service ideDcService = Service
                    .create(wsdlURL, new QName(XMLHelper.IDE_SERVICE_NS,
                                               XMLHelper.IDE_SERVICE_NAME));
            IdePortType port = ideDcService
                    .getPort(new QName(XMLHelper.IDE_SERVICE_NS,
                                       XMLHelper.IDE_PORT_NAME),
                             IdePortType.class);
            SOAPBinding binding = (SOAPBinding) ((BindingProvider) port)
                    .getBinding();
            binding.setMTOMEnabled(true);
            port.pricingUpdate(update);
        } catch (Exception e) {
            FacesContext.getCurrentInstance()
                    .addMessage(
                                null,
                                new FacesMessage(
                                                 "Error sending Pricing Update: "
                                                         + e.getMessage()));
            return "fail";
        }
        getTesterContext().bumpSentCount(1);
        return "success";
    }

    /**
     * @param pricingFileXml
     *            the pricingFileXml to set
     */
    public void setPricingFileXml(String pricingFileXml) {
        this.pricingFileXml = pricingFileXml;
    }

    /**
     * @param pricingUpdateXml
     *            the pricingUpdateXml to set
     */
    public void setPricingUpdateXml(String pricingUpdateXml) {
        this.pricingUpdateXml = pricingUpdateXml;
    }

    /**
     * @return the messageType
     */
    public String getMessageType() {
        return messageType;
    }

    /**
     * @param messageType the messageType to set
     */
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    /**
     * @return the messageId
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * @param messageId the messageId to set
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the ddpVersion
     */
    public String getDdpVersion() {
        return ddpVersion;
    }

    /**
     * @param ddpVersion the ddpVersion to set
     */
    public void setDdpVersion(String ddpVersion) {
        this.ddpVersion = ddpVersion;
    }

}
