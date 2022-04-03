package net.litchi.springmvc.web.controller;

import lombok.AllArgsConstructor;
import net.litchi.springmvc.pojo.bo.TestBo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

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
@AllArgsConstructor
public class HelloController {

    /**
     *
     */
    private HttpServletRequest request;
    private HttpServletResponse response;

    @RequestMapping("/1")
    public void hello1() {
        System.out.println("hello1");
    }

    @RequestMapping("/2")
    public void hello2() {
        System.out.println("hello2");
    }

    @RequestMapping("/3")
    public void hello3() {
        /**
         * 1.使用request接收参数，接收的都是String类型
         */
        request.getParameterMap().keySet().forEach(key -> {
            System.out.println(key + " : " + request.getParameterMap().get(key));
        });
    }

    /**
     * 2.Spring接收参数，类型不对会报bug
     */
    @RequestMapping("/4")
    public void hello4(@RequestParam(name = "name", /*required = true,*/ defaultValue = "litchi") String username, String password, int age, double money,
                       String[] checkbox,
                       @RequestParam Map<String, String[]> params,
                       TestBo bo) {
        params.keySet().forEach(key -> {
            System.out.println(key + ":" + params.get(key));
        });

        System.out.println(bo);

//        System.out.println(checkbox);

        System.out.println(username);
        System.out.println(password);
        System.out.println(age);
        System.out.println(money);
    }


    @RequestMapping("/5")
    public String hello5() {
        System.out.println("5");
        //转发
        return "/index.html";
    }

    @RequestMapping("/6")
    public String hello6() {
        System.out.println("6");
        //重定向
        return "redirect:https://www.baidu.com";
    }

    @RequestMapping("/7")
    public String hello7(ModelMap modelMap) {
        modelMap.addAttribute("username", "12346");
//        return "index";
        //不过模板引擎
        return "foward:/WEB-INF/jsp/index.html";
    }

    @RequestMapping("/8")
    public ModelAndView hello8(ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username", "123456");
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
