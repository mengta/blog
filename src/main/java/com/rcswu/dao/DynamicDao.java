package com.rcswu.dao;

import com.rcswu.domain.Dynamic;

import java.util.List;

public interface DynamicDao extends CommonDao<Dynamic> {
    List<Object[]> findMyDynamic(String userId);
    List<Object[]> findMyAttentionDynamic(String userId);
}
