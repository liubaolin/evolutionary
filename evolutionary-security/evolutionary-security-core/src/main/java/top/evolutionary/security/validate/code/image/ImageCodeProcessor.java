package top.evolutionary.security.validate.code.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import top.evolutionary.security.validate.code.impl.AbstractValidateCodeProcessor;
import top.evolutionary.security.validate.code.sms.SmsCodeSender;

import javax.imageio.ImageIO;

/**
 * 图片验证码处理器
 */
@Component("imageCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {



    /**
     * 发送图片验证码，将其写在响应中
     *
     * @param request
     * @param imageCode
     * @throws Exception
     */
    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());

    }
}
