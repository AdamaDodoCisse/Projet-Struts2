package fr.appli.qcm.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;


public class AbstractAction extends ActionSupport implements SessionAware {

    protected Map<String, Object> session ;

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
