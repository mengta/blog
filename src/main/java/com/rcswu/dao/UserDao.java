package com.rcswu.dao;

import com.rcswu.domain.User;

import java.io.Serializable;
import java.util.List;

public interface UserDao extends CommonDao<User> {
    User getUserByName(String userName);
    List<User> findOnePageUsers(int startIndex,int dataNum);
    Integer getUsersCount();
    User getUserById(Serializable userId);
}
