package richey.springaop.Aspectj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EnableSingerAspectTest {

    /**
     * 引介增强测试
     */
    @Test
    public void declareParentsTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Singer singer = (Singer) ctx.getBean("singer");
        singer.sing();
        Dancer dancer = (Dancer) singer;//通过引介增强，这里可以进行强制类型转换
        dancer.dance();
    }

}