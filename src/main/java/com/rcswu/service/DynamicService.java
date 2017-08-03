package com.rcswu.service;

import com.rcswu.domain.Dynamic;

import java.io.IOException;

public interface DynamicService extends CommonService<Dynamic> {
    String findMyDynamic(String userId) throws IOException;
    String findMyAttentionDynamic(String userId) throws IOException;
}
