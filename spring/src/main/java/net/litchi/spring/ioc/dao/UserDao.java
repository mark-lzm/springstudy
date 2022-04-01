package net.litchi.spring.ioc.dao;

import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/1 23:05
 */
@Repository
public class UserDao {

    public void sayHello() {
        System.out.println("UserDao");
        System.out.println("hello");
    }
}
