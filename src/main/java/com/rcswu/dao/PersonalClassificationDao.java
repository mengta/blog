package com.rcswu.dao;

import com.rcswu.domain.PersonalClassification;

import java.util.List;

public interface PersonalClassificationDao extends CommonDao<PersonalClassification> {
    List<Object[]> findClassByUserId(String userId);
}
