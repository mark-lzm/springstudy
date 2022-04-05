package net.litchi.springboot.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import net.litchi.springboot.pojo.User;
import net.litchi.springboot.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/5 10:16
 */
@RestController
@RequestMapping("/redis")
@AllArgsConstructor
public class RedisController {

    private RedisTemplate<String, String> redisTemplate;

    private ObjectMapper objectMapper;


    @GetMapping("/set")
    public void set() throws JsonProcessingException, IllegalAccessException {
        User zm = User.builder().id("zm").password("123456").username("zm123456").address("hh").birthday(new Date()).sex('m').build();
//        String s = objectMapper.writeValueAsString(zm);
//        redisTemplate.opsForValue().set("user:" + zm.getId(), s);


//        redisTemplate.opsForHash().put("user:123456", "username", zm.getUsername());

//        redisTemplate.opsForHash().putAll("user:123456", RedisUtil.getFieldAndValuesMap(zm));

        redisTemplate.opsForSet().add("set:1", "1", "12", "123", "1234");
        redisTemplate.opsForSet().add("set:2", "1", "12", "123", "1234","12345");


    }

    @GetMapping("/get")
    public User get() throws JsonProcessingException {
//        String o = (String) redisTemplate.opsForValue().get("user:zm");
//        User user = objectMapper.readValue(o, User.class);

//        Map<Object, Object> entries = redisTemplate.opsForHash().entries("user:123456");
//        entries.keySet().forEach(key -> {
//            System.out.println(key + " : " + entries.get(key));
//        });

        Set<String> union = redisTemplate.opsForSet().union("set:1", "set:2");
//        for (String s : union) {
//            System.out.println(s);
//        }
        Set<String> difference = redisTemplate.opsForSet().difference("set:2", "set:1");
//        for (String s : difference) {
//            System.out.println(s);
//        }
        Set<String> intersect = redisTemplate.opsForSet().intersect("set:2", "set:1");
        for (String s : intersect) {
            System.out.println(s);
        }
        return null;

    }

}
