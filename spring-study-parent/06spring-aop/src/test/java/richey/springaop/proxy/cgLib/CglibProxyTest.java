package richey.springaop.proxy.cgLib;

import org.junit.Test;

public class CglibProxyTest {

    @Test
    public void adminServiceTest() {
        CglibProxy cglibProxy = new CglibProxy();
        //通过动态生成子类的方式创建代理类
        CglibAdminServiceImpl cglibAdminService = (CglibAdminServiceImpl) cglibProxy.getProxy(CglibAdminServiceImpl.class);
        cglibAdminService.removeCompany("1");
        cglibAdminService.removeStaff("1");
    }

}
