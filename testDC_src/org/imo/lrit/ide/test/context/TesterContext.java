/**
 * 
 */
package org.imo.lrit.ide.test.context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.imo.gisis.xml.lrit.positionreport._2008.ShipPositionReportType;

/**
 * This bean will be stored in the servlet context, and contain context-wide
 * data.
 * 
 * @author llawrenc
 * 
 */
public class TesterContext {

    private static final Logger log = Logger.getLogger(TesterContext.class);
    private static final String[] messageTypes = new String[] { "Unknown",
            "PositionReport(1)", "PositionReport(2)", "PositionReport(3)",
            "PositionRequest(4)", "PositionRequest(5)", "SURPIC(6)",
            "Receipt(7)", "DDPNotification(8)", "DDPRequest(9)",
            "DDPUpdate(10)", "SystemStatus(11)", "JournalReport(12)",
            "PricingNotification(13)", "PricingRequest(14)",
            "PricingUpdate(15)" };
    private static final Map<String, Integer> rcvIndex;
    private static final int sendIdx;
    private String dc1DuLritId = "1001";
    private String dc1LritId = "3001";
    private String dc1Url;
    private String dc2Url;
    private String ddpLritId = "0001";
    private String ddpUrl;
    private String ddpVersion = "1:0";
    private String destDuLritId = "1000";
    private String ideDdpUrl = "http://localhost:8080/ide/ideddp";
    private String ideLritId = "0002";
    private String ideUrl = "http://localhost:8080/ide/idedc";

    /**
     * first index: message type second index: 0 = #sent, 1 = #received
     */
    private int[][] intCounts;
    private int msgIdSuffix = 0;
    private int nbrPosrepsRcvd = 0;
    private int nbrPosrepsSent = 0;
    private int nbrReceiptsRcvd = 0;
    private List<RcvdMsg> rcvdMsgs = new ArrayList<RcvdMsg>();

    private LinkedList<ShipPositionReportType> rcvdPosreps = new LinkedList<ShipPositionReportType>();

    static {
        rcvIndex = new HashMap<String, Integer>();
        rcvIndex.put("ddp", new Integer(0));
        rcvIndex.put("dc1", new Integer(1));
        rcvIndex.put("dc2", new Integer(2));
        rcvIndex.put("other", new Integer(3));
        sendIdx = 4;
    }

    public TesterContext() {
        log.debug("In Constructor");
        clear();
    }

    public synchronized void addRcvdMsg(RcvdMsg msg) {
        this.rcvdMsgs.add(msg);
    }

    /**
     * Add a received postion report to the list.
     * 
     * @param posrep
     *            a received position report.
     */
    public void addRcvdPosrep(ShipPositionReportType posrep) {
        synchronized (rcvdPosreps) {
            rcvdPosreps.addFirst(posrep);
        }
    }

    public void bumpRcvCount(int messageType, String servletPath) {
        if (messageType < 1 || messageType >= messageTypes.length) {
            // bump the unknown count
            messageType = 0;
        }
        Integer idx = rcvIndex.get(servletPath);
        if (idx == null) {
            idx = rcvIndex.get("other");
        }
        intCounts[messageType][idx]++;
        // log.debug(this + " Receive count for message type " + messageType + "
        // now "
        // + intCounts[messageType][1]);
    }

    public void bumpSentCount(int messageType) {
        if (messageType < 1 || messageType >= messageTypes.length) {
            // bump the unknown count
            messageType = 0;
        }
        intCounts[messageType][sendIdx]++;
        // log.debug(this + " Sent count for message type " + messageType + "
        // now "
        // + intCounts[messageType][0]);
    }

    public synchronized void clear() {
        log.debug("Clearing counts and messages");
        rcvdMsgs = new ArrayList<RcvdMsg>();
        intCounts = new int[messageTypes.length][5];
    }

    public List<Counts> getCounts() {
        log.debug(this + " - In getCounts()");
        List<Counts> ret = new ArrayList<Counts>();
        // Add all real types first
        for (int i = 1; i < messageTypes.length; i++) {
            ret.add(new Counts(messageTypes[i], intCounts[i][sendIdx],
                               intCounts[i][rcvIndex.get("ddp")],
                               intCounts[i][rcvIndex.get("dc1")],
                               intCounts[i][rcvIndex.get("dc2")],
                               intCounts[i][rcvIndex.get("other")]));
        }
        // Add the Unknown count to the end
        ret.add(new Counts(messageTypes[0], intCounts[0][sendIdx],
                           intCounts[0][rcvIndex.get("ddp")],
                           intCounts[0][rcvIndex.get("dc1")],
                           intCounts[0][rcvIndex.get("dc2")],
                           intCounts[0][rcvIndex.get("other")]));
        return ret;
    }

    /**
     * @return the dc1DuLritId
     */
    public String getDc1DuLritId() {
        return dc1DuLritId;
    }

    /**
     * @return the dcLritId
     */
    public String getDc1LritId() {
        return dc1LritId;
    }

    /**
     * Gets the value of dc1Url
     * 
     * @return the dc1Url
     */
    public String getDc1Url() {
        if (dc1Url == null) {
            String baseUrl = getWebAppURL();
            dc1Url = baseUrl + "/dc1";
        }
        return dc1Url;
    }

    /**
     * Gets the value of dc2Url
     * 
     * @return the dc2Url
     */
    public String getDc2Url() {
        if (dc2Url == null) {
            String baseUrl = getWebAppURL();
            dc2Url = baseUrl + "/dc2";
        }
        return dc2Url;
    }

