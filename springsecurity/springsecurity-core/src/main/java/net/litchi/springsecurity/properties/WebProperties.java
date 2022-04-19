package net.litchi.springsecurity.properties;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/10 11:04
 */

import lombok.Data;
import net.litchi.springsecurity.enums.LoginType;

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
    private String loginProcessingUrl = ProjectConstant.LOGIN_PROCESSING_URL;

    /**
     * 手机登录请求地址
     */
    private String mobileLoginProcessingUrl = ProjectConstant.MOBILE_LOGIN_PROCESSING_URL;
    /**
     * 登录表单用户名参数
     */
    private String usernameParm = "id";
    /**
     * 登录表单用密码参数
     */
    private String passwordParm = "password";
    /**
     * 登录方式，默认情况下，登录成功之后，行为重定向
     */
    private LoginType loginType = LoginType.REDIRACT;

    /**
     * token失效时间  默认7天
     */
    private int tokenValiditySeconds=60*60*24*7;
}
