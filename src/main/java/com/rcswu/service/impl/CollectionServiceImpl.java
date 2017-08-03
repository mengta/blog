package com.rcswu.service.impl;

import com.rcswu.dao.CollectionDao;
import com.rcswu.domain.Collection;
import com.rcswu.service.CollectionService;
import com.rcswu.utils.JsonConvertUtil;
import com.rcswu.utils.PageUtil;

import java.io.IOException;
import java.util.List;

public class CollectionServiceImpl extends CommonServiceImpl<Collection> implements CollectionService {
    private CollectionDao collectionDao;

    public CollectionDao getCollectionDao() {
        return collectionDao;
    }

    public void setCollectionDao(CollectionDao collectionDao) {
        this.collectionDao = collectionDao;
    }

    @Override
    public String findCollectionsPage(String pageNum, String userId) throws IOException {
        int num=1;
        if(pageNum!=null&&!"".equals(pageNum)){
            num=Integer.parseInt(pageNum);
        }
        int totalRecords=collectionDao.getCollectionCount(userId);
        PageUtil page=new PageUtil(num,totalRecords);
        List<Object[]> collections=collectionDao.findSomeCollections(page.getStartIndex(),page.getPageRecords(),userId);
        page.setRecords(collections);
        String json= JsonConvertUtil.returnJson(page);
        return json;
    }
}
