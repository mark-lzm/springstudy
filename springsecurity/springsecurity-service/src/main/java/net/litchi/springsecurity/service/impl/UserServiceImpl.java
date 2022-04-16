package net.litchi.springsecurity.service.impl;

import lombok.AllArgsConstructor;
import net.litchi.springsecurity.mapper.UserMapper;
import net.litchi.springsecurity.pojo.User;
import net.litchi.springsecurity.properties.ProjectConstant;
import net.litchi.springsecurity.service.UserService;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
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

    private HttpServletRequest request;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<User> queryAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (request.getRequestURI().equals(ProjectConstant.MOBILE_LOGIN_PROCESSING_URL)) {
            Example example = new Example(User.class);
            example.createCriteria().andEqualTo("mobile", username);
            List<User> users = userMapper.selectByExample(example);
            if (users.size() != 0) {
                User user = users.get(0);
                UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, user.getPassword(),
                        true, true, true, true,
                                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN,ROLE_USER"));//权限列表设置
                return userDetails;
            }
        } else {
            Example example = new Example(User.class);
            example.createCriteria().andEqualTo("id", username);
            List<User> users = userMapper.selectByExample(example);
            if (users.size() != 0) {
                User user = users.get(0);
                UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, user.getPassword(),
                        true, true, true, true,
                                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN,ROLE_USER"));//权限列表设置
                return userDetails;
            }
        }
        throw new UsernameNotFoundException("username not found");
    }
}
