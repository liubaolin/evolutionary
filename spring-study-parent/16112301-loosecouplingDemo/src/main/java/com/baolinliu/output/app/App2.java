package com.baolinliu.output.app;

import com.baolinliu.output.OutputGenerator;
import com.baolinliu.output.helper.OutputHelper;

/**
 * Created by richey on 16-11-23.
 *
 */
public class App2 implements OutputGenerator{
    @Override
    public void generatorOutput() {
        OutputHelper outputHelper = new OutputHelper();
        outputHelper.generatorOutput();
    }
}
