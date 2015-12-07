package org.imo.lrit.ide.test.ui;

import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.imo.lrit.ide.test.context.TesterContext;
import org.imo.lrit.ide.test.util.JSFUtil;
import org.imo.lrit.ide.test.util.MsgUtil;

import org.apache.log4j.Logger;
import org.imo.gisis.xml.lrit.systemstatus._2008.SystemStatusType;
import org.imo.lrit.common.util.XMLHelper;

public class SystemStatusBean {
    private static TesterContext testerCtx = null;
    private static Logger log = Logger.getLogger(PosreqBean.class);

    public String createXml(String sender) {
        TesterContext ctx = getTesterCtx();
        SystemStatusType type = new SystemStatusType();
        type.setDDPVersionNum(ctx.getDdpVersion());
        type.setMessage("System Normal");
        type.setMessageId(MsgUtil.createMsgId(ctx));
        type.setMessageType(new BigInteger("11"));
        if (sender.equals("DC")) {
            type.setOriginator(ctx.getDc1LritId());
        } else if (sender.equals("DDP")) {
            type.setOriginator(ctx.getDdpLritId());
        } else {
            throw new RuntimeException("Invalid sender: '" + sender
                    + "', must be DC or DDP");
        }
        type.setSystemStatus(new BigInteger("0"));
        type.setTest(new BigInteger("0"));
        type.setTimeStamp(XMLHelper.calToXMLCal(new GregorianCalendar(TimeZone
                .getTimeZone("UTC"))));

        try {
            return MsgUtil.TypeToString(SystemStatusType.class, type,
                                        XMLHelper.SYSTEM_STATUS_NS,
                                        XMLHelper.SYSTEM_STATUS_LOCAL_NAME);
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
