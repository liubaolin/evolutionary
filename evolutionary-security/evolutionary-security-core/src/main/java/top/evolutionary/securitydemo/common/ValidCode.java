package top.evolutionary.securitydemo.common;

import java.time.LocalDateTime;

/**
 * @author richey
 * 验证码
 */
public class ValidCode {


    private String code;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    public ValidCode() {
    }

    public ValidCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    /**
     * @param code
     * @param expireIn 秒数，在x秒后过期
     */
    public ValidCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public boolean isExpired() {
        return this.expireTime == null || this.expireTime.isBefore(LocalDateTime.now());
    }
}
