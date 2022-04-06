package net.litchi.springsecurity.service;

import net.litchi.springsecurity.pojo.User;
import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/6 20:56
 */
public interface UserService {
    public List<User> queryAllUser();
}
