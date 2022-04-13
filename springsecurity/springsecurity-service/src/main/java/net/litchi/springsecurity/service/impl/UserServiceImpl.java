package net.litchi.springsecurity.service.impl;

import lombok.AllArgsConstructor;
import net.litchi.springsecurity.mapper.UserMapper;
import net.litchi.springsecurity.pojo.User;
import net.litchi.springsecurity.service.UserService;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<User> queryAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectByPrimaryKey(username);

        System.out.println(passwordEncoder.encode("123456"));


        org.springframework.security.core.userdetails.User result = new org.springframework.security.core.userdetails.User(user.getId(), user.getPassword(),
                true, true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER,ROLE_ADMIN"));

        return result;
    }
}
