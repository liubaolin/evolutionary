package top.evolutionary.securitydemo.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 切面可以拿到真正处理请求的方法的参数等信息，却拿不到原始的http请求和响应信息
 */
//@Aspect
//@Component
public class TimeAspect {

    @Pointcut("execution(* top.evolutionary.securitydemo.web.controller.UserController.*(..))")
    public void userController() {

    }

    @Around("userController()")
    public Object handleControllerMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("time aspect start");
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("arg is :" + arg);
        }
        Long start = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        System.out.println("time aspect 耗时:" + (System.currentTimeMillis() - start));
        System.out.println("time aspect end");

        return object;
    }

}
