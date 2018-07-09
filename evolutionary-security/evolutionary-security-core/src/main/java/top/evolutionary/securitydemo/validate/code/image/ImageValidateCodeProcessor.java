package top.evolutionary.securitydemo.validate.code.image;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import top.evolutionary.securitydemo.validate.code.processor.impl.AbstractValidateCodeProcessor;

import javax.imageio.ImageIO;

/**
 * 图片验证码处理器
 */
@Component("imageValidateCodeProcessor")
public class ImageValidateCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {


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
