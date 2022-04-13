package net.litchi.springsecurity.validate.generate;

import lombok.Data;
import net.litchi.springsecurity.properties.ProjectProperties;
import net.litchi.springsecurity.validate.code.ImageValidateCode;
import net.litchi.springsecurity.validate.code.ValidateCode;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @Description
 * @Author Mark
 * @Date 2022/4/13 20:08
 */
@Data
public class DefaultImageValidateCodeGeneratorImpl implements ImageValidateCodeGenerator {

    private ProjectProperties properties;

    @Override
    public ValidateCode generateValidateCode() {
        return createImageCode();
    }

    //创建图形二维码
    private ImageValidateCode createImageCode() {
        int width = properties.getValidateCode().getImageValidateCode().getWidth();
        int height = properties.getValidateCode().getImageValidateCode().getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();

        Random random = new Random();

        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }

        StringBuilder sRand = new StringBuilder();
        for (int i = 0; i < properties.getValidateCode().getImageValidateCode().getLength(); i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand.append(rand);
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 13 * i + 6, 16);
        }

        g.dispose();

        return new ImageValidateCode(sRand.toString(), properties.getValidateCode().getImageValidateCode().getExpiredIn(), image);
    }

    /**
     * 生成随机背景条纹
     *
     * @param fc 前景色
     * @param bc 背景色
     * @return RGB颜色
     */
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
