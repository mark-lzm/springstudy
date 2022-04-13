package net.litchi.springsecurity.validate.generate;

import lombok.Data;
import net.litchi.springsecurity.properties.ProjectProperties;
import net.litchi.springsecurity.validate.code.ValidateCode;
import org.apache.commons.lang.RandomStringUtils;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/13 20:11
 */
@Data
public class DefaultSmsValidateCodeGeneratorImpl implements SmsValidateCodeGenerator {

    private ProjectProperties properties;

    @Override
    public ValidateCode generateValidateCode() {
        String code = RandomStringUtils.randomNumeric(properties.getValidateCode().getSmsValidateCode().getLength());
        return new ValidateCode(code, properties.getValidateCode().getSmsValidateCode().getExpireIn());
    }
}
