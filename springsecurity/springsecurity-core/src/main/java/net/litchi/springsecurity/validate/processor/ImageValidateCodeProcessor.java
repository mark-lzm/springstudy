package net.litchi.springsecurity.validate.processor;

import net.litchi.springsecurity.validate.code.ImageValidateCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/13 19:24
 */
@Component
public class ImageValidateCodeProcessor extends AbstractValidateCodeProcessor<ImageValidateCode> {

    public static final String PROCESS_CODE_TYPE = "image";

    @Override
    public boolean supportCodeType(String codeType) {
        return StringUtils.equals(PROCESS_CODE_TYPE, codeType);
    }
}
