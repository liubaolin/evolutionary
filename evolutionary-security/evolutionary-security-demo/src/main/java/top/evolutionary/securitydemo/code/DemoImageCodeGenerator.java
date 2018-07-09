package top.evolutionary.securitydemo.code;

import org.springframework.web.context.request.ServletWebRequest;
import top.evolutionary.securitydemo.validate.code.image.ImageCode;
import top.evolutionary.securitydemo.validate.code.ValidateCodeGenerator;

//@Component("imageValidateCodeGeneratorss")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(ServletWebRequest request) {
        //todo
        System.out.println("更高级的图形验证码生成代码");
        return null;
    }
}
