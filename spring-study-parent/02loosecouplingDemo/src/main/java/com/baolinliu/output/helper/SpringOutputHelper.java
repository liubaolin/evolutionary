package com.baolinliu.output.helper;

import com.baolinliu.output.OutputGenerator;

/**
 * Created by richey on 16-12-1.
 *
 */
public class SpringOutputHelper {
    OutputGenerator outputGenerator;

    /**
     * 通过Spring的依赖注入(DI),助手类中不需要真正的实现,不产生耦合
      */
    public void generateOutput(){
        outputGenerator.generatorOutput();
    }

    public void setOutputGenerator(OutputGenerator outputGenerator) {
        this.outputGenerator = outputGenerator;
    }



}
