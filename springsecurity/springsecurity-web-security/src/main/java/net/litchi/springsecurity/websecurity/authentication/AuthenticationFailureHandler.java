package net.litchi.springsecurity.websecurity.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import net.litchi.springsecurity.enums.LoginType;
import net.litchi.springsecurity.properties.ProjectProperties;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/12 18:47
 */
@Component
@AllArgsConstructor
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private ProjectProperties projectProperties;
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (projectProperties.getWeb().getLoginType().equals(LoginType.JSON)) {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(exception));
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
