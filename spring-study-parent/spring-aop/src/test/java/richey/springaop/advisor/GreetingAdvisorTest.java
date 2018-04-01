package richey.springaop.advisor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import richey.springaop.entity.Seller;
import richey.springaop.entity.Waiter;

public class GreetingAdvisorTest {

    @Test
    public void greetingAdvisorWithStaticMethodMatchTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller sellter = (Seller) ctx.getBean("sellter");

        waiter.greetTo("richey");
        waiter.serveTo("richey");
        sellter.greetTo("richey");

    }


    @Test
    public void greetingAdvisorWithRegexpMethodTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter1");

        waiter.greetTo("richey");
        waiter.serveTo("richey");

    }


    @Test
    public void greetingAdvisorWithDynamicMethodMatchTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Waiter waiter = (Waiter) ctx.getBean("waiter2");

        waiter.greetTo("richey");
        waiter.serveTo("richey");
        waiter.greetTo("kelly");
        waiter.serveTo("kelly");
        waiter.greetTo("John");
        waiter.serveTo("John");
    }


}