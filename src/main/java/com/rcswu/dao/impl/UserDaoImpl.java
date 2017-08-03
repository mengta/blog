package com.rcswu.dao.impl;

import com.rcswu.dao.UserDao;
import com.rcswu.domain.User;
import com.rcswu.utils.PageHibernateCallBackUtil;
import org.springframework.orm.hibernate3.HibernateCallback;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("all")
public class UserDaoImpl extends CommonDaoImpl<User> implements UserDao {

    @Override
    public User getUserByName(String userName) {
        List<User> users= (List<User>) getHibernateTemplate().find("from User user where user.userName=?",userName);
        if(users==null||users.size()==0){
            return null;
        }
        return users.get(0);
    }

    @Override
    public List<User> findOnePageUsers(int startIndex, int dataNum) {
        List<User> users= (List<User>) getHibernateTemplate().execute((HibernateCallback<User>)new PageHibernateCallBackUtil(
                "from User user order by user.visitedNum desc ",startIndex,dataNum,null));
        if(users==null||users.size()==0){
            return null;
        }
        return users;
    }

    @Override
    public Integer getUsersCount() {
        return ((Long)getHibernateTemplate().find("select count(*) from User").listIterator().next()).intValue();
    }

    @Override
    public User getUserById(Serializable userId) {
        List<User> users= (List<User>) getHibernateTemplate().find("from User u left join fetch u.educations left join " +
                "fetch u.works where u.userId=?",userId);
        if(users==null||users.size()==0){
            return null;
        }
        return users.get(0);
    }
}
