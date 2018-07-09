package top.evolutionary.securitydemo.validate.code.sms;

public interface SmsCodeSender {

    void send(String mobile, String code);

}
