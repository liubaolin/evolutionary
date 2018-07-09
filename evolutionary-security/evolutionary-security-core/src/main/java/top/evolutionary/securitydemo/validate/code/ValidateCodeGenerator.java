package top.evolutionary.securitydemo.validate.code;

import org.springframework.web.context.request.ServletWebRequest;
import top.evolutionary.securitydemo.common.ValidCode;

/**
 * @author richey
 */
public interface ValidateCodeGenerator {

    ValidCode generate(ServletWebRequest request);

}
