package com.rcswu.service;

import com.rcswu.domain.User;
import com.rcswu.exceptions.NameIsUsedException;
import com.rcswu.exceptions.PasswordIsError;
import com.rcswu.exceptions.UserIsNotFound;

import java.io.Serializable;
import java.util.List;

public interface UserService extends CommonService<User> {
    void saveUserRegist(User user) throws NameIsUsedException;
    User userLogin(User user) throws UserIsNotFound, PasswordIsError;
    User getUserByName(String userName);
    List<User> getRecommendUsers();
    User getUserById(Serializable userId);
}
