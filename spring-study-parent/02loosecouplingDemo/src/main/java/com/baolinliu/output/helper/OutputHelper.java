package com.baolinliu.output.helper;

import com.baolinliu.output.OutputGenerator;
import com.baolinliu.output.impl.JsonOutputGenerator;

/**
 * Created by richey on 16-11-23.
 * 输出生成器的助手类
 */
public class OutputHelper {
    OutputGenerator outputGenerator;

    /**
     * JsonOutputGenerator跟助手类产生了耦合
     */
    public OutputHelper(){
        this.outputGenerator = new JsonOutputGenerator();
    }

    public void generatorOutput(){
        outputGenerator.generatorOutput();
    }
}
