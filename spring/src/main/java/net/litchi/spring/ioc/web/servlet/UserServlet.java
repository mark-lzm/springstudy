package net.litchi.spring.ioc.web.servlet;

import net.litchi.spring.ioc.service.UserService;
import net.litchi.spring.mock.MockHttpServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Mark
 * @Controller
 * @Service
 * @Repository
 * @Componet
 * @Configuration  IOC控制反转
 *
 * 都是把当前类注册到容器中
 * 并且都以类名首字母小写其余不变作为名字
 *
 *
 *
 *
 *     //@Resource(name = "userServiceImpl2")
 *
 *     @Autowired
 *     @Qualifier("userServiceImpl")
 *     private UserService userService;
 *
 *     都是自动注入，首先按照类匹配，查看容器中对应的类是否有且一个子类，如果是
 *     如果不是，看成员变量名字是否和容器中某个子类相同
 *     如果都不是，那么需要Resource或者    Qualifier和Autowired
 *
 * @Date 2022/4/1 23:04
 */
@Controller
public class UserServlet extends MockHttpServlet {

    //@Resource
    //private UserService userServiceImpl;

    //DI依赖注入
    //1
//    @Resource(name = "userServiceImpl2")
    //2
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;


    @Override
    public void doService() {
        System.out.println("UserServlet");
        userService.doService();
    }

}
