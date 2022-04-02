package net.litchi.spring.aop.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 10:55
 */
public interface Interceptor {
    boolean before(Object target, Object proxy, Method method, Object[] args);

    Object around(Object target, Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException;

    void afterReturning(Object target, Object proxy, Method method, Object[] args, Object result);

    void afterThrowing(Object target, Object proxy, Method method, Object[] args, Exception e);

    void after(Object target, Object proxy, Method method, Object[] args);

}
