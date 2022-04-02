package net.litchi.spring.aop.reflect;

import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 10:26
 */
public class JdkProxyFactory {

    /**
     * 任何对象都可以放进来，会得到该对象的代理对象
     *
     * @param target
     * @return
     */
    public static Object bind(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new JdkProxyProcessor(target));
    }

    /**
     * 任何对象都可以放进来，会得到该对象的代理对象
     *
     * @param target
     * @return
     */
    public static Object bind(Object target, String interceptorName) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new JdkProxyProcessor(target, interceptorName));
    }

}
