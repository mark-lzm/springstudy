package net.litchi.springsecurity.websecurity.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import net.litchi.springsecurity.enums.LoginType;
import net.litchi.springsecurity.properties.ProjectProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/12 18:47
 */

/**
 * 认证成功处理器，默认逻辑是跳转到之前的请求，比如用户输入 /user没有权限访问之后，跳转到/user请求，如果配置了登陆成功配置，可以自定义认证成功之后的跳转，
 * 比如说返回一个json形式的字符串，用在跨平台处理上面
 */
@Component
@AllArgsConstructor
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private ProjectProperties projectProperties;
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        if (projectProperties.getWeb().getLoginType().equals(LoginType.JSON)) {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(authentication));
        } else {
            super.onAuthenticationSuccess(request, response, chain, authentication);
        }
    }
}
