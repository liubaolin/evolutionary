package richey.springaop.advice;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import richey.springaop.proxy.PerformanceMonitor;


/**
 * 引介增强，为目标类提供接口方法的实现
 * @author richey
 */
public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {

    /**
     * 用ThreadLocal是因为active这个控制状态使代理类变成了非线程安全的状态
     */
    ThreadLocal<Boolean> monitorStatusMap = new ThreadLocal<>();

    @Override
    public void setMonitorActive(boolean active) {
        monitorStatusMap.set(active);
    }

    //拦截方法
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object obj = null;
        if (monitorStatusMap.get() != null && monitorStatusMap.get()) {
            PerformanceMonitor.begin(mi.getClass().getName() + "." + mi.getMethod().getName());
            obj = super.invoke(mi);
            PerformanceMonitor.end();
        }else{
            obj = super.invoke(mi);
        }
        return obj;
    }
}
