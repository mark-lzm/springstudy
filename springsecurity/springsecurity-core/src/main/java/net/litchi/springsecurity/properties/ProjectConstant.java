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
     * 默认认证的URL前缀
     */
    public static final String AUTHENTICATION_URI = "/authentication";

    /**
     * 默认处理验证码的URL前缀
     * 会通过验证码过滤器
     */
    public static final String VALIDATE_CODE_GENERATE_URL = "/validate";

    /**
     * 默认验证码在session中的变量名
     */
    public static final String VALIDATE_CODE_IN_SESSION = "VALIDATE_CODE_IN_SESSION";


    /**
     * 默认从请求中获取图片验证码的字段名，name
     */
    public static final String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageValidateCode";
    /**
     * 默认从请求中获取短信验证码的字段名 name
     */
    public static final String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsValidateCode";


}
