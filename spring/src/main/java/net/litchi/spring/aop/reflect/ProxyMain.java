package net.litchi.spring.aop.reflect;

import net.litchi.spring.ioc.pojo.User;
import net.litchi.spring.ioc.service.UserService;
import net.litchi.spring.ioc.service.impl.UserServiceImpl;
import net.litchi.spring.ioc.service.impl.UserServiceImpl2;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 10:26
 */
public class ProxyMain {
    public static void main(String[] args) {
        UserService origin = new UserServiceImpl();
        /*拦截器设计模式*/
        UserService  proxy = (UserService) JdkProxyFactory.bind(origin,"net.litchi.spring.aop.reflect.InterceptorImpl1");
        /*责任链模式*/
        UserService  proxyProxy = (UserService) JdkProxyFactory.bind(proxy,"net.litchi.spring.aop.reflect.InterceptorImpl2");

/*        System.out.println(proxy.add(1, 2));
        System.out.println("-------------------------------------------");
        System.out.println(proxy.test());
        System.out.println("-------------------------------------------");
        System.out.println(proxy.decrease(10, 2));*/
        System.out.println("-------------------------------------------");
        proxyProxy.add(1,2);


    }
}
