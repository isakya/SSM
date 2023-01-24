package com.izumi.spring.dao.impl;

import com.izumi.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    @Qualifier("userDaoImpl")
    public void saveUser() {
        System.out.println("±£´æ³É¹¦");
    }
}
