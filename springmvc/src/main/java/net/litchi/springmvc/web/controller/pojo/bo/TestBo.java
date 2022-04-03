package net.litchi.springmvc.web.controller.pojo.bo;

import lombok.Data;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/3 13:05
 */
@Data
public class TestBo {
    private String name;
    private String password;
    private Integer age;
    private Double money;
    private String address;
    private String mobile;
    private String[] checkbox;
}
