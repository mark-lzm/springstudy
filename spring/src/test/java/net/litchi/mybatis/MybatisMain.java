package net.litchi.mybatis;

import net.litchi.spring.ioc.dao.UserMapper;
import net.litchi.spring.ioc.pojo.User;
import net.litchi.spring.ioc.pojo.vo.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;

import java.io.DataInput;
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
    private static SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;

    private UserMapper userMapper;

    @BeforeClass
    public static void init() throws IOException {
        sqlSessionFactory =
                new SqlSessionFactoryBuilder()
                        .build(Resources.getResourceAsStream("mybatis-config.xml"));

    }

    @Before
    public void beforeTest() {
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void selectAllUserTest() {
        userMapper.selectAllUser().forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    public void updateUserTest() {
        User build = User.builder()
                .id("1")
                .username("mt" + new Date()).build();
        userMapper.updateUser(build);
    }

    @Test
    public void deleteUserTest() {
        User build = User.builder()
                .id("102")
                .password("123456")
                .build();
        userMapper.deleteUser(build);
    }

    @Test
    public void selectAllUserByUserQueryVo() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(4);
        ids.add(5);
        ids.add(7);
        ids.add(103);

        UserQueryVo build = new UserQueryVo();
        build.setPassword("123456");
        build.setIds(ids);

        userMapper.selectUserByQueryVo(build).forEach(System.out::println);
    }

    @After
    public void afterTest() {
        sqlSession.commit();
        sqlSession.close();
    }


    @AfterClass
    public static void destroy() {

    }


    public static void main(String[] args) throws IOException {

 /*       SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder()
                        .build(Resources.getResourceAsStream("mybatis-config.xml"));

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        System.out.println(mapper);

        mapper.selectAllUser().forEach(key -> {
            System.out.println(key);
        });
*/
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

        /*UserQueryVo vo = new UserQueryVo();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        UserQueryVo mt = UserQueryVo.builder().ids(integerList).build();*/

//        System.out.println(mt);
      /*  vo.setUsername("mt");
        vo.setPassword("123456");

        List<User> users = sqlSession.selectList("selectUserByUserQueryVo", vo);
        for (User user1 : users) {
            System.out.println(user1);
        }*/
       /* sqlSession.commit();
        sqlSession.close();*/
    }
}
