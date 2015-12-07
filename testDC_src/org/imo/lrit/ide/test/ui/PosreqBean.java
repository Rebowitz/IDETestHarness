package org.imo.lrit.ide.test.ui;

import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.imo.lrit.ide.test.context.TesterContext;
import org.imo.lrit.ide.test.util.JSFUtil;
import org.imo.lrit.ide.test.util.MsgUtil;

import org.apache.log4j.Logger;
import org.imo.gisis.xml.lrit.positionrequest._2008.ShipPositionRequestType;
import org.imo.lrit.common.util.XMLHelper;

public class PosreqBean {

    private static TesterContext dccRef = null;
    private static Logger log = Logger.getLogger(PosreqBean.class);

    public String createXml() {
        ShipPositionRequestType type = new ShipPositionRequestType();
        type.setAccessType(new BigInteger("1"));
        type.setDataUserProvider(getDcc().getDestDuLritId());
        type.setDataUserRequestor(getDcc().getDc1DuLritId());
        type.setDDPVersionNum(getDcc().getDdpVersion());
        // type.setDistance(value);
        type.setIMONum("0000035");
        type.setMessageId(MsgUtil.createMsgId(getDcc()));
        type.setMessageType(new BigInteger("4"));
        // type.setPlace(value);
        // type.setPort(value);
        // type.setPortFacility(value);
        // RequestDurationType duration = new RequestDurationType();
        // duration.setStartTime(value);
        // duration.setStopTime(value);
        // type.setRequestDuration(duration);
        type.setRequestType(new BigInteger("6"));
        type.setTest(new BigInteger("0"));
        type.setTimeStamp(XMLHelper.calToXMLCal(new GregorianCalendar(TimeZone
                .getTimeZone("UTC"))));

        try {
            return MsgUtil.TypeToString(ShipPositionRequestType.class, type,
                                        XMLHelper.POSITION_REQUEST_NS,
                                        XMLHelper.POSITION_REQUEST_LOCAL_NAME);
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
