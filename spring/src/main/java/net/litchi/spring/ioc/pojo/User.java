package net.litchi.spring.ioc.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/2 9:33
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class User implements Serializable {
    private String id;
    private String username;
    private Date birthday;
    private Character sex;
    private String address;
    private String password;
    private String mobile;

    private List<Orders> orders;

}
