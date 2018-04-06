package richey.springaop.Aspectj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import richey.springaop.Aspectj.entity.Driver;
import richey.springaop.Aspectj.entity.Singer;

public class AspectFuntionTest {

    @Test
    public void annotationTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Singer singer = (Singer) ctx.getBean("singer");
        singer.singForAnnotation();
    }

    /**
     * 测试复合切点 和 切点命名
     */
    @Test
    public void aspectTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Singer singer = (Singer) ctx.getBean("singer");
        singer.songWriting();
        singer.singSomeSong();
    }

    /**
     * 测试访问连节点信息
     */
    @Test
    public void testGetJoinPointInfo() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Singer singer = (Singer) ctx.getBean("singer");
        singer.singSomeSong("我们不一样");
    }

    /**
     * 测试绑定连节点方法入参
     */
    @Test
    public void testBindJoinPointParams() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Singer singer = (Singer) ctx.getBean("singer");
        singer.singSomeSong("我们不一样", 5);
    }

    /**
     * 测试绑定被代理对象实例
     */
    @Test
    public void testBindProxyObj() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Singer singer = (Singer) ctx.getBean("singer");
        singer.singSomeSong("海草");
    }

    /**
     * 测试绑定类注解对象
     */
    @Test
    public void testBindTypeAnnotation() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Singer singer = (Singer) ctx.getBean("streetSinger");
        singer.singSomeSong();

    }

    /**
     * 测试绑定返回值
     */
    @Test
    public void testBindReturnValue() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Driver driver= (Driver) ctx.getBean("driver");
        driver.currentSpeed();
    }

}