package net.litchi.springsecurity.controller;

import lombok.AllArgsConstructor;
import net.litchi.springsecurity.service.UserService;
import net.litchi.springsecurity.util.JSONResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/6 20:53
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping
    public JSONResult getAllUser(){
        return JSONResult.ok(userService.queryAllUser());
    }
}
