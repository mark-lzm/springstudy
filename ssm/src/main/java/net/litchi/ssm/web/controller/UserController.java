package net.litchi.ssm.web.controller;

import lombok.AllArgsConstructor;
import net.litchi.ssm.mapper.UserMapper;
import net.litchi.ssm.pojo.po.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/3 16:24
 */

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserMapper userMapper;

    @GetMapping
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

}

