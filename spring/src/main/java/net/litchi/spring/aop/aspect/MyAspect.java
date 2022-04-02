package net.litchi.spring.aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 11:28
 */
@Component
@Aspect
public class MyAspect {

    @Pointcut("execution(* net.litchi..*.service.impl.*.*(..))")
    public void pc() {
    }

    @Before(value = "pc()")
    boolean before(JoinPoint joinpoint) {
        System.out.println("before advice");
        return true;
    }

    @Around(value = "pc()")
    Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around advice");

        Object result = proceedingJoinPoint.proceed();
        return result;
    }

    @AfterReturning(pointcut = "pc()", returning = "result")
    void afterReturning(JoinPoint joinpoint, Object result) {
        System.out.println("afterReturning advice");
    }

    @AfterThrowing(pointcut = "pc()", throwing = "e")
    void afterThrowing(JoinPoint joinpoint, Exception e) {
        System.out.println("afterThrowing advice");

    }

    @After(value = "pc()")
    void after(JoinPoint joinpoint) {
        System.out.println("after advice");

    }

}
