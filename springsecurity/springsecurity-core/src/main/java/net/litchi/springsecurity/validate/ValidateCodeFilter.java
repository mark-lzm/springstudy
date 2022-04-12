package net.litchi.springsecurity.validate;

import lombok.AllArgsConstructor;
import net.litchi.springsecurity.properties.ProjectConstant;
import net.litchi.springsecurity.properties.ProjectProperties;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截的地址
 *
 * @Description
 * @Author Mark
 * @Date 2022/4/12 20:33
 */
@Component
@AllArgsConstructor
public class ValidateCodeFilter extends OncePerRequestFilter {

    private ProjectProperties projectProperties;
    private SessionStrategy sessionStrategy;
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (StringUtils.equals(projectProperties.getWeb().getLoginProcessingUrl(), request.getRequestURI())) {
            try {
                validate(new ServletWebRequest(request, response));
                filterChain.doFilter(request, response);
            } catch (AuthenticationException e) {
                authenticationFailureHandler.onAuthenticationFailure(request, response, e);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    public void validate(ServletWebRequest servletWebRequest) {
        String codeInRequest = servletWebRequest.getRequest().getParameter(projectProperties.getValidateCode().getImageValidateCode().getParamName());
        ValidateCode codeInSession = (ValidateCode) sessionStrategy.getAttribute(servletWebRequest, ProjectConstant.IMAGE_VALIDATE_CODE_IN_SESSION);
        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("验证码的值不能为空");
        }

        if (codeInSession == null) {
            throw new ValidateCodeException("验证码不存在");
        }

        if (codeInSession.isExpire()) {
            // 销毁验证码
            sessionStrategy.removeAttribute(servletWebRequest, ProjectConstant.IMAGE_VALIDATE_CODE_IN_SESSION);
            throw new ValidateCodeException("验证码已过期");
        }

        if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
            throw new ValidateCodeException("验证码不匹配,请重新输入");
        }

        // 每次登录请求提交，不管成功没成功都刷新验证码
        sessionStrategy.removeAttribute(servletWebRequest, ProjectConstant.IMAGE_VALIDATE_CODE_IN_SESSION);
    }
}
