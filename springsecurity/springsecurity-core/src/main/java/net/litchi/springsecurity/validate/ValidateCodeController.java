package net.litchi.springsecurity.validate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.litchi.springsecurity.properties.ProjectConstant;
import net.litchi.springsecurity.properties.ProjectProperties;
import net.litchi.springsecurity.validate.code.ImageValidateCode;
import net.litchi.springsecurity.validate.processor.ValidateCodeProcessor;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * 1.创建
 * 2.存储
 * 3.发送
 * 4.验证
 *
 * @Description
 * @Author Mark
 * @Date 2022/4/12 19:53
 */
@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping(ProjectConstant.VALIDATE_CODE_GENERATE_URL)
public class ValidateCodeController {

    private ProjectProperties properties;
    private SessionStrategy sessionStrategy;
    private List<ValidateCodeProcessor> validateCodeProcessors;

    @GetMapping("/{codeType}")
    public void getValidateCode(@PathVariable String codeType, HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.debug("当前验证码的类型是{}", codeType);
        for (ValidateCodeProcessor validateCodeProcessor : validateCodeProcessors) {
            if(validateCodeProcessor.supportCodeType(codeType)){
                validateCodeProcessor.createValidateCode();
            }
        }

    }

}

