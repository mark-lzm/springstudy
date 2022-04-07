package net.litchi.springsecurity.controller;

import lombok.AllArgsConstructor;
import net.litchi.springsecurity.service.NewService;
import net.litchi.springsecurity.util.JSONResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/6 21:12
 */
@RestController
@RequestMapping("/news")
@AllArgsConstructor
public class NewController {

    private NewService newService;


    /**
     * filter aop interceptor
     * @return
     */

    @GetMapping
    public JSONResult getNews(){
        return JSONResult.ok(newService.getNews());
    }
}
