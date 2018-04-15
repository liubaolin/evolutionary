package top.evolutionary.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootConfiguration
@RestController
public class DemoApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(DemoApplication.class, args);
    }
}
