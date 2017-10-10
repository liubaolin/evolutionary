package com.demo.webapp.common.util.encryption;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class DESUtils {

    //定义DES加密解密所用的密钥
    private static Key key;
    private static String KEY_STR = "myKey";

    static {
        try {
            KeyGenerator generator = KeyGenerator.getInstance("DES");  //密钥生成器
            generator.init(new SecureRandom(KEY_STR.getBytes()));      //初始化密钥生成器
            key = generator.generateKey();                             //生成密钥
            generator = null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对字符串进行加密，返回BASE64编码的加密字符串
     * @param str
     * @return
     */
    public static String getEncryptString(String str) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        try {
            byte[] strBytes = str.getBytes("UTF8");
            Cipher cipher = Cipher.getInstance("DES");              //Cipher完成加密或解密工作类
            cipher.init(Cipher.ENCRYPT_MODE, key);                  //对Cipher初始化，加密模式
            byte[] encryptStrBytes = cipher.doFinal(strBytes);      //加密数据
            return base64Encoder.encode(encryptStrBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 对BASE64编码的加密字符串进行解密，返回解密后的字符串
     * @param str
     * @return
     */
    public static String getDecryptStr(String str) {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        try {
            byte[] strByte = base64Decoder.decodeBuffer(str);
            Cipher cipher  = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptStrByte = cipher.doFinal(strByte);
            return new String(decryptStrByte, "UTF8");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
