package com.rcswu.service;

import com.rcswu.domain.PersonalClassification;

import java.io.IOException;

public interface PersonalClassificationService extends CommonService<PersonalClassification> {
    String findUserClass(String userId) throws IOException;
    void saveUserClass(PersonalClassification pClassification);
}
