package com.rcswu.service.impl;

import com.rcswu.dao.PersonalClassificationDao;
import com.rcswu.domain.PersonalClassification;
import com.rcswu.service.PersonalClassificationService;
import com.rcswu.utils.JsonConvertUtil;

import java.io.IOException;
import java.util.List;

public class PersonalClassificationServiceImpl extends CommonServiceImpl<PersonalClassification> implements PersonalClassificationService {
    private PersonalClassificationDao personalClassificationDao;

    public PersonalClassificationDao getPersonalClassificationDao() {
        return personalClassificationDao;
    }

    public void setPersonalClassificationDao(PersonalClassificationDao personalClassificationDao) {
        this.personalClassificationDao = personalClassificationDao;
    }

    @Override
    public String findUserClass(String userId) throws IOException {
        List<Object[]> personcls=personalClassificationDao.findClassByUserId(userId);
        return JsonConvertUtil.returnJson(personcls);
    }

    @Override
    public void saveUserClass(PersonalClassification pClassification) {
        PersonalClassification p=personalClassificationDao.getById(pClassification.getClassificationId());
        p.setClassificationName(pClassification.getClassificationName());
        personalClassificationDao.update(p);
    }
}
