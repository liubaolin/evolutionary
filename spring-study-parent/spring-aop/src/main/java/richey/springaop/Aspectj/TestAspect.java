package richey.springaop.Aspectj;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 切点函数示例
 * @author richey
 */
@Aspect
public class TestAspect {

    /**
     * 测试 @annotation
     */
    @AfterReturning("@annotation(richey.springaop.Aspectj.NeedTest)")
    public void testAnnotationFun() {
        System.out.println(" testAnnotationFun() executed!");
    }

    /**
     * 测试复合切点
     */
    @Before("within(richey.springaop.Aspectj.entity.*) && execution(void songWriting(..))")
    public void testFun() {
        System.out.println("通过复合切点表达式定位切点");
    }



}

