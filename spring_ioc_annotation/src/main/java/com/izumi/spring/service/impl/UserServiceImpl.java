package com.izumi.spring.service.impl;

import com.izumi.spring.dao.UserDao;
import com.izumi.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    // @Autowired
    // public UserServiceImpl(UserDao userDao) {
    //     this.userDao = userDao;
    // }

    // @Autowired
    // public void setUserDao(UserDao userDao) {
    //     this.userDao = userDao;
    // }

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
