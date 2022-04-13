package net.litchi.springsecurity.validate.sender;

import net.litchi.springsecurity.validate.code.ValidateCode;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/13 20:36
 */
public interface ValidateCodeSender {
    void send(ValidateCode validateCode);
}
