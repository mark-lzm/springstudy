package net.litchi.spring.ioc.service.impl;

import net.litchi.spring.ioc.dao.UserDao;
import net.litchi.spring.ioc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/1 23:05
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void doService() {
        System.out.println("UserServiceImpl");
        userDao.sayHello();
    }

    @Override
    public int add(int a, int b) {
        System.out.println("UserServiceImpl add invoke");

        return a + b;
    }

    @Override
    public int test() {
        return 1;
    }

    @Override
    public int decrease(int a, int b) {
        return a- b;
    }

}
