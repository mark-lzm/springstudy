package net.litchi.springmvc.web.controller;

import net.litchi.springmvc.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/3 14:55
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id:\\w+}")
    public User getUserById(@PathVariable String id){
        System.out.println(id);
        return null;
    }

    @GetMapping
    public List<User> getAllUser(){
        return null;
    }

    @PostMapping
    public int insertUser(@RequestBody User user){
        System.out.println(user);
        return 0;
    }

    @DeleteMapping("/{id:\\w+}")
    public int deleteUserById(@PathVariable String id){
        System.out.println(id);
        return 0;
    }

    @PutMapping("/{id:\\w+}")
    public int updateUser(@RequestBody User user){
        return 0;
    }
}
