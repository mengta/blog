package com.rcswu.dao;

import com.rcswu.domain.Attention;

import java.util.List;

public interface AttentionDao extends CommonDao<Attention> {
    List<Object[]> findMyAttention(String userId);
    List<Object[]> findFollowMe(String userId);
    List<Object[]> findMutualConcern(String userId);
    Attention findAttentionId(String attentionUserId,String followUserId);
}
