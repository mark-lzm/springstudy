package net.litchi.springmvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/3 14:36
 */

@Controller
@ResponseBody
@RequestMapping("/rest")
public class RestfulController {
    /*
     * restful API
     * 接口分发的地址规则，不一定要遵循restful
     * 但是，请求和响应一定要是json
     * get 查询操作  所有的操作都是对数据库资源的操作
     *    get /user  获取数据库中用户表所有记录
     *    get /user/{id}  表示获取用户表中主键为 id 的记录
     * post 增加操作
     *    post /user 对user增加一条记录
     * put 更新操作
     *    put /user/{id} 修改主键为id的用户
     * delete 删除操作
     *    delete /user/{id} 删除主键为id的用户
     *
     * */

    @GetMapping("/1")
//    @RequestMapping(method = RequestMethod.GET, value = "/1")
    public String sayHello() {
        return "hello";
    }


    @GetMapping("/2")
    public List<String> sayHello2() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            result.add(i+"");
        }

        return result ;
    }
}
