package richey.springaop.Aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 通过Aspectj注解将PreGreetingAspect标识为一个切面
 * @author richey
 */
@Aspect
public class PreDriveAspect {

    //定义切点和增强逻辑
    @Before("execution(* drive(..))")
    public void beforeDrive() {
        System.out.println(" 开车前检查是否系安全带！");
    }
}
