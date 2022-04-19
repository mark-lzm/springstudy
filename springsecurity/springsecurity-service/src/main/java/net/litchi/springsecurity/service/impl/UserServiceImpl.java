package net.litchi.springsecurity.service.impl;

import lombok.AllArgsConstructor;
import net.litchi.springsecurity.mapper.UserMapper;
import net.litchi.springsecurity.pojo.User;
import net.litchi.springsecurity.properties.ProjectConstant;
import net.litchi.springsecurity.service.UserService;
import org.apache.commons.lang.StringUtils;
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


        //表单登录 -> id 记住我 -> token中的username(id)  手机号 -> mobile

        org.springframework.security.core.userdetails.User result = null;
        User user = null;

        //判断是否用手机号查询
        if (StringUtils.equals(ProjectConstant.MOBILE_LOGIN_PROCESSING_URL, request.getRequestURI())) {
            User queryUser = new User();
            queryUser.setMobile(username);
            user = userMapper.selectOne(queryUser);
        } else {
            //其他均为直接传username(id)  -- 考虑remember-me情况
            user = userMapper.selectByPrimaryKey(username);
        }

        //传入id，否则remember-me调用的时候报bug
        result = new org.springframework.security.core.userdetails.User(user.getId(), user.getPassword(),
                true, true, true, true,
                //权限列表设置
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN,ROLE_USER"));
        return result;
    }
}
