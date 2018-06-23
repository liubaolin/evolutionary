package richey.springaop.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 吃饭方法的前置增强类
 * @author richey
 */
public class EatBeforeAdvice implements MethodBeforeAdvice{

    /**
     * @param method  目标类的方法
     * @param args    目标类方法的参数
     * @param target  目标类
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        //在吃饭前我们织入洗手的逻辑
        String place = (String) args[0];
        System.out.println("到"+place+"吃饭前要先洗手哦~");
    }
}
