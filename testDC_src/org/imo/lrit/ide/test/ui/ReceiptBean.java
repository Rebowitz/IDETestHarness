package org.imo.lrit.ide.test.ui;

import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.imo.lrit.ide.test.context.TesterContext;
import org.imo.lrit.ide.test.util.JSFUtil;
import org.imo.lrit.ide.test.util.MsgUtil;

import org.apache.log4j.Logger;
import org.imo.gisis.xml.lrit.receipt._2008.ReceiptType;
import org.imo.lrit.common.util.XMLHelper;

public class ReceiptBean {
    private static TesterContext testerCtx = null;
    private static Logger log = Logger.getLogger(ReceiptBean.class);

    /**
     * Create a new Receipt message
     * 
     * @param sender
     *            either "DC", or "DDP".
     * @param dest
     *            either "DU", or "IDE".
     * @return XML for a Receipt message from the specified sender and dest.
     * @throws RuntimeException
     *             if sender is invalid.
     */
    public String createXml(String sender, String dest) {
        TesterContext ctx = getTesterCtx();
        ReceiptType type = new ReceiptType();
        type.setDDPVersionNum(ctx.getDdpVersion());
        if (dest.equals("DU")) {
            type.setDestination(ctx.getDestDuLritId());
        } else if (dest.equals("IDE")) {
            type.setDestination(ctx.getIdeLritId());
        } else {
            throw new RuntimeException("Invalid dest: '" + dest
                    + "', must be DU or IDE");
        }
        type.setMessage("System Normal");
        type.setMessageId(MsgUtil.createMsgId(ctx));
        type.setMessageType(new BigInteger("7"));
        if (sender.equals("DC")) {
            type.setOriginator(ctx.getDc1LritId());
        } else if (sender.equals("DDP")) {
            type.setOriginator(ctx.getDdpLritId());
        } else {
            throw new RuntimeException("Invalid sender: '" + sender
                    + "', must be DC or DDP");
        }
        type.setReceiptCode(7);
        type.setReferenceId(MsgUtil.createMsgId(ctx));
        type.setTest(new BigInteger("0"));
        type.setTimeStamp(XMLHelper.calToXMLCal(new GregorianCalendar(TimeZone
                .getTimeZone("UTC"))));

        try {
            return MsgUtil.TypeToString(ReceiptType.class, type,
                                        XMLHelper.RECEIPT_NS,
                                        XMLHelper.RECEIPT_LOCAL_NAME);
        } catch (Exception e) {
            throw new RuntimeException("JAXB Exception: ", e);
        }
    }

    private TesterContext getTesterCtx() {
        if (testerCtx == null) {
            log.debug("PosreqBean getting new TesterContext");
            testerCtx = (TesterContext) JSFUtil.getManagedBean("TesterContext");
        }
        return testerCtx;
    }
}
