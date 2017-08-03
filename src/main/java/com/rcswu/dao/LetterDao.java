package com.rcswu.dao;

import com.rcswu.domain.Letter;

import java.util.List;

public interface LetterDao extends CommonDao<Letter> {
    List<Object[]> findLettersBySendUserId(String userId);
    List<Object[]> findLettersByReceiveUserId(String userId);
}
