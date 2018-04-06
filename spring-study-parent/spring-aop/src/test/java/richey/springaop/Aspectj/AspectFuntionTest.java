package richey.springaop.Aspectj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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


}