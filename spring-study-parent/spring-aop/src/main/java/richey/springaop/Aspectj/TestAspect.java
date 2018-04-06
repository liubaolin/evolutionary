package richey.springaop.Aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 切点函数示例
 *
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

    /**
     * 测试使用命名测点
     */
    @After("richey.springaop.Aspectj.TestNamePointcut.sing()")
    public void testNamePointcut() {
        System.out.println("这是通过命名切点匹配的增强逻辑");
    }

    @Around("execution(* singSomeSong(String))")
    public void testGetJoinpointInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("args[0]:" + proceedingJoinPoint.getArgs()[0]);
        ;
        System.out.println("signature:" + proceedingJoinPoint.getSignature().getClass());
        proceedingJoinPoint.proceed();
        System.out.println("---- testGetJoinpointInfo end ----");
    }


}

