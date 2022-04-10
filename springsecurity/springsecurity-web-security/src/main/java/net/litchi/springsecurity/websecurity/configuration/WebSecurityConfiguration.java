package net.litchi.springsecurity.websecurity.configuration;

import lombok.AllArgsConstructor;
import net.litchi.springsecurity.properties.ProjectConstant;
import net.litchi.springsecurity.properties.ProjectProperties;
import net.litchi.springsecurity.properties.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        WebProperties web = properties.getWeb();
        http.formLogin()//当前使用表单认证，之后的配置都是对表单登录模块的详细配置
                //修改登录页面，当用户没有权限的时候，往那里跳转  get
                .loginPage(ProjectConstant.UNAUTHORIZED_URL)
                //登录请求的访问路径 post
                .loginProcessingUrl(web.getLoginProcessingUrl())
                //登录表单用户名的参数名
                .usernameParameter(web.getUsernameParm())
                //登录表单用户名的密码
                .passwordParameter(web.getPasswordParm())
                //登录成功处理器
//                .successHandler()
                //登录失败处理器
//                .failureHandler()
                //返回上级目录
                .and()
                //表示当前对授权模块进行配置
                .authorizeRequests()
                //当请求匹配到对应的地址
                .antMatchers(ProjectConstant.UNAUTHORIZED_URL, web.getLoginPage(), web.getLoginProcessingUrl())
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
