package net.litchi.springsecurity.configuration;

import lombok.AllArgsConstructor;
import net.litchi.springsecurity.controller.filter.TimeFilter;
import net.litchi.springsecurity.controller.interceptor.TimeInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/7 20:32
 */
@Configuration
@AllArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private TimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

    @Bean
    public FilterRegistrationBean TimeFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();

        List<String> urls = new ArrayList<>();
        urls.add("/*");

        filterRegistrationBean.setFilter(timeFilter);
        filterRegistrationBean.setUrlPatterns(urls);
        return filterRegistrationBean;
    }
}
