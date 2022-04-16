package net.litchi.springsecurity.authentication.sms;


import lombok.Data;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/16 21:20
 */
@Data
public class SmsAuthenticationProvider implements AuthenticationProvider {

    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsAuthenticationToken authenticationToken = (SmsAuthenticationToken) authentication;
        /**
         * 调用读取用户信息逻辑，这里注意，如果有多种登录方式，那么在获取信息的逻辑中应该判断当前是以什么逻辑登录的，或者在自己本身模块中配置登录认证逻辑
         */
        String mobile = (String) authentication.getPrincipal();
        UserDetails userDetails = userDetailsService.loadUserByUsername(mobile);

        if (userDetails == null) {
            throw new InternalAuthenticationServiceException("获取不到用户信息");
        }

        SmsAuthenticationToken authenticationTokenResult = new SmsAuthenticationToken(
                authenticationToken.getPrincipal(), authenticationToken.getCredentials(), userDetails.getAuthorities());

        authenticationTokenResult.setDetails(authentication.getDetails());

        return authenticationTokenResult;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return SmsAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
