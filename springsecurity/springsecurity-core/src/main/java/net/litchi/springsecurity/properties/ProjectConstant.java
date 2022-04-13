package net.litchi.springsecurity.properties;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/10 11:19
 */

public class ProjectConstant {
    /**
     * 当用户没有访问权限的时候的响应
     */
    public static final String UNAUTHORIZED_URL = "/authentication/require";

    /**
     * 默认用户名密码登录请求处理URL
     */
    public static final String LOGIN_PROCESSING_URL = "/authentication/form";

    /**
     * 默认的手机登录请求处理URL
     */
    public static final String MOBILE_LOGIN_PROCESSING_URL = "/authentication/mobile";

    /**
     * 默认处理验证码的URL前缀
     * 会通过验证码过滤器
     */
    public static final String VALIDATE_CODE_GENERATE_URL = "/validate";

    /**
     * 默认验证码在session中的变量名
     */
    public static final String VALIDATE_CODE_IN_SESSION = "VALIDATE_CODE_IN_SESSION";


}
