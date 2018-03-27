package richey.springaop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕增强配置
 * 截获目标类方法的执行，并在前后添加横切逻辑
 */
public class EatInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] args = invocation.getArguments();
        String place = (String) args[0];
        System.out.println("到"+place+"吃饭前要洗手！");
        //通过反射机制调用目标方法
        Object obj = invocation.proceed();
        System.out.println("吃完饭后也要洗手哦~~");
        return obj;
    }
}
