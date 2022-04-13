package net.litchi.springsecurity.validate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.litchi.springsecurity.properties.ProjectConstant;
import net.litchi.springsecurity.properties.ProjectProperties;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 1.创建
 * 2.存储
 * 3.发送
 *
 * @Description
 * @Author Mark
 * @Date 2022/4/12 19:53
 */
@Controller
@AllArgsConstructor
@Slf4j
public class ValidateCodeController {

    private ProjectProperties properties;

    private SessionStrategy sessionStrategy;

    @GetMapping(ProjectConstant.IMAGE_VALIDATE_CODE_GENERATE_URL)
    public void getImageValidateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.创建图片验证码
        ImageValidateCode imageValidateCode = createImageCode();
        //2.将验证码储存到session
        sessionStrategy.setAttribute(new ServletWebRequest(request, response),
                ProjectConstant.IMAGE_VALIDATE_CODE_IN_SESSION,
                imageValidateCode);
        //3.响应验证码到前端
        ImageIO.write(imageValidateCode.getImage(),
                "JPEG",
                response.getOutputStream());
    }

    @GetMapping(ProjectConstant.SMS_VALIDATE_CODE_GENERATE_URL)
    public void getSmsValidateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.创建短信验证码
        String code = RandomStringUtils.randomNumeric(properties.getValidateCode().getSmsValidateCode().getLength());
        ValidateCode validateCode = new ValidateCode(code, properties.getValidateCode().getSmsValidateCode().getExpireIn());
        //2.将验证码储存到session
        sessionStrategy.setAttribute(new ServletWebRequest(request, response),
                ProjectConstant.SMS_VALIDATE_CODE_IN_SESSION,
                validateCode);
        //3.发送验证码
        log.debug("当前正在向手机号{}发送短信验证码{}", request.getParameter(properties.getValidateCode().getSmsValidateCode().getMobileParaName()), validateCode.getCode());

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

