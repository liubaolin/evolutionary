package top.evolutionary.securitydemo.validate.code.sms;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import top.evolutionary.securitydemo.properties.SecurityProperties;
import top.evolutionary.securitydemo.common.ValidCode;
import top.evolutionary.securitydemo.validate.code.ValidateCodeGenerator;

/**
 * @author richey
 */
@Component("smsValidateCodeGenerator")
public class SmsValidateCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidCode(code, securityProperties.getCode().getImage().getExpireIn());
    }

}
