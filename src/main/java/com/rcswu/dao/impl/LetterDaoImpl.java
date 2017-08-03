package com.rcswu.dao.impl;

import com.rcswu.dao.LetterDao;
import com.rcswu.domain.Letter;

import java.util.List;
@SuppressWarnings("all")
public class LetterDaoImpl extends CommonDaoImpl<Letter> implements LetterDao {
    @Override
    public List<Object[]> findLettersBySendUserId(String userId) {
        return (List<Object[]>) getHibernateTemplate().find("select l.letterId,l.letterContent,r.userId,r.userNickname,l.sendDate from Letter l left join l.userByReceiveUser r " +
                "left join l.userBySendUser s where s.userId=? order by l.sendDate desc",userId);
    }

    @Override
    public List<Object[]> findLettersByReceiveUserId(String userId) {
        return (List<Object[]>) getHibernateTemplate().find("select l.letterId,l.letterContent,s.userId,s.userNickname,s.userImg,l.sendDate from Letter l " +
                "left join l.userBySendUser s where r.userId=? order by l.sendDate desc",userId);
    }
}