    /**
     * Gets the value of ddpLritId
     * 
     * @return the ddpLritId
     */
    public String getDdpLritId() {
        return ddpLritId;
    }

    /**
     * Gets the value of ddpUrl
     * 
     * @return the ddpUrl
     */
    public String getDdpUrl() {
        if (ddpUrl == null) {
            String baseUrl = getWebAppURL();
            ddpUrl = baseUrl + "/ddp";
        }
        return ddpUrl;
    }

    /**
     * @return the ddpVersion
     */
    public String getDdpVersion() {
        return ddpVersion;
    }

    /**
     * @return the destDuLritId
     */
    public String getDestDuLritId() {
        return destDuLritId;
    }

    /**
     * Gets the value of ideDdpUrl
     * 
     * @return the ideDdpUrl
     */
    public String getIdeDdpUrl() {
        return ideDdpUrl;
    }

    /**
     * Gets the value of ideLritId
     * 
     * @return the ideLritId
     */
    public String getIdeLritId() {
        return ideLritId;
    }

    /**
     * @return the ideUrl
     */
    public String getIdeUrl() {
        return ideUrl;
    }

    /**
     * @return the msgIdSuffix
     */
    public int getMsgIdSuffix() {
        msgIdSuffix = (msgIdSuffix + 1) % 100000;
        log.debug("returning msg suffix: " + msgIdSuffix);
        return msgIdSuffix;
    }

    /**
     * @return the nbrPosrepsRcvd
     */
    public int getNbrPosrepsRcvd() {
        return nbrPosrepsRcvd;
    }

    /**
     * Get the current count of position reports sent.
     * 
     * @return the nbrPosrepsSent
     */
    public int getNbrPosrepsSent() {
        return nbrPosrepsSent;
    }

    public int getNbrReceiptsRcvd() {
        return nbrReceiptsRcvd;
    }

    /**
     * Gets a list of received messages.
     * 
     * @return A list of received messages. This is a copy of the actual list so
     *         that changes to the actual list will not be reflected in the
     *         returned list, and the iterator may be used without fear of
     *         ConcurrentModificationException.
     * 
     */
    public synchronized List<RcvdMsg> getRcvdMsgs() {
        List<RcvdMsg> ret = new ArrayList<RcvdMsg>();
        Collections.copy(rcvdMsgs, ret);
        return rcvdMsgs;
    }

    /**
     * Get a list of received position reports, order most recent first.
     * 
     * @return A list of received position reports. This is a copy of the actual
     *         list so that changes to the actual list will not be reflected in
     *         the returned list, and the iterator may be used without fear of
     *         ConcurrentModificationException.
     */
    public List<ShipPositionReportType> getRcvdPosreps() {
        synchronized (rcvdPosreps) {
            LinkedList<ShipPositionReportType> ret = new LinkedList<ShipPositionReportType>();
            Collections.copy(rcvdPosreps, ret);
            return ret;
        }
    }

    /**
     * Increment the counter of postition reports received.
     * 
     * @return the new value
     */
    public synchronized int incNbrPosrepsRcvd() {
        nbrPosrepsRcvd++;
        return nbrPosrepsRcvd;
    }

    /**
     * Increment the counter of postition reports sent.
     * 
     * @return the new value
     */
    public synchronized int incNbrPosrepsSent() {
        nbrPosrepsSent++;
        return nbrPosrepsSent;
    }

    /**
     * Increment the counter of postition reports received.
     * 
     * @return the new value
     */
    public synchronized int incNbrReceiptsRcvd() {
        nbrPosrepsRcvd++;
        return nbrPosrepsRcvd;
    }

    /**
     * @param dc1DuLritId
     *            the dc1DuLritId to set
     */
    public void setDc1DuLritId(String cgLritId) {
        this.dc1DuLritId = cgLritId;
    }

    /**
     * @param dcLritId
     *            the dcLritId to set
     */
    public void setDc1LritId(String lritId) {
        this.dc1LritId = lritId;
    }

    /**
     * Sets the value of ddpLritId
     * 
     * @param ddpLritId
     *            the ddpLritId to set
     */
    public void setDdpLritId(String ddpLritId) {
        this.ddpLritId = ddpLritId;
    }

    /**
     * @param ddpVersion
     *            the ddpVersion to set
     */
    public void setDdpVersion(String ddpVersion) {
        this.ddpVersion = ddpVersion;
    }

    /**
     * @param destDuLritId
     *            the destDuLritId to set
     */
    public void setDestDuLritId(String destLritId) {
        this.destDuLritId = destLritId;
    }

    /**
     * Sets the value of ideDdpUrl
     * 
     * @param ideDdpUrl
     *            the ideDdpUrl to set
     */
    public void setIdeDdpUrl(String ideDdpUrl) {
        this.ideDdpUrl = ideDdpUrl;
    }

    /**
     * Sets the value of ideLritId
     * 
     * @param ideLritId
     *            the ideLritId to set
     */
    public void setIdeLritId(String ideLritId) {
        this.ideLritId = ideLritId;
    }

    /**
     * @param ideUrl
     *            the ideUrl to set
     */
    public void setIdeUrl(String ideUrl) {
        this.ideUrl = ideUrl;
    }

    private String getWebAppURL() {
        HttpServletRequest req = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        return String.format("%s://%s:%d%s", req.getScheme(), req
                .getServerName(), req.getServerPort(), req.getContextPath());

    }

}
