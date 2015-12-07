/**
 * Counts.java
 *
 * Last Update $Id: Counts.java,v 1.3 2008-07-14 21:55:07 rba Exp $
 *
 * History:
 * $Log: Counts.java,v $
 * Revision 1.3  2008-07-14 21:55:07  rba
 * Making the testDC as mockiest of the mockDC as possible.
 *
 * Revision 1.1  2008-04-19 00:38:17  lgl
 * Many changes - still in state of flux.
 *
 */
package org.imo.lrit.ide.test.context;

/**
 * Container for message counts.
 */
public class Counts {
    public int rcvCountDDP = 0;
    public int rcvCountDC1 = 0;
    public int rcvCountDC2 = 0;
    public int rcvCountOther = 0;
    public int sentCount = 0;
    public String type;

    public Counts(String type, int sentCount, int rcvCountDDP, int rcvCountDC1,
            int rcvCountDC2, int rcvCountOther) {
        this.type = type;
        this.sentCount = sentCount;
        this.rcvCountDDP = rcvCountDDP;
        this.rcvCountDC1 = rcvCountDC1;
        this.rcvCountDC2 = rcvCountDC2;
        this.rcvCountOther = rcvCountOther;
    }

    /**
     * Gets the value of rcvCountDDP
     * 
     * @return the rcvCountDDP
     */
    public int getRcvCountDDP() {
        return rcvCountDDP;
    }

    /**
     * Gets the value of rcvCountDC1
     * 
     * @return the rcvCountDC1
     */
    public int getRcvCountDC1() {
        return rcvCountDC1;
    }

    /**
     * Gets the value of rcvCountDC2
     * 
     * @return the rcvCountDC2
     */
    public int getRcvCountDC2() {
        return rcvCountDC2;
    }
    
    /**
     * Gets the value of rcvCountOther
     * 
     * @return the rcvCountOther
     */
    public int getRcvCountOther() {
        return rcvCountOther;
    }

    /**
     * Gets the value of sentCount
     * 
     * @return the sentCount
     */
    public int getSentCount() {
        return sentCount;
    }

    /**
     * Gets the value of type
     * 
     * @return the type
     */
    public String getType() {
        return type;
    }

}
