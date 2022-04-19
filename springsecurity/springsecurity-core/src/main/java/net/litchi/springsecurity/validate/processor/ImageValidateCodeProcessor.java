package net.litchi.springsecurity.validate.processor;

import net.litchi.springsecurity.validate.code.ImageValidateCode;
import net.litchi.springsecurity.validate.generate.ImageValidateCodeGenerator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/13 19:24
 */
@Component
public class ImageValidateCodeProcessor extends AbstractValidateCodeProcessor<ImageValidateCode> {

    /**
     * 默认从请求中获取图片验证的参数
     */
    public static final String PROCESS_CODE_TYPE = "image";
    /**
     * 默认验证表单登录
     */
    public static final String FORM_LOGIN_TYPE = "form";

    @Autowired
    private HttpServletResponse response;

    @Override
    public boolean supportCodeType(String codeType) {
        return StringUtils.equals(PROCESS_CODE_TYPE, codeType);
    }

    @Override
    public boolean isValidate(String type) {
        return StringUtils.equals(FORM_LOGIN_TYPE, type);
    }

    @Override
    public void send(ServletWebRequest request, ImageValidateCode validateCode) throws IOException {
        ImageIO.write(validateCode.getImage(),
                "JPEG",
                response.getOutputStream());
    }

    @Override
    void ValidateImpl(ServletWebRequest request) throws ServletRequestBindingException {
        //空实现
    }

    @Override
    Class getGenerateClass() {
        return ImageValidateCodeGenerator.class;
    }
}
