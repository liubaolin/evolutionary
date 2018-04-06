package richey.springaop.Aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import richey.springaop.Aspectj.entity.Singer;

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

    /**
     * 测试连接点参数绑定
     * 注意此处args(songName,times)中的songName和times名称必须和增强方法中的一致,但是顺序可以不一致
     * 但是匹配的时候以args中参数类型的顺序为准
     * @param times
     * @param songName
     */
    @Before("target(richey.springaop.Aspectj.entity.SuperSinger) && args(songName,times,..)")
    public void testBindJoinPointParams(int times,String songName) {
        System.out.println("songName:"+songName);
        System.out.println("times:" + times);
        System.out.println("---- testBindJoinPointParams end ----");
    }

    /**
     * 绑定被代理对象实例
     * @param singer
     */
    @Before("this(singer)")
    public void testBindProxyObj(Singer singer) {
        System.out.println("---- bindProxyObj start ----");
        System.out.println(singer.getClass().getName());
        System.out.println("---- bindProxyObj end ----");
    }



}

