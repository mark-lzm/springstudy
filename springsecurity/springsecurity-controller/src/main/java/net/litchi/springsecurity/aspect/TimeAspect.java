package net.litchi.springsecurity.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/7 20:49
 */
@Slf4j
@Component
//@Aspect
public class TimeAspect {

    @Pointcut("execution(* net.litchi..*.controller.*.*(..))")
    public void pointCut(){

    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        log.debug("TimeAspect begin at {}", begin);
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        log.debug("TimeAspect end at {} and cost {} milsec", end, end - begin);
        return result;
    }
}
