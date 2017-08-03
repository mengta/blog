package com.rcswu.service;

import com.rcswu.domain.Attention;

import java.io.IOException;

public interface AttentionService extends CommonService<Attention> {
    String findMyAttention(String userId) throws IOException;
    String findFollowMe(String userId) throws IOException;
    String findMutualConcern(String userId) throws IOException;
    String findAttentionId(String attentionUserId,String followUserId);
}
