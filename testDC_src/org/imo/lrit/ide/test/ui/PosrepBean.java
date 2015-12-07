package org.imo.lrit.ide.test.ui;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.imo.lrit.ide.test.context.TesterContext;
import org.imo.lrit.ide.test.util.JSFUtil;
import org.imo.lrit.ide.test.util.MsgUtil;

import org.apache.log4j.Logger;
import org.imo.gisis.xml.lrit.positionreport._2008.ShipPositionReportType;
import org.imo.lrit.common.util.XMLHelper;

public class PosrepBean {
    private static TesterContext dccRef = null;
    private static final Logger log = Logger.getLogger(PosrepBean.class);

    private String xml;

    private String createMsgId(Calendar curr) {
        return String.format("%04d%04d%02d%02d%02d%02d%02d%05d", Integer
                .parseInt(getDcc().getDc1LritId()), curr.get(Calendar.YEAR),
                             curr.get(Calendar.MONTH) + 1, curr
                                     .get(Calendar.DAY_OF_MONTH), curr
                                     .get(Calendar.HOUR_OF_DAY), curr
                                     .get(Calendar.MINUTE), curr
                                     .get(Calendar.SECOND), getDcc()
                                     .getMsgIdSuffix());
    }

    private TesterContext getDcc() {
        if (dccRef == null) {
            log.debug("PosrepBean getting new TesterContext");
            dccRef = (TesterContext) JSFUtil.getManagedBean("TesterContext");
        }
        return dccRef;
    }

    /**
     * @return the xml
     */
    public String getXml() {
        if (xml == null) {
            xml = initPosrep();
        }
        return xml;
    }

    private String initPosrep() {
        GregorianCalendar createdGc = new GregorianCalendar(TimeZone
                .getTimeZone("UTC"));
        createdGc.add(Calendar.SECOND, -4);
        GregorianCalendar aspRcvGc = new GregorianCalendar(TimeZone
                .getTimeZone("UTC"));
        aspRcvGc.add(Calendar.SECOND, -3);
        GregorianCalendar aspSendGc = new GregorianCalendar(TimeZone
                .getTimeZone("UTC"));
        aspSendGc.add(Calendar.SECOND, -2);
        GregorianCalendar dcRcvGc = new GregorianCalendar(TimeZone
                .getTimeZone("UTC"));
        dcRcvGc.add(Calendar.SECOND, -1);
        GregorianCalendar dcSendGc = new GregorianCalendar(TimeZone
                .getTimeZone("UTC"));

        ShipPositionReportType posrep = new ShipPositionReportType();
        posrep.setLatitude("47.37.00.N");
        posrep.setLongitude("052.40.00.W");
        posrep.setTimeStamp1(XMLHelper.calToXMLCal(createdGc));
        posrep.setTimeStamp2(XMLHelper.calToXMLCal(aspRcvGc));
        posrep.setTimeStamp3(XMLHelper.calToXMLCal(aspSendGc));
        posrep.setTimeStamp4(XMLHelper.calToXMLCal(dcRcvGc));
        posrep.setTimeStamp5(XMLHelper.calToXMLCal(dcSendGc));
        posrep.setShipborneEquipmentId("123456789");
        posrep.setASPId("0025");
        posrep.setCSPId("0026");
        posrep.setMessageType(new BigInteger("1"));
        posrep.setMessageId(createMsgId(dcSendGc));
        posrep.setReferenceId("");
        posrep.setIMONum("0000035");
        posrep.setMMSINum("123456789");
        posrep.setDCId(getDcc().getDc1LritId());
        posrep.setResponseType(new BigInteger("1"));
        posrep.setDataUserRequestor(getDcc().getDestDuLritId());
        posrep.setDataUserProvider(getDcc().getDc1DuLritId());
        posrep.setDDPVersionNum(getDcc().getDdpVersion());

        try {
            return MsgUtil.TypeToString(ShipPositionReportType.class, posrep,
                                        XMLHelper.POSITION_REPORT_NS,
                                        XMLHelper.POSITION_REPORT_LOCAL_NAME);
            // JAXBElement<ShipPositionReportType> element =
            // new JAXBElement<ShipPositionReportType>(
            // new QName(
            //                                                                                                            
            // XMLHelper.POSITION_REPORT_NS,
            // "ShipPositionReport"),
            // ShipPositionReportType.class,
            // posrep);
            // JAXBContext jaxbctx = JAXBContext
            // .newInstance(XMLHelper.POSITION_REPORT_PKG);
            // Marshaller m = jaxbctx.createMarshaller();
            // m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // m.marshal(element, baos);
            // return baos.toString();
        } catch (Exception e) {
            throw new RuntimeException("JAXB Exception: ", e);
        }
    }

    public String sendPosrep() {
        String result = MsgUtil.sendDCTypeXMLToIDE(this.getXml());
        xml = null;
        log.info("sendPosrep() returning: " + result);
        return result;
    }

    /**
     * @param xml
     *            the xml to set
     */
    public void setXml(String xml) {
        this.xml = xml;
    }

}
