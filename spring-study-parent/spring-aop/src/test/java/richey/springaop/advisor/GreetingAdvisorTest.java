package richey.springaop.advisor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import richey.springaop.entity.Seller;
import richey.springaop.entity.Waiter;

public class GreetingAdvisorTest {

    @Test
    public void greetingADvisorTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller sellter = (Seller) ctx.getBean("sellter");

        waiter.greetTo("richey");
        waiter.serveTo("richey");
        sellter.greetTo("richey");

    }

}