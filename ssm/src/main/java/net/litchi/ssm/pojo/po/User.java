package net.litchi.ssm.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/3 16:23
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
}
