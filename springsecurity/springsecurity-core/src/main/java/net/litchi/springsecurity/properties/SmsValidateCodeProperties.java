package net.litchi.springsecurity.properties;

import lombok.Data;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/13 18:43
 */
@Data
public class SmsValidateCodeProperties {

    /**
     * 验证码长度
     */
    private int length = 4;

    /**
     * 验证码过期时间
     */
    private int expireIn = 60 * 5 ;

    /**
     * 图片验证码参数
     */
    private String paramName = "smsValidateCode";

    /**
     *手机参数
     */
    private String mobileParaName = "mobile";

}
