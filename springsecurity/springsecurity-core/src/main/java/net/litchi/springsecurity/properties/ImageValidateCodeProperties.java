package net.litchi.springsecurity.properties;

import lombok.Data;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/12 19:58
 */
@Data
public class ImageValidateCodeProperties {
    /**
     * 图片宽度
     */
    private Integer width = 67;

    /**
     * 图片高度
     */
    private Integer height = 23;

    /**
     * 验证码长度
     */
    private Integer length = 4;

    /**
     * 验证码过期时间
     */
    private Integer expiredIn = 15 * 60;

    /**
     * 图片验证码参数
     */
    private String paramName = "imageValidateCode";

}
