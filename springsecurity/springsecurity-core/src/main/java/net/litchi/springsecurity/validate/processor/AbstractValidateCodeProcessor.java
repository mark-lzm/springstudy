package net.litchi.springsecurity.validate.processor;

import net.litchi.springsecurity.enums.ValidateCodeType;
import net.litchi.springsecurity.properties.ProjectConstant;
import net.litchi.springsecurity.validate.code.ValidateCode;
import net.litchi.springsecurity.validate.exception.ValidateCodeException;
import net.litchi.springsecurity.validate.generate.ValidateCodeGenerator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * 抽象出所有验证码的生成逻辑
 * 分为三步
 * 1.创建验证码 2.存储验证码 3.发送验证码
 * 发送验证码交由不同的实现类实现
 * 而创建验证码与存储验证码在抽象类中生成
 */

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/13 19:21
 */
public abstract class AbstractValidateCodeProcessor<T extends ValidateCode>
        implements ValidateCodeProcessor {

    @Autowired
    private SessionStrategy sessionStrategy;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private List<ValidateCodeGenerator> validateCodeGenerators;

    /**
     * 创建验证码
     * 生成，存放，发送到客户端三步
     */
    @Override
    public void createValidateCode() throws IOException, ServletRequestBindingException {

        T validateCode = generate();

        save(validateCode);

        send(new ServletWebRequest(request, response), validateCode);
    }

    /**
     * 生成校验码
     *
     * @return
     */
    public T generate() {
        for (ValidateCodeGenerator validateCodeGenerator : validateCodeGenerators) {
            if (getGenerateClass().isAssignableFrom(validateCodeGenerator.getClass())) {
                return (T) validateCodeGenerator.generateValidateCode();
            }
        }
        return null;
    }

    public void save(T validateCode) {
        sessionStrategy.setAttribute(new ServletWebRequest(request, response),
                ProjectConstant.VALIDATE_CODE_IN_SESSION,
                validateCode);
    }

    public abstract void send(ServletWebRequest request, T generate) throws IOException, ServletRequestBindingException;

    /**
     * 验证 -- 抽象类
     * 将相同的验证格式写在抽象类，不同的交由子类实现
     *
     * @param request
     */
    @Override
    public void validate(ServletWebRequest request) {

        ValidateCodeType codeType = getValidateCodeType(request);

        /**
         * 获取存在session中的验证码
         */
        ValidateCode codeInSession = (ValidateCode) sessionStrategy.getAttribute(request,
                ProjectConstant.VALIDATE_CODE_IN_SESSION);
        /**
         * 前端传回来的验证码
         */
        String codeInRequest;
        try {
            codeInRequest =
                    ServletRequestUtils.getStringParameter(request.getRequest(), codeType.getParamNameOnValidate());
        } catch (ServletRequestBindingException e) {
            throw new ValidateCodeException("获取验证码的值失败");
        }


        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException("验证码的值不能为空");
        }

        if (codeInSession == null) {
            throw new ValidateCodeException("验证码不存在");
        }

        if (codeInSession.isExpire()) {
            // 销毁验证码
            sessionStrategy.removeAttribute(request, ProjectConstant.VALIDATE_CODE_IN_SESSION);
            throw new ValidateCodeException("验证码已经过期");
        }

        if (!StringUtils.equals(codeInRequest, codeInSession.getCode())) {
            throw new ValidateCodeException("验证码不匹配");
        }


        try {
            ValidateImpl(request);
        } catch (ServletRequestBindingException e) {
            e.printStackTrace();
        }
        // 每次登录请求提交，不管成功没成功都刷新验证码
        sessionStrategy.removeAttribute(request, ProjectConstant.VALIDATE_CODE_IN_SESSION);
    }

    /**
     * 验证实现类
     */
    abstract void ValidateImpl(ServletWebRequest request) throws ServletRequestBindingException;

    /**
     * 获取生成类，由子类传到该类
     *
     * @return
     */
    abstract Class getGenerateClass();

    /**
     * 根据请求的url获取校验码的类型 实现类的在ValidateCodeProcessor之前的名字全大写
     *
     * @param request
     * @return
     */
    private ValidateCodeType getValidateCodeType(ServletWebRequest request) {
        String type = StringUtils.substringBefore(getClass().getSimpleName(), "ValidateCodeProcessor");
        return ValidateCodeType.valueOf(type.toUpperCase());
    }

}
