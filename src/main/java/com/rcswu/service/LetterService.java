package com.rcswu.service;

import com.rcswu.domain.Letter;

import java.io.IOException;

public interface LetterService extends CommonService<Letter> {
    String findSendLetter(String userId) throws IOException;
    String findReceiveLetter(String userId) throws IOException;
}
