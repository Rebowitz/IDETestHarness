package org.imo.lrit.ide.test.ui;

import java.util.List;

import javax.faces.component.UIData;
import javax.faces.context.FacesContext;

import org.imo.lrit.ide.test.context.RcvdMsg;
import org.imo.lrit.ide.test.context.TesterContext;
import org.imo.lrit.ide.test.util.JSFUtil;

import org.apache.log4j.Logger;

public class RcvdListBean {
    
    private static final Logger log = Logger.getLogger(RcvdListBean.class);
    private static TesterContext dccRef = null;
    private List<RcvdMsg> rcvdMsgs;
    private UIData data;

    public List<RcvdMsg> getRcvdMsgs() {
        if (rcvdMsgs == null) {
            rcvdMsgs = getDcc().getRcvdMsgs();
        }
        return rcvdMsgs;
    }
    
    public String viewXML() {
        RcvdMsg  msg = (RcvdMsg)this.getData().getRowData();
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().getSessionMap().put("MsgToView", msg);
        return "rcvdmsg";
    }
    
    public String refresh() {
        rcvdMsgs = null;
        return "ok";
    }
    
    public String clear() {
        getDcc().clear();
        refresh();
        return "ok";
    }

    private TesterContext getDcc() {
        if (dccRef == null) {
            log.debug("PosrepBean getting new TesterContext");
            dccRef = (TesterContext)JSFUtil.getManagedBean("TesterContext");
        }
        return dccRef;
    }

    public UIData getData() {
        return data;
    }

    public void setData(UIData data) {
        this.data = data;
    }
}
