package richey.springaop.Aspectj;

import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import richey.springaop.Aspectj.entity.Driver;

public class PreDriveAspectTest {

    //通过编程的方式织入切面
    @Test
    public void beforeDriveTest() {
        Driver target = new Driver();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        //设置目标对象
        factory.setTarget(target);
        //添加切面类
        factory.addAspect(PreDriveAspect.class);
        //生成织入切面的代理对象
        Driver proxy = factory.getProxy();
        proxy.drive();

    }

    /**
     * 通过配置的方式，自动将@AspectJ注解的切面织入到目标Bean中
     */
    @Test
    public void beforeDriveConfigTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Driver driver = (Driver) ctx.getBean("driver");
        driver.drive();

    }


}