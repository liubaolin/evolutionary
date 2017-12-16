package richey.springaop.proxy.jdk;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class JdkAdminServiceImplTest {

    @Test
    public void removeStaffTest() {
        JdkAdminService target = new JdkAdminServiceImpl();
        PerformanceHandler handler = new PerformanceHandler(target);
        //jdk创建代理有一个限制，只能为接口创建代理实例
        JdkAdminService proxy = (JdkAdminService) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);
        proxy.removeStaff("1");
        proxy.removeCompany("1");
    }

}
