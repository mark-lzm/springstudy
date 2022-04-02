package net.litchi.mybatis;

import net.litchi.spring.ioc.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.Date;
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
        List<User> selectAllUser = sqlSession.selectList("test.selectUserLikeName","mt");
        for (User user : selectAllUser) {
            System.out.println(user);
        }

/*        User user = new User("2311", "zm", new Date(), 'm', "zk", "123456", "13500000000");
        System.out.println(sqlSession.insert("insertUser", user));*/

        sqlSession.commit();
        sqlSession.close();
    }
}
