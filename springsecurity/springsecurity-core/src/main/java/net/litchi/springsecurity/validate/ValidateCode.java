package net.litchi.springsecurity.validate;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 验证码的父类
 * 短信 图片 邮箱
 *
 * @Description
 * @Author Mark
 * @Date 2022/4/12 19:46
 */
@Data
public class ValidateCode implements Serializable {
    /**
     * 验证码的值
     */
    private String code;

    /**
     * 有效时间
     */
    private LocalDateTime expireIn;

    /**
     * @param code
     * @param expireIn int 单位是秒 expireTime秒之后验证码失效
     */
    public ValidateCode(String code, int expireIn) {
        this.code = code;
        this.expireIn = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ValidateCode(String code, LocalDateTime expireIn) {
        this.code = code;
        this.expireIn = expireIn;
    }

    /**
     * 判断是否过期
     * @return
     */
    public Boolean isExpire() {
        return LocalDateTime.now().isAfter(this.expireIn);
    }

}
