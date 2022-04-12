package net.litchi.springsecurity.validate;


import org.springframework.security.core.AuthenticationException;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/12 20:59
 */
public class ValidateCodeException extends AuthenticationException  {
    public ValidateCodeException(String msg) {
        super(msg);
    }
}
