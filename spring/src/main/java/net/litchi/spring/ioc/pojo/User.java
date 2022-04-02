package net.litchi.spring.ioc.pojo;

import java.io.Serializable;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 9:33
 */

public class User implements Serializable {
    private String id;
    private String password;

    public int add(int a, int b) {
        return a + b;
    }

    public User() {

    }

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
