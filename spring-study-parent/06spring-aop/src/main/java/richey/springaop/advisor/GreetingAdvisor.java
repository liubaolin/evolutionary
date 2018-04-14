package richey.springaop.advisor;

import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import richey.springaop.entity.Waiter;

import java.lang.reflect.Method;


/**
 * 静态方法匹配器切点定义的切面
 * @author richey
 */

public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return "greetTo".equals(method.getName()) && Waiter.class.isAssignableFrom(targetClass);
    }
}
