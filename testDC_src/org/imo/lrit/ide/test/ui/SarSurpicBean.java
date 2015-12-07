package org.imo.lrit.ide.test.ui;

import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.imo.lrit.ide.test.context.TesterContext;
import org.imo.lrit.ide.test.util.JSFUtil;
import org.imo.lrit.ide.test.util.MsgUtil;

import org.apache.log4j.Logger;
import org.imo.gisis.xml.lrit.sarsurpicrequest._2008.SARSURPICType;
import org.imo.lrit.common.util.XMLHelper;

public class SarSurpicBean {
    private static TesterContext dccRef = null;
    private static Logger log = Logger.getLogger(PosreqBean.class);

    public String createXml() {
        SARSURPICType type = new SARSURPICType();
        type.setDataUserRequestor(getDcc().getDc1DuLritId());
        type.setDDPVersionNum(getDcc().getDdpVersion());
        type.setMessageId(MsgUtil.createMsgId(getDcc()));
        type.setMessageType(new BigInteger("6"));
        type.setNumberOfPositions(10);
        // type.setSARCircularArea("");
        type.setSARRectangularArea("47.37.N:052.40.W:00.15.N:001.30.E");
        type.setTest(new BigInteger("0"));
        type.setTimeStamp(XMLHelper.calToXMLCal(new GregorianCalendar(TimeZone
                .getTimeZone("UTC"))));
        try {
            return MsgUtil.TypeToString(SARSURPICType.class, type,
                                        XMLHelper.SAR_SURPIC_NS,
                                        XMLHelper.SAR_SURPIC_LOCAL_NAME);
        } catch (Exception e) {
            throw new RuntimeException("JAXB Exception: ", e);
        }
    }

    private TesterContext getDcc() {
        if (dccRef == null) {
            log.debug("PosreqBean getting new TesterContext");
            dccRef = (TesterContext) JSFUtil.getManagedBean("TesterContext");
        }
        return dccRef;
    }
}
