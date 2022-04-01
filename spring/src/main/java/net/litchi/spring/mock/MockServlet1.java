package net.litchi.spring.mock;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/1 21:39
 */
public class MockServlet1 extends MockHttpServlet{
    private int age;
    private String name;
    private List<Integer> ids;
    private MockHttpServlet mockHttpServlet;
    private Map<String, MockHttpServlet> httpServletMap;

    public MockServlet1() {
    }

    public MockServlet1(int age, String name, List<Integer> ids, MockHttpServlet mockHttpServlet, Map<String, MockHttpServlet> httpServletMap) {
        this.age = age;
        this.name = name;
        this.ids = ids;
        this.mockHttpServlet = mockHttpServlet;
        this.httpServletMap = httpServletMap;
    }

    @Override
    public void init() {
        System.out.println("init");
    }

    @Override
    public void doService() {
        System.out.println("doService");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public MockHttpServlet getMockHttpServlet() {
        return mockHttpServlet;
    }

    public void setMockHttpServlet(MockHttpServlet mockHttpServlet) {
        this.mockHttpServlet = mockHttpServlet;
    }

    public Map<String, MockHttpServlet> getHttpServletMap() {
        return httpServletMap;
    }

    public void setHttpServletMap(Map<String, MockHttpServlet> httpServletMap) {
        this.httpServletMap = httpServletMap;
    }
}
