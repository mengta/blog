package com.rcswu.dao.impl;

import com.rcswu.dao.PersonalClassificationDao;
import com.rcswu.domain.PersonalClassification;

import java.util.List;

public class PersonalClassificationDaoImpl extends CommonDaoImpl<PersonalClassification> implements PersonalClassificationDao {
    @SuppressWarnings("unchecked")
    @Override
    public List<Object[]> findClassByUserId(String userId) {
        return (List<Object[]>) getHibernateTemplate().find("select classificationId,classificationName,articleClasses.size " +
                "as articleCount from PersonalClassification p where p.user.userId=?",userId);
    }
}
