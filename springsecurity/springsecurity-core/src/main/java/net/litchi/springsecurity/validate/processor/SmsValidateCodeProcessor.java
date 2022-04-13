package net.litchi.springsecurity.validate.processor;

import net.litchi.springsecurity.properties.ProjectConstant;
import net.litchi.springsecurity.validate.code.ValidateCode;
import net.litchi.springsecurity.validate.exception.ValidateCodeException;
import net.litchi.springsecurity.validate.generate.SmsValidateCodeGenerator;
import net.litchi.springsecurity.validate.sender.SmsValidateCodeSender;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/13 19:24
 */
@Component
public class SmsValidateCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

    /**
     * 默认从请求中获取短信验证的参数
     */
    public static final String PROCESS_CODE_TYPE = "sms";

    /**
     * 默认验证手机登录
     */
    public static final String MOBILE_LOGIN_TYPE = "mobile";

    /**
     * 默认从请求中获取手机号的字段名，name
     */
    public static final String MOBILE_PARAM_NAME = "mobile";


    /**
     * 前端发送验证码的手机号
     */
    private String mobileNumber;


    @Autowired
    private SmsValidateCodeSender smsValidateCodeSender;

    @Override
    public boolean supportCodeType(String codeType) {
        return StringUtils.equals(PROCESS_CODE_TYPE, codeType);
    }

    @Override
    public boolean IsValidate(String type) {
        return StringUtils.equals(MOBILE_LOGIN_TYPE, type);
    }

    @Override
    public void send(ServletWebRequest request, ValidateCode validateCode) throws IOException, ServletRequestBindingException {
        //记住发送验证码的手机号
        mobileNumber = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), MOBILE_PARAM_NAME);

        smsValidateCodeSender.send(validateCode);
    }

    @Override
    void ValidateImpl(ServletWebRequest request) throws ServletRequestBindingException {
        //发送验证码的手机
        String sendValidateMobile = mobileNumber;

        //提交验证码的手机
        String summitValidateMobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(),
                MOBILE_PARAM_NAME);

        if (!StringUtils.equals(sendValidateMobile, summitValidateMobile)) {
            throw new ValidateCodeException("登录手机不符合");
        }
    }

    @Override
    Class getGenerateClass() {
        return SmsValidateCodeGenerator.class;
    }
}
