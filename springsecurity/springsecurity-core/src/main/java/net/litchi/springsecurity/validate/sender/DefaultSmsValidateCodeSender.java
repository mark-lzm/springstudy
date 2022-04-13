package net.litchi.springsecurity.validate.sender;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.litchi.springsecurity.properties.ProjectProperties;
import net.litchi.springsecurity.validate.code.ValidateCode;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/13 20:36
 */
@Slf4j
@Data
public class DefaultSmsValidateCodeSender implements SmsValidateCodeSender {
    private HttpServletRequest request;
    private ProjectProperties projectProperties;

    @Override
    public void send(ValidateCode validateCode) {
        log.debug("当前正在向手机号{}发送短信验证码{}"
                , request.getParameter(projectProperties.getValidateCode().getSmsValidateCode().getMobileParaName())
                , validateCode.getCode());
    }
}
