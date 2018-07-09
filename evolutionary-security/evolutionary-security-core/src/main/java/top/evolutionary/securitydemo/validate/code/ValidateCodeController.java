package top.evolutionary.securitydemo.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import top.evolutionary.securitydemo.validate.code.processor.ValidateCodeProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class ValidateCodeController {


    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessorMap;

    @GetMapping("/code/{type}")
    public void createImageCode(HttpServletRequest request, HttpServletResponse response, @PathVariable("type") String type) throws Exception {
        validateCodeProcessorMap.get(type + "ValidateCodeProcessor").create(new ServletWebRequest(request, response));
    }

}
