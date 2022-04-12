package net.litchi.springsecurity.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/10 11:03
 */

/**
 * 封装工程中的常量，并且使常量与YML绑定一起
 */
@Configuration
@ConfigurationProperties(prefix = "net.litchi")
@Data
public class ProjectProperties {
    private WebProperties web = new WebProperties();
    private ValidateCodeProperties validateCode = new ValidateCodeProperties();
}
