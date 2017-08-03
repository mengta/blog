package com.rcswu.service.impl;

import com.rcswu.dao.UserDao;
import com.rcswu.domain.User;
import com.rcswu.exceptions.NameIsUsedException;
import com.rcswu.exceptions.PasswordIsError;
import com.rcswu.exceptions.UserIsNotFound;
import com.rcswu.service.UserService;
import com.rcswu.utils.MD5Util;

import java.io.Serializable;
import java.util.List;

public class UserServiceImpl extends CommonServiceImpl<User> implements UserService {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUserRegist(User user) throws NameIsUsedException {
        User u=userDao.getUserByName(user.getUserName());
        if(u!=null){
            throw new NameIsUsedException("该用户名已存在！");
        }
        user.setPassword(MD5Util.md5Encod(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public User userLogin(User user) throws UserIsNotFound, PasswordIsError {
        User u=userDao.getUserByName(user.getUserName());
        if(u==null){
            throw new UserIsNotFound("该用户不存在!");
        }
        String pass=MD5Util.md5Encod(user.getPassword());
        if(!pass.equals(u.getPassword())){
            throw new PasswordIsError("密码错误!");
        }
        return u;
    }

    @Override
    public User getUserByName(String userName) {
        return userDao.getUserByName(userName);
    }

    @Override
    public List<User> getRecommendUsers() {
        List<User> users=userDao.findOnePageUsers(0,9);
        return users;
    }

    @Override
    public User getUserById(Serializable userId) {
        User user=userDao.getUserById(userId);
        return user;
    }
}
