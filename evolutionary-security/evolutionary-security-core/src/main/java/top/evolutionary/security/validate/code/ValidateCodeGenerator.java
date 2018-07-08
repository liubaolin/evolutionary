package top.evolutionary.security.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeGenerator {

    ValidCode generate(ServletWebRequest request);

}
