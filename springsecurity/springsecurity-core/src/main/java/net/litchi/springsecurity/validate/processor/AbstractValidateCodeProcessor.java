package net.litchi.springsecurity.validate.processor;

import lombok.AllArgsConstructor;
import net.litchi.springsecurity.properties.ProjectConstant;
import net.litchi.springsecurity.validate.code.ValidateCode;
import net.litchi.springsecurity.validate.generate.ValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.SessionStrategy;
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
    public void createValidateCode() throws IOException {

        T validateCode = generate();

        save(validateCode);

        send(validateCode);
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

    public abstract void send(T generate) throws IOException;

    @Override
    public void validate() {

    }


    /**
     * 获取生成类，由子类传到该类
     *
     * @return
     */
    abstract Class getGenerateClass();

}
