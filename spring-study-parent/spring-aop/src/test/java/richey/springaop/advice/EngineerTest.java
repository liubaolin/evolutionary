package richey.springaop.advice;


import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import richey.springaop.advice.entity.Engineer;
import richey.springaop.advice.entity.People;

public class EngineerTest {


    @Test
    public void engineerEatBeforeWithProxyFactoryTest() {

        People targetObj = new Engineer();
        EatBeforeAdvice advice = new EatBeforeAdvice();
        /** Spring提供的代理工厂 */
        ProxyFactory proxyFactory = new ProxyFactory();

//        /** 指定对接口进行代理 */
//        proxyFactory.setInterfaces(targetObj.getClass().getInterfaces());
//        /** 启动优化代理方式 */
//        proxyFactory.setOptimize(true);

        /** 设置代理类的目标 */
        proxyFactory.setTarget(targetObj);

        /** 为代理类添加增强,可以添加多个增强 */
        proxyFactory.addAdvice(advice);

        /** 声场代理类实例 */
        People proxyObj = (People) proxyFactory.getProxy();
        proxyObj.eat("餐厅");
    }

    @Test
    public void engineerEatBeforeWithSpringConfig() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = (People) ctx.getBean("engineer");
        people.eat("酒店");
    }


    @Test
    public void engineerEatInterceptorTest() {

        People targetObj = new Engineer();
        EatInterceptor advice = new EatInterceptor();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(targetObj);
        proxyFactory.addAdvice(advice);
        People proxyObj = (People) proxyFactory.getProxy();
        proxyObj.eat("餐厅");
    }

    @Test
    public void engineerEatPerformanceMonitorTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = (People) ctx.getBean("peopleWithMonitor");
        people.eat("肯德基");
        //开启性能监控功能，实际并没有实现Monitorable接口，通过引介增强实现
        Monitorable monitorable = (Monitorable) people;
        monitorable.setMonitorActive(true);
        people.eat("麦当劳");
    }



}
