package net.litchi.springsecurity.validate.generate;

import net.litchi.springsecurity.validate.code.ValidateCode;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/13 20:07
 */
public interface ValidateCodeGenerator {
    ValidateCode generateValidateCode();
}
