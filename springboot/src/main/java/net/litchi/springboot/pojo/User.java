package net.litchi.springboot.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/4 10:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ApiModel("用户的po对象，和数据库设计保持一致")
public class User implements Serializable {
    @ApiModelProperty("ID,必填")
    private String id;
    @ApiModelProperty("用户名,必填2-16位")
    private String username;
    private Date birthday;
    private Character sex;
    private String address;
    private String password;
    private String mobile;
}
