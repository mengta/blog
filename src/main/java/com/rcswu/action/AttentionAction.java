package com.rcswu.action;

import com.rcswu.domain.Attention;
import com.rcswu.service.AttentionService;

import java.io.IOException;

@SuppressWarnings("serial")
public class AttentionAction extends MyBaseAction {
    private AttentionService attentionService;
    private Attention attention;
    private String attentionType;

    public AttentionService getAttentionService() {
        return attentionService;
    }

    public void setAttentionService(AttentionService attentionService) {
        this.attentionService = attentionService;
    }

    public Attention getAttention() {
        return attention;
    }

    public void setAttention(Attention attention) {
        this.attention = attention;
    }

    public String getAttentionType() {
        return attentionType;
    }

    public void setAttentionType(String attentionType) {
        this.attentionType = attentionType;
    }

    public String attentionUser(){
        if(visitedUser!=null&&!visitedUser.getUserId().isEmpty()){
            attentionService.saveEntity(new Attention(visitedUser,baseUser));
            setState("0");
            setMessage("关注成功！");
        }else{
            setState("2");
            setMessage("关注失败！");
        }
        return "attention";
    }
    public String cancelAttention(){
        if(attention!=null&&!attention.getAttentionId().isEmpty()){
            attentionService.deleteEntityById(attention.getAttentionId());
            setState("0");
            setMessage("取消成功！");
        }else{
            setState("0");
            setMessage("取消关注失败！");
        }
        return "attention";
    }
    public String getMyAttention(){
        if(visitedUser!=null&&!visitedUser.getUserId().isEmpty()){
            try{
                switch (attentionType){
                    case "0":
                        setMessage(attentionService.findMyAttention(visitedUser.getUserId()));
                        break;
                    case "1":
                        setMessage(attentionService.findFollowMe(visitedUser.getUserId()));
                        break;
                    case "2":
                        setMessage(attentionService.findMutualConcern(visitedUser.getUserId()));
                        break;
                }
                setState("0");
            } catch (IOException e) {
                setState("0");
                setMessage("出错了！");
            }
        }else{
            setState("0");
            setMessage("出错了！");
        }
        return "attention";
    }
}
