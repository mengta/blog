package com.rcswu.service.impl;

import com.rcswu.dao.AttentionDao;
import com.rcswu.domain.Attention;
import com.rcswu.service.AttentionService;
import com.rcswu.utils.JsonConvertUtil;

import java.io.IOException;
import java.util.List;

public class AttentionServiceImpl extends CommonServiceImpl<Attention> implements AttentionService {
    private AttentionDao attentionDao;

    public AttentionDao getAttentionDao() {
        return attentionDao;
    }

    public void setAttentionDao(AttentionDao attentionDao) {
        this.attentionDao = attentionDao;
    }

    @Override
    public String findMyAttention(String userId) throws IOException {
        List<Object[]> objects=attentionDao.findMyAttention(userId);
        String json= JsonConvertUtil.returnJson(objects);
        return json;
    }

    @Override
    public String findFollowMe(String userId) throws IOException {
        List<Object[]> objects=attentionDao.findFollowMe(userId);
        String json=JsonConvertUtil.returnJson(objects);
        return json;
    }

    @Override
    public String findMutualConcern(String userId) throws IOException {
        List<Object[]> objects=attentionDao.findMutualConcern(userId);
        String json=JsonConvertUtil.returnJson(objects);
        return json;
    }

    @Override
    public String findAttentionId(String attentionUserId, String followUserId) {
        Attention attention=attentionDao.findAttentionId(attentionUserId,followUserId);
        if(attention!=null){
            return attention.getAttentionId();
        }
        return "1";
    }
}
