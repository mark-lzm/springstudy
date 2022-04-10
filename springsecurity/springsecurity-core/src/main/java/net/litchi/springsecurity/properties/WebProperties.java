package net.litchi.springsecurity.properties;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/10 11:04
 */

import lombok.Data;

/**
 * 封装web相关的工程常量
 */
@Data
public class WebProperties {
    /**
     * 覆盖登录地址
     */
    private String loginPage = "/demo-signin.html";
    /**
     * 登录请求地址
     */
    private String loginProcessingUrl = "/authentication/form";
    /**
     * 登录表单用户名参数
     */
    private String usernameParm = "id";
    /**
     * 登录表单用密码参数
     */
    private String passwordParm = "password";
}
