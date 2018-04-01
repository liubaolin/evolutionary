package richey.springaop.advisor;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import richey.springaop.entity.Waiter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {

    private static List<String> mockSpecialClientList = new ArrayList<>();

    static {
        mockSpecialClientList.add("richey");
        mockSpecialClientList.add("kelly");
    }

    /**
     * 这里重写静态检查，因为最好先做静态检查
     * 静态检查只会做一次（在Spring创建代理类的时候）
     * 如果静态检查不通过就不会继续进行动态检查了
     * 优化了动态检查效率低的问题（动态检查每次调用都会检查所以效率低）
     * @param method
     * @param targetClass
     * @return
     */
    @Override
    public boolean matches(Method method, Class targetClass) {
        System.out.println("调用Method method, Class targetClass)" + targetClass.getName() + "." + method.getName() + "做静态检查");
        return Waiter.class.isAssignableFrom(targetClass) && "greetTo".equals(method.getName());
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        System.out.println("调用matches(Method method, Class<?> targetClass, Object... args)" + targetClass.getName() + "." + method.getName() + "做动态检查");
        String clientName = (String) args[0];
        return mockSpecialClientList.contains(clientName);
    }
}
