package net.litchi.springsecurity.controller.validate;

import com.mysql.cj.log.Log;
import lombok.extern.slf4j.Slf4j;
import net.litchi.springsecurity.validate.code.ValidateCode;
import net.litchi.springsecurity.validate.generate.ImageValidateCodeGenerator;
import org.springframework.stereotype.Component;

/**
 * 图片验证码的生成，和短信的发送
 * @Description
 * @Author Mark
 * @Date 2022/4/17 9:54
 */
//@Component
@Slf4j
public class ImageValidateCodeGeneratorImpl implements ImageValidateCodeGenerator {
    @Override
    public ValidateCode generateValidateCode() {
        log.info("ImageValidateCodeGeneratorImpl");
        return null;
    }
}
