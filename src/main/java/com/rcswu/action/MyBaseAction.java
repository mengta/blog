package com.rcswu.action;

import com.opensymphony.xwork2.ActionSupport;
import com.rcswu.domain.User;
import com.rcswu.utils.ErrorMessageUtil;
import com.rcswu.utils.JsonConvertUtil;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;

@SuppressWarnings("serial")
public class MyBaseAction extends ActionSupport {
    private String message;
    private String state;
    protected ErrorMessageUtil errorMessage=new ErrorMessageUtil();
    protected User baseUser= (User) ServletActionContext.getContext().getSession().get("user");
    protected User visitedUser= (User) ServletActionContext.getContext().getSession().get("visitedUser");
//    protected User baseUser=new User();
//    protected User visitedUser=new User();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    protected boolean haveError(String error){
        if(!errorMessage.isEmpty()){
            try {
                setState("1");
                setMessage(JsonConvertUtil.returnJson(errorMessage.getErrors()));
            } catch (IOException e) {
                setState("2");
                setMessage(error);
            }
            return true;
        }
        return false;
    }
}
