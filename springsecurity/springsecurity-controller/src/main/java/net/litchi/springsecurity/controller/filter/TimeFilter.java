package net.litchi.springsecurity.controller.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/7 20:26
 */
@Slf4j
public class TimeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long begin = System.currentTimeMillis();
        log.debug("TimeFilter begin at {}", begin);
        chain.doFilter(request, response);
        long end = System.currentTimeMillis();
        log.debug("TimeFilter end at {} and cost {} milsec", end, end - begin);
    }

}
