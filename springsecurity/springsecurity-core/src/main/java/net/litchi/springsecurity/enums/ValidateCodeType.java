package net.litchi.springsecurity.enums;

import net.litchi.springsecurity.properties.ProjectConstant;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/13 21:35
 */
public enum ValidateCodeType {
    /**
     * 短信验证码
     */
    SMS {

        @Override
        public String getParamNameOnValidate() {
            return ProjectConstant.DEFAULT_PARAMETER_NAME_CODE_SMS;
        }

    },
    /**
     * 图片验证码
     */
    IMAGE {

        @Override
        public String getParamNameOnValidate() {
            return ProjectConstant.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }

    };

    /**
     * 校验时从请求中获取的参数的名字
     * @return
     */
    public abstract String getParamNameOnValidate();


}
