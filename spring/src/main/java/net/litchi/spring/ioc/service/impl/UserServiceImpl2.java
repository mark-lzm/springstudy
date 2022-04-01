package net.litchi.spring.ioc.service.impl;

import net.litchi.spring.ioc.dao.UserDao;
import net.litchi.spring.ioc.service.UserService;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/1 23:05
 */
public class UserServiceImpl2 implements UserService {


    private UserDao userDao;

    @Override
    public void doService() {
        System.out.println("UserServiceImpl2");
        userDao.sayHello();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}