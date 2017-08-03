package com.rcswu.action;

import com.rcswu.domain.PersonalClassification;
import com.rcswu.service.PersonalClassificationService;

import java.io.IOException;

@SuppressWarnings("serial")
public class PersonalClassificationAction extends MyBaseAction {
    private PersonalClassificationService personalClassificationService;
    private PersonalClassification pClassification;

    public PersonalClassificationService getPersonalClassificationService() {
        return personalClassificationService;
    }

    public void setPersonalClassificationService(PersonalClassificationService personalClassificationService) {
        this.personalClassificationService = personalClassificationService;
    }

    public PersonalClassification getpClassification() {
        return pClassification;
    }

    public void setpClassification(PersonalClassification pClassification) {
        this.pClassification = pClassification;
    }

    public String findMyClass(){
        if(baseUser==null){
            setState("3");
            setMessage("loginView.action");
            return "myclass";
        }
        try {
            setMessage(personalClassificationService.findUserClass(baseUser.getUserId()));
            setState("0");
        } catch (IOException e) {
            setState("2");
            setMessage("获取失败！");
        }
        return "myclass";
    }
    public String deleteMyClass(){
        if(baseUser==null){
            setState("3");
            setMessage("loginView.action");
            return "myclass";
        }
        if(pClassification==null||pClassification.getClassificationId().isEmpty()){
            setState("2");
            setMessage("删除失败！");
            return "myclass";
        }
        personalClassificationService.deleteEntityById(pClassification.getClassificationId());
        setState("0");
        return "myclass";
    }
    public String saveMyClass(){
        if(baseUser==null){
            setState("3");
            setMessage("loginView.action");
            return "myclass";
        }
        if(pClassification==null){
            setState("2");
            setMessage("保存失败！");
            return "myclass";
        }else if(pClassification.getClassificationId()==null || pClassification.getClassificationId().isEmpty()){
            personalClassificationService.saveEntity(pClassification);
            setState("0");
        }else{
            personalClassificationService.saveUserClass(pClassification);
            setState("0");
        }
        return "myclass";
    }
}
