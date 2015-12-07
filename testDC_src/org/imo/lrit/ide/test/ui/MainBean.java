package org.imo.lrit.ide.test.ui;

import org.imo.lrit.ide.test.context.TesterContext;
import org.imo.lrit.ide.test.util.JSFUtil;

import org.apache.log4j.Logger;

public class MainBean {
    private static final Logger log = Logger.getLogger(MainBean.class);
    private static TesterContext testerCtxRef = null;

    public String clearCounts() {
        getTesterCtx().clear();
        return "refresh";
    }


    private TesterContext getTesterCtx() {
        if (testerCtxRef == null) {
            testerCtxRef = (TesterContext) JSFUtil
                    .getManagedBean("TesterContext");
        }
        return testerCtxRef;
    }

    public String sendDDPNotification() {
        DDPBean ddpbean = JSFUtil.getManagedBean("DDPBean");
        String notification = ddpbean.createDDPNotification();
        SendmsgBean sender = JSFUtil.getManagedBean("SendmsgBean");
        sender.configure("DDP Notification:", notification, "DDP");
        return "sendddpnotification";
    }

    public String sendDDPUpdate() {
        DDPBean ddpbean = JSFUtil.getManagedBean("DDPBean");
        String status = ddpbean.newDDP();
        if (status != null) {
            return "fail";
        }
        return "sendddpupdate";
    }

    public String sendPositionRequest() {
        log.debug("In MainBean.sendPositionRequest()");
        PosreqBean bean = new PosreqBean();
        String xml = bean.createXml();
        SendmsgBean sender = JSFUtil.getManagedBean("SendmsgBean");
        sender.configure("Position Request Message:", xml, "DC");
        log.debug("returning MainBean.sendPositionRequest()");
        return "sendmsg";
    }

    public String sendPricingRequest() {
        PricingBean bean = new PricingBean();
        String xml = bean.createPricingRequest();
        SendmsgBean sender = JSFUtil.getManagedBean("SendmsgBean");
        sender.configure("Pricing Request:", xml, "DC");
        return "sendmsg";
    }
    
    public String sendPricingUpdate() {
        log.debug("***** In MAIN.sendPricingUpdate method *****");
        PricingBean bean = JSFUtil.getManagedBean("PricingBean");
        String status = bean.createPricingUpdate();
        if (status != null) {
            log.debug("***** MAIN.sendPricingUpdate(): status != null returning fail *****");
            return "fail";
        }
        log.debug("***** MAIN.sendPricingUpdate(): returning sendpricingupdate *****");
        return "sendpricingupdate";
    }
    
    /**
     * Sends a Receipt message from the DC to the send DU.
     * @return "success" or "fail"
     */
    public String sendReceiptFromDCToDU() {
        log.debug("In MainBean.sendReceipt()");
        ReceiptBean bean = new ReceiptBean();
        String xml = bean.createXml("DC", "DU");
        SendmsgBean sender = JSFUtil.getManagedBean("SendmsgBean");
        sender.configure("SAR SURPIC Message:", xml, "DC");
        log.debug("returning MainBean.sendReceipt()");
        return "sendmsg";
    }

    /**
     * Sends a Receipt message from the DC to the IDE.
     * @return "success" or "fail"
     */
    public String sendReceiptFromDCToIDE() {
        log.debug("In MainBean.sendReceipt()");
        ReceiptBean bean = new ReceiptBean();
        String xml = bean.createXml("DC", "IDE");
        SendmsgBean sender = JSFUtil.getManagedBean("SendmsgBean");
        sender.configure("SAR SURPIC Message:", xml, "DC");
        log.debug("returning MainBean.sendReceipt()");
        return "sendmsg";
    }

    /**
     * Sends a Receipt message from the DDP server to the IDE.
     * @return "success" or "fail"
     */
    public String sendReceiptFromDDPToIDE() {
        log.debug("In MainBean.sendReceipt()");
        ReceiptBean bean = new ReceiptBean();
        String xml = bean.createXml("DDP", "IDE");
        SendmsgBean sender = JSFUtil.getManagedBean("SendmsgBean");
        sender.configure("SAR SURPIC Message:", xml, "DDP");
        log.debug("returning MainBean.sendReceipt()");
        return "sendmsg";
    }
    
    public String sendSarSurpic() {
        log.debug("In MainBean.sendSarSurpic()");
        SarSurpicBean bean = new SarSurpicBean();
        String xml = bean.createXml();
        SendmsgBean sender = JSFUtil.getManagedBean("SendmsgBean");
        sender.configure("SAR SURPIC Message:", xml, "DC");
        log.debug("returning MainBean.sendSarSurpic()");
        return "sendmsg";
    }

    /**
     * Sends a SystemStatus message from the DC
     * @return  "success" or "fail"
     */
    public String sendSystemStatusFromDC() {
        log.debug("In MainBean.sendSystemStatus()");
        SystemStatusBean bean = new SystemStatusBean();
        String xml = bean.createXml("DC");
        SendmsgBean sender = JSFUtil.getManagedBean("SendmsgBean");
        sender.configure("Position Request Message:", xml, "DC");
        log.debug("returning MainBean.sendSystemStatus()");
        return "sendmsg";
    }
    
    /**
     * Sends a SystemStatus message from the DDP Server
     * 
     * @return "success" or "fail"
     */
    public String sendSystemStatusFromDDP() {
        log.debug("In MainBean.sendSystemStatus()");
        SystemStatusBean bean = new SystemStatusBean();
        String xml = bean.createXml("DDP");
        SendmsgBean sender = JSFUtil.getManagedBean("SendmsgBean");
        sender.configure("Position Request Message:", xml, "DDP");
        log.debug("returning MainBean.sendSystemStatus()");
        return "sendmsg";
    }
    
}
