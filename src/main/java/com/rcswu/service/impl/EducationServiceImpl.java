package com.rcswu.service.impl;

import com.rcswu.dao.EducationDao;
import com.rcswu.domain.Education;
import com.rcswu.service.EducationService;

public class EducationServiceImpl extends CommonServiceImpl<Education> implements EducationService {
    private EducationDao educationDao;

    public EducationDao getEducationDao() {
        return educationDao;
    }

    public void setEducationDao(EducationDao educationDao) {
        this.educationDao = educationDao;
    }
}
