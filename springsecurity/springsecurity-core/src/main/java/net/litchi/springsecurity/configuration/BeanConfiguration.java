package net.litchi.springsecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/10 12:11
 */
@Configuration
public class BeanConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RequestCache requestCache() {
        return new HttpSessionRequestCache();
    }

    @Bean
    public RedirectStrategy redirectStrategy() {
        return new DefaultRedirectStrategy();
    }

    @Bean
    public SessionStrategy sessionStrategy(){
        return new HttpSessionSessionStrategy();
    }

    @Bean
    public AntPathMatcher antPathMatcher(){
        return new AntPathMatcher();
    }

}
