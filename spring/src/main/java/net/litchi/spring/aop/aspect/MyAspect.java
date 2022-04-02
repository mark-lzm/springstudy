package net.litchi.spring.aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 11:28
 */
public class MyAspect {
    boolean before(JoinPoint joinpoint){
        System.out.println("before advice");
        return true;
    }

    Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around advice");

        Object result = proceedingJoinPoint.proceed();
        return result;
    }

    void afterReturning(JoinPoint joinpoint, Object result){
        System.out.println("afterReturning advice");

    }

    void afterThrowing(JoinPoint joinpoint, Exception e){
        System.out.println("afterThrowing advice");

    }

    void after(JoinPoint joinpoint){
        System.out.println("after advice");

    }

}
