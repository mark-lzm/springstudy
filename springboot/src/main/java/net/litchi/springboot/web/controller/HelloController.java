package net.litchi.springboot.web.controller;

import net.litchi.springboot.mapper.UserMapper;
import net.litchi.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/4 9:44
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public String sayHello() {
        return "hello spring boot~";
    }

    /*thymeleaf  th:text*/
    @GetMapping("/templates")
    public String goTemplates() {
        return "/index.html";
    }


    @GetMapping("/user")
    @ResponseBody
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

}
