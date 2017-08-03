package com.rcswu.service.impl;

import com.rcswu.dao.DynamicDao;
import com.rcswu.domain.Dynamic;
import com.rcswu.service.DynamicService;
import com.rcswu.utils.JsonConvertUtil;

import java.io.IOException;
import java.util.List;

public class DynamicServiceImpl extends CommonServiceImpl<Dynamic> implements DynamicService {
    private DynamicDao dynamicDao;

    public DynamicDao getDynamicDao() {
        return dynamicDao;
    }

    public void setDynamicDao(DynamicDao dynamicDao) {
        this.dynamicDao = dynamicDao;
    }

    @Override
    public String findMyDynamic(String userId) throws IOException {
        List<Object[]> objects=dynamicDao.findMyDynamic(userId);
        String json= JsonConvertUtil.returnJson(objects);
        return json;
    }

    @Override
    public String findMyAttentionDynamic(String userId) throws IOException {
        List<Object[]> objects=dynamicDao.findMyAttentionDynamic(userId);
        String json=JsonConvertUtil.returnJson(objects);
        return json;
    }
}
