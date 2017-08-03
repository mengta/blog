package com.rcswu.service.impl;

import com.rcswu.dao.LetterDao;
import com.rcswu.domain.Letter;
import com.rcswu.service.LetterService;
import com.rcswu.utils.JsonConvertUtil;

import java.io.IOException;

public class LetterServiceImpl extends CommonServiceImpl<Letter> implements LetterService {

    private LetterDao letterDao;

    public LetterDao getLetterDao() {
        return letterDao;
    }

    public void setLetterDao(LetterDao letterDao) {
        this.letterDao = letterDao;
    }

    @Override
    public String findSendLetter(String userId) throws IOException {
        String json= JsonConvertUtil.returnJson(letterDao.findLettersBySendUserId(userId));
        return null;
    }

    @Override
    public String findReceiveLetter(String userId) throws IOException {
        String json=JsonConvertUtil.returnJson(letterDao.findLettersByReceiveUserId(userId));
        return json;
    }
}
