package net.litchi.springsecurity.websecurity.configuration;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.litchi.springsecurity.properties.ProjectConstant;
import net.litchi.springsecurity.properties.ProjectProperties;
import net.litchi.springsecurity.util.JSONResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/10 11:17
 */
@RestController
@AllArgsConstructor
@Slf4j
public class WebLoginController {

    private ProjectProperties properties;
    private RequestCache requestCache;
    private RedirectStrategy redirectStrategy;


    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @GetMapping(ProjectConstant.UNAUTHORIZED_URL)
    public JSONResult requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {

        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String target = savedRequest.getRedirectUrl();
            log.debug("引发跳转请求的地址是" + target);
            if (StringUtils.endsWithIgnoreCase(target, ".html")) {
                redirectStrategy.sendRedirect(request, response, properties.getWeb().getLoginPage());
            }
        }
        return JSONResult.errorAuthorized("当前访问的请求没有权限，请引导用户到登录界面");
    }
}
