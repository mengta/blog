package com.rcswu.dao;

import com.rcswu.domain.Collection;

import java.util.List;

public interface CollectionDao extends CommonDao<Collection> {
    List<Object[]> findSomeCollections(int startIndex,int num,String userId);
    Integer getCollectionCount(String userId);
}
