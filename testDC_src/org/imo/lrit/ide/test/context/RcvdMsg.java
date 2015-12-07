package org.imo.lrit.ide.test.context;

import java.util.Date;

public class RcvdMsg {

    private String receivedBy;
    private Date rcvDate;
    private int msgType;
    private String msgId;
    private String xml;
    
    public String getStringMsgType() {
        StringBuffer sb = new StringBuffer();
        if (msgType == 1 || msgType == 2 || msgType == 3) {
            sb.append("PosRep");
        } else if (msgType == 4 || msgType == 5) {
            sb.append("PosReq");
        } else if (msgType == 6) {
            sb.append("SAR SURPIC");
        } else if (msgType == 7) {
            sb.append("Receipt");
        } else if (msgType == 8) {
            sb.append("DDP Notification");
        } else if (msgType == 9) {
            sb.append("DDP Request");
        } else if (msgType == 10) {
            sb.append("DDP Update");
        } else if (msgType == 11) {
            sb.append("SysStat");
        } else if (msgType == 12) {
            sb.append("Journal");
        } else if (msgType == 13) {
            sb.append("Pricing Notif.");
        } else if (msgType == 14) {
            sb.append("Pricing Req.");
        } else if (msgType == 15) {
            sb.append("Pricing Update");
        }
        sb.append("(").append(msgType).append(")");
        return sb.toString();
    }
    
    public RcvdMsg(String receivedBy,
            Date rcvDate, 
            int msgType,
            String msgId,
            String xml) {
        this.receivedBy = receivedBy;
        this.rcvDate = rcvDate;
        this.msgType = msgType;
        this.msgId = msgId;
        this.xml = xml;
    }

    /**
     * @return the receivedBy
     */
    public String getReceivedBy() {
        return receivedBy;
    }

    /**
     * @return the rcvDate
     */
    public Date getRcvDate() {
        return rcvDate;
    }

    /**
     * @return the msgType
     */
    public int getMsgType() {
        return msgType;
    }

    /**
     * @return the msgId
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * @return the xml
     */
    public String getXml() {
        return xml;
    }
    
    
}