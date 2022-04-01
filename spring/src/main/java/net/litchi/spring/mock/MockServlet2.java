package net.litchi.spring.mock;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/1 21:39
 */
public class MockServlet2 extends MockHttpServlet{
    @Override
    public void init() {
        System.out.println("init2");
    }

    @Override
    public void doService() {
        System.out.println("doService2");
    }

    @Override
    public void destroy() {
        System.out.println("destroy2");
    }
}
