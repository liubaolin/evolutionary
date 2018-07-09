package top.evolutionary.securitydemo.properties;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "evolutionary.google.kaptcha")
public class GoogleKapchaProperties {

    @Value("${evolutionary.google.kaptcha.border}")
    private String border = "yes";

    @Value("${evolutionary.google.kaptcha.border.color}")
    private String borderColor = "105,179,90";

    @Value("${evolutionary.google.kaptcha.textproducer.font.color}")
    private String textproducerFontColor = "blue";

    @Value("${evolutionary.google.kaptcha.textproducer.font.size}")
    private String textproducerFontSize = "45";

    @Value("${evolutionary.google.kaptcha.textproducer.char.length}")
    private String textproducerCharLength = "4";

    @Value("${evolutionary.google.kaptcha.textproducer.font.names}")
    private String textproducerFontName = "宋体,楷体,微软雅黑";

    @Value("${evolutionary.google.kaptcha.session.key}")
    private String sessionKey = "code";

    @Value("${evolutionary.google.kaptcha.image.width}")
    private String imageWidth = "125";

    @Value("${evolutionary.google.kaptcha.image.height}")
    private String imageHeight = "45";


    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getTextproducerFontColor() {
        return textproducerFontColor;
    }

    public void setTextproducerFontColor(String textproducerFontColor) {
        this.textproducerFontColor = textproducerFontColor;
    }

    public String getTextproducerFontSize() {
        return textproducerFontSize;
    }

    public void setTextproducerFontSize(String textproducerFontSize) {
        this.textproducerFontSize = textproducerFontSize;
    }

    public String getTextproducerCharLength() {
        return textproducerCharLength;
    }

    public void setTextproducerCharLength(String textproducerCharLength) {
        this.textproducerCharLength = textproducerCharLength;
    }

    public String getTextproducerFontName() {
        return textproducerFontName;
    }

    public void setTextproducerFontName(String textproducerFontName) {
        this.textproducerFontName = textproducerFontName;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(String imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(String imageHeight) {
        this.imageHeight = imageHeight;
    }
}
