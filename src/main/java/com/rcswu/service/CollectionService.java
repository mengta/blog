package com.rcswu.service;

import com.rcswu.domain.Collection;

import java.io.IOException;

public interface CollectionService extends CommonService<Collection> {
    String findCollectionsPage(String pageNum,String userId) throws IOException;
}
