package net.litchi.springsecurity.validate;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/12 19:51
 */
@Data
public class ImageValidateCode extends ValidateCode {
    private BufferedImage image;

    public ImageValidateCode(String code, int expireIn, BufferedImage image) {
        super(code, expireIn);
        this.image = image;
    }

    public ImageValidateCode(String code, LocalDateTime expireIn, BufferedImage image) {
        super(code, expireIn);
        this.image = image;
    }

}
