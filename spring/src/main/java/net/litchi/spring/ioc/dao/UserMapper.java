package net.litchi.spring.ioc.dao;

import net.litchi.spring.ioc.pojo.User;
import net.litchi.spring.ioc.pojo.vo.UserQueryVo;

import java.util.HashMap;
import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 17:20
 */
public interface UserMapper {

    User selectUserById(String userId);

    List<User> selectAllUser();

    List<User> selectUserLikeName(String username);

    List<User> selectUserByHashMap(HashMap<String, String> params);

    List<User> selectUserByUserQueryVo(UserQueryVo vo);

    int insertUserUuid(User user);

    int updateUserByUserId(User user);

    int deleteUserByUserId(User user);


    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(User user);


    List<User> selectUserByQueryVo(UserQueryVo vo);
}
