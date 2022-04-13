package net.litchi.springsecurity.validate.processor;

import net.litchi.springsecurity.validate.code.ValidateCode;
import net.litchi.springsecurity.validate.generate.SmsValidateCodeGenerator;
import net.litchi.springsecurity.validate.sender.SmsValidateCodeSender;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/13 19:24
 */
@Component
public class SmsValidateCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {
    public static final String PROCESS_CODE_TYPE = "sms";

    @Autowired
    private SmsValidateCodeSender smsValidateCodeSender;

    @Override
    public boolean supportCodeType(String codeType) {
        return StringUtils.equals(PROCESS_CODE_TYPE, codeType);
    }

    @Override
    public void send(ValidateCode validateCode) throws IOException {
        smsValidateCodeSender.send(validateCode);
    }

    @Override
    Class getGenerateClass() {
        return SmsValidateCodeGenerator.class;
    }
}
