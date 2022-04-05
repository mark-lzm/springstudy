package net.litchi.springboot.web.controller;

import com.show.api.ShowApiRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import net.litchi.springboot.common.ProjectProperties;
import net.litchi.springboot.mapper.UserMapper;
import net.litchi.springboot.pojo.User;
import net.litchi.springboot.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/4 9:44
 */
@Controller
@RequestMapping("/hello")
@AllArgsConstructor
@Api(tags = "测试控制器")
public class HelloController {

    private UserMapper userMapper;
    private ProjectProperties properties;
/*
    @Value("${net.litchi.showapi.covid}")
    private String url;
    @Value("${net.litchi.showapi.appid}")
    private String appid;
    @Value("${net.litchi.showapi.appsecret}")
    private String appsecret;
*/


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


    @ApiOperation("按照restful风格增加用户")
    @PostMapping
    @ResponseBody
    public JSONResult insertUser(@RequestBody @ApiParam("传入对象本身") User user) {
        return JSONResult.ok("success");
    }

    @GetMapping("/covid")
    @ResponseBody
    public String getCovidData() {
//        return new ShowApiRequest(url, appid, appsecret).post();
        return new ShowApiRequest(properties.getShowapi().getCovid(),
                properties.getShowapi().getAppid(),
                properties.getShowapi().getAppsecret()).post();
    }

}
