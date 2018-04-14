package com.baolinliu.output.app;

import com.baolinliu.output.impl.JsonOutputGenerator;

/**
 * Created by richey on 16-11-23.
 * 直接调用
 */
public class App1 {
    public static void main(String[] args) {
        JsonOutputGenerator jsonOutputGenerator = new JsonOutputGenerator();
        jsonOutputGenerator.generatorOutput();
    }
}
