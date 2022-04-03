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
    public void selectAllUserByUserQueryVoTest() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(4);
        ids.add(5);
        ids.add(7);
        ids.add(103);

        UserQueryVo build = UserQueryVo.builder().ids(ids)
                .password("123456").build();

        userMapper.selectUserByQueryVo(build).forEach(System.out::println);
    }

    @Test
    public void selectAllUserAndOrdersTest(){
       /* userMapper.selectAllUserAndOrders().forEach(user -> {
            user.getOrders().forEach(orders -> {
                orders.getOrderDetails().forEach(orderDetail -> {
                    System.out.println(orderDetail.getItems());
                });
            });
        });*/
        userMapper.selectAllUserAndOrders();
        sqlSession.commit();
        sqlSession.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        /*当在不同的事务中调用同一条sql语句并且参数相同，中间没有执行flashcach操作的时候
        * 当第一次事务提交的之后，会将结果缓存到磁盘上*/
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        mapper2.selectAllUserAndOrders();
        sqlSession2.commit();
        sqlSession2.close();

        /*一级缓存*/
        /*中间执行了会修改数据库的sql语句，就会清空缓存*/
/*        User user = User.builder().id("104").build();
        userMapper.deleteUser(user);

        sqlSession.clearCache();*/

//        userMapper.selectAllUserAndOrders();

    }

    @Test
    public void getUserAndOrdersLazyLoad(){
        userMapper.getUserAndOrdersLazyLoad().forEach(user -> {
          /*  user.getOrders().forEach(orders -> {
                System.out.println(orders);
            });*/
            if(user.getId().equals("1")){
                user.getOrders().forEach(orders -> {
                    System.out.println(orders);
                });
            }
        });
    }
//    @After
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
