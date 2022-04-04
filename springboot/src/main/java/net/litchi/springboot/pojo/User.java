package net.litchi.springboot.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/4 10:23
 */
@Data
public class User implements Serializable {
    private String id;
    private String username;
    private Date birthday;
    private Character sex;
    private String address;
    private String password;
    private String mobile;
}
