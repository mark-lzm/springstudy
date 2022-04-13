package net.litchi.springsecurity.validate.processor;

import net.litchi.springsecurity.validate.code.ValidateCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/13 19:24
 */
@Component
public class SmsValidateCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {
    public static final String PROCESS_CODE_TYPE = "sms";

    @Override
    public boolean supportCodeType(String codeType) {
        return StringUtils.equals(PROCESS_CODE_TYPE, codeType);
    }
}
