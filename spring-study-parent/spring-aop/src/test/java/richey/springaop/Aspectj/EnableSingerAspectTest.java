package richey.springaop.Aspectj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import richey.springaop.Aspectj.entity.Dancer;
import richey.springaop.Aspectj.entity.Singer;

public class EnableSingerAspectTest {

    /**
     * 引介增强测试
     */
    @Test
    public void DeclareParentsTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Singer singer = (Singer) ctx.getBean("singer");
        singer.sing();
        Dancer dancer = (Dancer) singer;//通过引介增强，这里可以进行强制类型转换
        dancer.dance();
    }

}