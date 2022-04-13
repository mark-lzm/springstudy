package net.litchi.springsecurity.validate.configuration;

import net.litchi.springsecurity.properties.ProjectProperties;
import net.litchi.springsecurity.validate.generate.DefaultImageValidateCodeGeneratorImpl;
import net.litchi.springsecurity.validate.generate.DefaultSmsValidateCodeGeneratorImpl;
import net.litchi.springsecurity.validate.generate.ImageValidateCodeGenerator;
import net.litchi.springsecurity.validate.generate.SmsValidateCodeGenerator;
import net.litchi.springsecurity.validate.sender.DefaultSmsValidateCodeSender;
import net.litchi.springsecurity.validate.sender.SmsValidateCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/13 20:27
 */
@Configuration
public class ValidateCodeConfiguration {

    @Autowired
    private ProjectProperties properties;

    @Autowired
    private HttpServletRequest request;

    @Bean
    @ConditionalOnMissingBean(value = ImageValidateCodeGenerator.class)
    public ImageValidateCodeGenerator imageValidateCodeGenerator() {
        DefaultImageValidateCodeGeneratorImpl defaultImageValidateCodeGenerator = new DefaultImageValidateCodeGeneratorImpl();
        defaultImageValidateCodeGenerator.setProperties(properties);
        return defaultImageValidateCodeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(value = SmsValidateCodeGenerator.class)
    public SmsValidateCodeGenerator smsValidateCodeGenerator() {
        DefaultSmsValidateCodeGeneratorImpl defaultSmsValidateCodeGeneratorImpl = new DefaultSmsValidateCodeGeneratorImpl();
        defaultSmsValidateCodeGeneratorImpl.setProperties(properties);
        return defaultSmsValidateCodeGeneratorImpl;
    }

    @Bean
    @ConditionalOnMissingBean(SmsValidateCodeSender.class)
    public SmsValidateCodeSender smsValidateCodeSender() {
        DefaultSmsValidateCodeSender defaultSmsValidateCodeSender = new DefaultSmsValidateCodeSender();
        defaultSmsValidateCodeSender.setProjectProperties(properties);
        defaultSmsValidateCodeSender.setRequest(request);
        return defaultSmsValidateCodeSender;
    }
}
