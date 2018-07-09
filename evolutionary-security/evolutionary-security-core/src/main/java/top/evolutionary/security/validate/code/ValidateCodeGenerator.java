package top.evolutionary.security.validate.code;

import org.springframework.web.context.request.ServletWebRequest;
import top.evolutionary.security.common.ValidCode;

/**
 * @author richey
 */
public interface ValidateCodeGenerator {

    ValidCode generate(ServletWebRequest request);

}
