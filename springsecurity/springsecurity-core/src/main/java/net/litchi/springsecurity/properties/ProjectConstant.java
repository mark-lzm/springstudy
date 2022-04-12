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
     * 图片验证码生成的URL
     */
    public static final String  IMAGE_VALIDATE_CODE_GENERATE_URL= "/validate/image";

    /**
     * 默认图片验证码在session中的变量名
     */
    public static final String IMAGE_VALIDATE_CODE_IN_SESSION = "IMAGE_VALIDATE_CODE_IN_SESSION";
}
