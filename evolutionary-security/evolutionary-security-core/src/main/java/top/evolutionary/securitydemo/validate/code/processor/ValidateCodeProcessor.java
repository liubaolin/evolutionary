package top.evolutionary.securitydemo.validate.code.processor;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码处理器，封装不同校验码的处理逻辑
 */
public interface ValidateCodeProcessor {

    /**
     * 验证码放入Session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_IMAGE_CODE_";


    /**
     * 创建验证码
     *
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     * @param servletWebRequest
     */
    void validate(ServletWebRequest servletWebRequest);


}
