package net.litchi.spring.mock;

import net.litchi.spring.ioc.service.AccountService;
import net.litchi.spring.ioc.web.servlet.UserServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/1 21:30
 */
public class MockTomcat {

    //    http://node01-slave:tomcat/foodie-center/index/carousel
    /*
     web.xml

     indexServlet extend httpServlet

    hashMap<String,HttpServlet> servletMap;
    servletMap.put(servlet-name,servlet-class);

     hashMap<String,String> urlMap;
     urlMap.put("url","servlet-name");

     httpRequest = getHttp();
     httpRequest.geturi();
   String  currentServletName= urlMap.get(httpRequest);
  currentServlet=   (HttpServlet)  servletMap.get( currentServletName);
     if(currentServlet!=null){
        调用对应的处理方法
     }else{
        创建出当前servlet init（）
        如果init也失败了
        将创建成功的servlet放入到servletmap
        doservice
     }

     (httpServlet) currentServlet = (httpServlet) indexServlet;
     currentServlet.doget

     <servlet>
        <servlet-name>indexServlet</servlet-name>
        <servlet-class>net.seehope.xxx.indexServlet</servlet-class>
     </servlet>
     <servlet-mapping>
        <servlet-name>indexServlet</servlet-name>
        <url>/index/*</url>
     </servlet-mapping>
     */

    public static void main(String[] args) {
        //创建Spring IoC容器，并根据配置文件在容器中实例化对象
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServlet userServlet = (UserServlet) context.getBean("userServlet");
//        userServlet.doService();

        AccountService accountServiceImpl = (AccountService) context.getBean("accountServiceImpl");
        accountServiceImpl.transferTx(1, 2, 10);


     /*   MockServlet1 mockServlet1 = (MockServlet1) context.getBean("mockServlet1");

        System.out.println(mockServlet1.getAge());
        System.out.println(mockServlet1.getName());
        System.out.println(mockServlet1.getMockHttpServlet());
        mockServlet1.getMockHttpServlet().doService();

        List<Integer> ids = mockServlet1.getIds();
        for (Integer id : ids) {
            System.out.println(id);
        }

        mockServlet1.getIds().forEach(key -> {
            System.out.println(key);
        });
        mockServlet1.getHttpServletMap().keySet().forEach(key -> {
            System.out.println(key);
        });

        MockHttpServlet mockServlet2 = (MockHttpServlet) context.getBean("mockServlet2");
        mockServlet2.doService();

        //获取MockHttpServlet的所有子类
        Map<String, MockHttpServlet> beansOfType = context.getBeansOfType(MockHttpServlet.class);
        beansOfType.keySet().forEach(key -> {
            System.out.println(key);
        });

        //获取某个注解是所有类
        //context.getBeansWithAnnotation()


        System.out.println("----------------------------------");
        //获取容器内所有beanId数组
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
            System.out.println("类型：" + context.getBean(beanName).getClass().getName());
            System.out.println("内容：" + context.getBean(beanName).toString());
        }

        //调用销毁
        ((ClassPathXmlApplicationContext) context).registerShutdownHook();
*/
    }
}

