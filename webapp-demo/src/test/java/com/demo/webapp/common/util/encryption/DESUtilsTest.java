package com.demo.webapp.common.util.encryption;

import org.junit.Test;

public class DESUtilsTest {

    @Test
    public void testEncryptStr() {
        String encryptStr = DESUtils.getEncryptString("hello world");
        System.out.println(encryptStr);
    }

}