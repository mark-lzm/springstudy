package net.litchi.springmvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 1.请求分发
 * 2.接收参数
 * 3、返回响应
 *
 * @Description
 * @Author Mark
 * @Date 2022/4/3 10:48
 */
@Controller
@RequestMapping("/hello")
public class HelloController{

    @RequestMapping("/1")
    public String hello1(){
        System.out.println("hello1");
        return "success";
    }

    @RequestMapping("/2")
    public void hello2(){
        System.out.println("hello2");
    }
}
