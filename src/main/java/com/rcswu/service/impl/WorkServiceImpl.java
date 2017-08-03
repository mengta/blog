package com.rcswu.service.impl;

import com.rcswu.dao.WorkDao;
import com.rcswu.domain.Work;
import com.rcswu.service.WorkService;

public class WorkServiceImpl extends CommonServiceImpl<Work> implements WorkService {
    private WorkDao workDao;

    public WorkDao getWorkDao() {
        return workDao;
    }

    public void setWorkDao(WorkDao workDao) {
        this.workDao = workDao;
    }
}
