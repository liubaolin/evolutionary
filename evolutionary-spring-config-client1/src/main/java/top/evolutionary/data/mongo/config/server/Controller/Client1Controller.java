package top.evolutionary.data.mongo.config.server.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author richey
 */
@RestController
public class Client1Controller {

    /*@Value("top.evolutionary.url")
    private String validateurl;*/

    @Autowired
    private Environment env;

    @GetMapping("/validateurl")
    public String config() {
        return env.getProperty("top.evolutionary.url", "underfined");
    }
}
