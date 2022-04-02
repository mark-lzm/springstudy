package net.litchi.mybatis;

import net.litchi.spring.ioc.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
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

        List<User> selectAllUser = sqlSession.selectList("selectAllUser");
        for (User user : selectAllUser) {
            System.out.println(user.getId());
        }

    }
}
