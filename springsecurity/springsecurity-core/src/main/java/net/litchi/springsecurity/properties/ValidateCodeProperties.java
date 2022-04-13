package net.litchi.springsecurity.properties;

import lombok.Data;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/12 19:57
 */
@Data
public class ValidateCodeProperties {
    ImageValidateCodeProperties imageValidateCode = new ImageValidateCodeProperties();
    SmsValidateCodeProperties smsValidateCode = new SmsValidateCodeProperties();
}
