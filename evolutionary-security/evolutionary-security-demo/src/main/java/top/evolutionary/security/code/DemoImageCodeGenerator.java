package top.evolutionary.security.code;

import org.springframework.web.context.request.ServletWebRequest;
import top.evolutionary.security.validate.code.ImageCode;
import top.evolutionary.security.validate.code.ValidateCodeGenerator;

//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(ServletWebRequest request) {
        //todo
        System.out.println("更高级的图形验证码生成代码");
        return null;
    }
}
