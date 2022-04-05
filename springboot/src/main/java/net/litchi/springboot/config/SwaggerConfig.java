package net.litchi.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.util.ListUtils;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/5 15:08
 */
//@Configuration
public class SwaggerConfig {

   /* @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.litchi"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("springboot",
                "springboot demo ",
                "1.0",
                "https://www.baidu.com",
                new Contact("mt", "https://www.baidu.com", "2218692345@qq.com"),
                "Apache-2.0",
                "https://www.apache.org/licenses/LICENSE-2.0.txt",
                new ArrayList<>());
    }*/
}
