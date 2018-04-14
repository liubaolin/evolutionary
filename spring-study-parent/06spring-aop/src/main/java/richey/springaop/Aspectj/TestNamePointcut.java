package richey.springaop.Aspectj;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 命名切点
 */
public class TestNamePointcut {

    /**
     * 名字为inPackage的切点，修饰符是private所以指定在本类中使用
     */
    @Pointcut("within(richey.springaop.Aspectj..*)")
    private void inPackage() {}


    /**
     * 名字为sing的切点
     */
    @Pointcut("execution(* sing(..))")
    public void sing() {

    }


    @Pointcut("inPackage() && sing()")
    public void inPackageSing() {

    }

}
