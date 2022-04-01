package net.litchi.spring.ioc.web.servlet;

import net.litchi.spring.ioc.service.UserService;
import net.litchi.spring.mock.MockHttpServlet;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/1 23:04
 */
public class UserServlet extends MockHttpServlet {
    private UserService userService;

    @Override
    public void doService() {
        System.out.println("UserServlet");
        userService.doService();
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
