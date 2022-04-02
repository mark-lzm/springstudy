package net.litchi.mybatis;

import net.litchi.spring.ioc.pojo.User;
import net.litchi.spring.ioc.pojo.vo.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 15:37
 */
public class MybatisMain {
    public static void main(String[] args) throws IOException {

        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder()
                        .build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

       /* List<User> selectAllUser = sqlSession.selectList("test.selectAllUser");
        for (User user : selectAllUser) {
            System.out.println(user);
        }*/
        /*List<User> selectAllUser = sqlSession.selectList("test.selectUserLikeName","mt");
        for (User user : selectAllUser) {
            System.out.println(user);
        }*/

        /*User user = new User("2311", "zm", new Date(), 'm', "zk", "123456", "13500000000");
        System.out.println(sqlSession.insert("insertUserUuid", user));*/

       /*
       HashMap<String, String> params = new HashMap<>();
        params.put("username", "mt");
        params.put("password", "123456");
        */

        UserQueryVo vo = new UserQueryVo();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        UserQueryVo mt = UserQueryVo.builder().ids(integerList).build();

        System.out.println(mt);
      /*  vo.setUsername("mt");
        vo.setPassword("123456");

        List<User> users = sqlSession.selectList("selectUserByUserQueryVo", vo);
        for (User user1 : users) {
            System.out.println(user1);
        }*/
        sqlSession.commit();
        sqlSession.close();
    }
}
