package top.evolutionary.security.properties;

public class SmsCodeProperties extends CodeProperties {
    public SmsCodeProperties() {
        setLength(6);
        setUrl("/authentication/mobile");
    }
}
