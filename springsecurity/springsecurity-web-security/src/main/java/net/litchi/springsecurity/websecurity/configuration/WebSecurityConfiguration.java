package net.litchi.springsecurity.websecurity.configuration;

import lombok.AllArgsConstructor;
import net.litchi.springsecurity.properties.ProjectConstant;
import net.litchi.springsecurity.properties.ProjectProperties;
import net.litchi.springsecurity.properties.WebProperties;
import net.litchi.springsecurity.validate.ValidateCodeFilter;
import net.litchi.springsecurity.websecurity.authentication.AuthenticationFailureHandler;
import net.litchi.springsecurity.websecurity.authentication.AuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 1.认证
 * 2.授权
 * 3.攻击防护
 *
 * @Description
 * @Author Mark
 * @Date 2022/4/7 20:20
 */

/**
 * 认证
 * 用户名密码、短信、邮件
 * 第三方
 * 记住我
 */
@Configuration
@AllArgsConstructor
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private ProjectProperties properties;
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    private AuthenticationFailureHandler authenticationFailureHandler;

    private ValidateCodeFilter validateCodeFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        WebProperties web = properties.getWeb();

        /**
         * 在访问用户密码登录之前，需要先访问验证码过滤器
         */
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
            .formLogin()//当前使用表单认证，之后的配置都是对表单登录模块的详细配置
                //修改登录页面，当用户没有权限的时候，往那里跳转  get
                .loginPage(ProjectConstant.UNAUTHORIZED_URL)
                //登录请求的访问路径 post
                .loginProcessingUrl(web.getLoginProcessingUrl())
                //登录表单用户名的参数名
                .usernameParameter(web.getUsernameParm())
                //登录表单用户名的密码
                .passwordParameter(web.getPasswordParm())
                //登录成功处理器  登录成功之后，默认跳转到第一次访问的路径
                .successHandler(authenticationSuccessHandler)
                //登录失败处理器  登录失败，默认跳转到loginPage
                .failureHandler(authenticationFailureHandler)
                //返回上级目录
                .and()
                //表示当前对授权模块进行配置
            .authorizeRequests()
                //当请求匹配到对应的地址
                .antMatchers(ProjectConstant.UNAUTHORIZED_URL,
                        ProjectConstant.IMAGE_VALIDATE_CODE_GENERATE_URL,
                        ProjectConstant.SMS_VALIDATE_CODE_GENERATE_URL,
                        web.getLoginPage(),
                        web.getLoginProcessingUrl(),
                        web.getMobileLoginProcessingUrl()
                )
                //允许请求放行
                .permitAll()
                //选中的所有请求
                .anyRequest()
                //都需要认证
                .authenticated()
                //返回上一层
                .and()
                //攻击防护
            .csrf()
                //暂时关闭
                .disable();


    }

}
