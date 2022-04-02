package net.litchi.spring.aop.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 11:02
 */
public class InterceptorImpl1 implements Interceptor {

    @Override
    public boolean before(Object target, Object proxy, Method method, Object[] args) {
        System.out.println("before InterceptorImpl1");
        return true;
    }

    @Override
    public Object around(Object target, Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around InterceptorImpl1");

        return method.invoke(target, args);
    }

    @Override
    public void afterReturning(Object target, Object proxy, Method method, Object[] args, Object result) {

        System.out.println("afterReturning InterceptorImpl1");

        System.out.println(new Date() + "使用了:"
                + Arrays.toString(args)
                + "作为参数，" + "调用了"
                + method.getName() + "方法，"
                + "得到了" + result + "结果");
    }

    @Override
    public void afterThrowing(Object target, Object proxy, Method method, Object[] args, Exception e) {
        System.out.println("afterThrowing InterceptorImpl1");

        e.printStackTrace();
    }

    @Override
    public void after(Object target, Object proxy, Method method, Object[] args) {
        System.out.println("after InterceptorImpl1");

    }
}
