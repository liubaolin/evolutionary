package top.evolutionary.securitydemo.properties;

/**
 * @author richey
 */
public class SocialProperties {

    private String filterProcessorUrl = "/auth";

    private QQProperties qq = new QQProperties();

    public QQProperties getQq() {
        return qq;
    }

    public void setQq(QQProperties qq) {
        this.qq = qq;
    }

    public String getFilterProcessorUrl() {
        return filterProcessorUrl;
    }

    public void setFilterProcessorUrl(String filterProcessorUrl) {
        this.filterProcessorUrl = filterProcessorUrl;
    }
}
