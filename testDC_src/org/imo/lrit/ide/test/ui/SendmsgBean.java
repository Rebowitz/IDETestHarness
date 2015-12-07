package org.imo.lrit.ide.test.ui;

import org.imo.lrit.ide.test.util.MsgUtil;

import org.apache.log4j.Logger;

public class SendmsgBean {
    private static final Logger log = Logger.getLogger(SendmsgBean.class);

    private String ideInterface = "DC";
    private String title;
    private String xml;

    /**
     * Configures this bean to send a new message
     * 
     * @param title
     *            the text that is to appear over the window containing the XML.
     * @param xml
     *            the XML to be sent
     * @param ideInterface
     *            the IDE interface to be sent to - "DC" or "DDP".
     */
    public void configure(String title, String xml, String ideInterface) {
        setTitle(title);
        setXml(xml);
        setIdeInterface(ideInterface);
    }

    /**
     * Gets the value of ideInterface
     * 
     * @return the ideInterface
     */
    public String getIdeInterface() {
        return ideInterface;
    }

    /**
     * Gets the value of title
     * 
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the value of xml
     * 
     * @return the xml
     */
    public String getXml() {
        return xml;
    }

    public String send() {
        String result;
        if (ideInterface.equals("DC")) {
            result = MsgUtil.sendDCTypeXMLToIDE(this.getXml());
        } else {
            result = MsgUtil.sendDDPTypeXMLToIDE(this.getXml());
        }
        if (result.equals("success")) {
            xml = null;
        }
        log.info("send() returning " + result);
        return result;
    }

    /**
     * Sets the value of ideInterface - must be either "DDP" or "DC". The user
     * should use the configure() method rather than this method to configure
     * this bean. This method is public for JSF.
     * 
     * @param ideInterface
     *            either "DDP" or "DC"
     * @throws RuntimeException
     *             if ideInterface is not either "DDP" or "DC".
     */
    public void setIdeInterface(String ideInterface) {
        if (!(ideInterface.equals("DDP") || ideInterface.equals("DC"))) {
            throw new RuntimeException(
                                       "ideInterface must be \"DDP\" or \"DC\".");
        }
        this.ideInterface = ideInterface;
    }

    /**
     * Sets the value of title. The user should use the configure() method
     * rather than this method to configure this bean. This method is public for
     * JSF.
     * 
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the value of xml. The user should use the configure() method rather
     * than this method to configure this bean. This method is public for JSF.
     * 
     * @param xml
     *            the xml to set
     */
    public void setXml(String xml) {
        this.xml = xml;
    }

}
