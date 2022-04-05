package net.litchi.springboot.web.controller;

import net.litchi.springboot.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/5 12:14
 */
@Controller
@RequestMapping("/thy")
public class ThymeleafController {

    @GetMapping("/1")
    public String showThymeleaf(ModelMap modelMap) {
        User zm = User.builder().id("zm").password("123456").username("zm123456")
                .address("hh").birthday(new Date()).sex('m').build();

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(User.builder().id("zm" + i).password("123456").username("zm123456")
                    .address("hh").birthday(new Date()).sex('m').build());
        }

        modelMap.addAttribute("desc", "<p style='color:red'>red content</p>");
        modelMap.addAttribute("username", new Date());
        modelMap.addAttribute("user", zm);
        modelMap.addAttribute("users", users);
        return "index";
    }

}
