package net.litchi.springsecurity.validate;

import lombok.AllArgsConstructor;
import net.litchi.springsecurity.properties.ProjectConstant;
import net.litchi.springsecurity.properties.ProjectProperties;
import net.litchi.springsecurity.validate.code.ValidateCode;
import net.litchi.springsecurity.validate.exception.ValidateCodeException;
import net.litchi.springsecurity.validate.processor.ValidateCodeProcessor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 拦截的地址
 *
 * @Description
 * @Author Mark
 * @Date 2022/4/12 20:33
 */
@Component
@AllArgsConstructor
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {

    private ProjectProperties projectProperties;
    private AuthenticationFailureHandler authenticationFailureHandler;

    private List<ValidateCodeProcessor> validateCodeProcessors;

    /**
     * /authentication/*
     * <p>
     * 应用中需要验证码验证的请求地址
     */
    private Set<String> urls = new HashSet<>();

    /**
     * 路劲匹配器
     */
    private AntPathMatcher matcher;

    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        String[] urlsConfig = StringUtils.splitByWholeSeparatorPreserveAllTokens(
                projectProperties.getValidateCode().getImageValidateCode().getUrls(),
                ",");
        for (String s : urlsConfig) {
            urls.add(s);
        }

        //默认拦截的地址，防止在yml文件设置为空则传进来是一个null
        urls.add(ProjectConstant.LOGIN_PROCESSING_URL);
        urls.add(ProjectConstant.MOBILE_LOGIN_PROCESSING_URL);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        boolean flag = false;
        //匹配路径，判断是否拦截
        for (String url : urls) {
            if (matcher.match(url, request.getRequestURI())) {
                flag = true;
            }
        }

        if (flag) {
            try {
                for (ValidateCodeProcessor validateCodeProcessor : validateCodeProcessors) {
                    //循环查找适合的处理器，是否需要验证
                    if (validateCodeProcessor.isValidate(StringUtils.substringAfter(request.getRequestURI(),
                            ProjectConstant.AUTHENTICATION_URI + "/"))) {
                        validateCodeProcessor.validate(new ServletWebRequest(request, response));
                    }
                }
                filterChain.doFilter(request, response);
            } catch (AuthenticationException e) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
