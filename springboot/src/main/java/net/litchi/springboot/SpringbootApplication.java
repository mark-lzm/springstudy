package net.litchi.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@ComponentScan(basePackages = {"net.litchi"})
@MapperScan("net.litchi.**.mapper")
/*开启作业调度  单机使用 单服务器 （主备）*/
@EnableScheduling

/*引入Swagger2*/
//@EnableSwagger2

/*引入Knife4j*/
//@EnableSwagger2WebMvc

/*引入Swagger3*/
@EnableOpenApi

/*开启异步任务*/
@EnableAsync
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
