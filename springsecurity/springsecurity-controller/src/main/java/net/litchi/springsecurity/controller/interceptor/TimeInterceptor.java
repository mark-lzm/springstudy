package net.litchi.springsecurity.controller.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/7 20:39
 */
@Slf4j
@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long begin = System.currentTimeMillis();
        log.debug("TimeInterceptor begin at {}", begin);
        request.setAttribute("begin",begin);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long begin = (long) request.getAttribute("begin");
        long end = System.currentTimeMillis();
        log.debug("TimeInterceptor end at {} and cost {} milsec", end, end - begin);
    }
}
