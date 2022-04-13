package net.litchi.springsecurity.validate.processor;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/13 19:18
 */
public interface ValidateCodeProcessor {

    /**
     * 创建验证码的流程
     */
    void createValidateCode() throws IOException, ServletRequestBindingException;

    /**
     * 验证当前请求中存放的验证按与生成时存放在session中的验证码是否匹配。
     */
    void validate(ServletWebRequest request);

    /**
     * 判断当前验证码是否需要处理
     * @param codeType
     * @return
     */
    boolean supportCodeType(String codeType);

    /**
     * 判断当前验证码类型是否需要验证
     */
    boolean IsValidate(String type);

}
