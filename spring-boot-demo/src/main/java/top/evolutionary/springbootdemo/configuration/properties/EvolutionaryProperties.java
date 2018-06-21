package top.evolutionary.springbootdemo.configuration.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author richey
 */
@Component
@PropertySource("classpath:evolutionary.properties")
@ConfigurationProperties(prefix = "top")
public class EvolutionaryProperties {

    @Value("${top.evolutionary.blog.title}")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
