package top.evolutionary.security.validate.code.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;
import top.evolutionary.security.validate.code.ValidCode;
import top.evolutionary.security.validate.code.ValidateCodeGenerator;
import top.evolutionary.security.validate.code.ValidateCodeProcessor;

import java.util.Map;

public abstract class AbstractValidateCodeProcessor<C extends ValidCode> implements ValidateCodeProcessor {

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    /**
     * 依赖搜索
     * 收集所有{@link ValidateCodeGenerator}接口的实现，key为bean的名字
     */
    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGeneratorMap;

    @Override
    public void create(ServletWebRequest request) throws Exception {
        C validateCode = generate(request);
        save(request, validateCode);
        send(request, validateCode);
    }

    /**
     * 发送验证码，由子类实现
     * @param request
     * @param validateCode
     * @throws Exception
     */
    protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;

    /**
     * 保存验证码
     *
     * @param request
     * @param validateCode
     */
    private void save(ServletWebRequest request, C validateCode) {
        sessionStrategy.setAttribute(request, SESSION_KEY_PREFIX + getProcessType(request).toUpperCase(), validateCode);
    }

    /**
     * 生成验证码
     *
     * @param request
     * @return
     */
    private C generate(ServletWebRequest request) {
        String type = getProcessType(request);
        ValidateCodeGenerator validateCodeGenerator = validateCodeGeneratorMap.get(type + "CodeGenerator");
        return (C) validateCodeGenerator.generate(request);
    }

    /**
     * 根据请求url获取验证码的类型
     *
     * @param request
     * @return
     */
    private String getProcessType(ServletWebRequest request) {
        return StringUtils.substringAfter(request.getRequest().getRequestURI(), "/code/");
    }
}
