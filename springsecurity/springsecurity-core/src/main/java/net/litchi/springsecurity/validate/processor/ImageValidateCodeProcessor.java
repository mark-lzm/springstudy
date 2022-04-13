package net.litchi.springsecurity.validate.processor;

import net.litchi.springsecurity.validate.code.ImageValidateCode;
import net.litchi.springsecurity.validate.generate.ImageValidateCodeGenerator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public static final String PROCESS_CODE_TYPE = "image";

    @Autowired
    private HttpServletResponse response;

    @Override
    public boolean supportCodeType(String codeType) {
        return StringUtils.equals(PROCESS_CODE_TYPE, codeType);
    }

    @Override
    public void send(ImageValidateCode validateCode) throws IOException {
        ImageIO.write(validateCode.getImage(),
                "JPEG",
                response.getOutputStream());
    }

    @Override
    Class getGenerateClass() {
        return ImageValidateCodeGenerator.class;
    }
}
