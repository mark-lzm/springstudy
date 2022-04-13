package net.litchi.springsecurity.validate.processor;

import net.litchi.springsecurity.validate.code.ValidateCode;

/**
 *
 * @Description
 * @Author Mark
 * @Date 2022/4/13 19:21
 */
public abstract class AbstractValidateCodeProcessor<T extends ValidateCode>
        implements ValidateCodeProcessor{

    /**
     * 创建验证码
     * 生成，存放，发送到客户端三步
     */
    @Override
    public void createValidateCode() {
        T validateCode = generate();
        save(validateCode);
        send(validateCode);
    }

    public T generate(){
        return null;
    }

    public void save(T validateCode){

    }

    public void send(T validateCode){

    }

    @Override
    public void validate() {

    }

}
