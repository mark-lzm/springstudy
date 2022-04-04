package net.litchi.springboot.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/4 11:14
 */
@Configuration
@ConfigurationProperties(prefix = "net.litchi")
@Data
public class ProjectProperties {
    private ShowApiProperties showapi = new ShowApiProperties();
}
