package net.litchi.springsecurity.service.impl;

import lombok.AllArgsConstructor;
import net.litchi.springsecurity.mapper.UserMapper;
import net.litchi.springsecurity.pojo.User;
import net.litchi.springsecurity.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/6 20:56
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<User> queryAllUser() {
        return userMapper.selectAll();
    }
}
