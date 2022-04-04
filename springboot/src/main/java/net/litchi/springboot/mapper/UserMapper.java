package net.litchi.springboot.mapper;

import net.litchi.springboot.pojo.User;

import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/4 10:18
 */
public interface UserMapper {
    List<User> getAllUser();

}
