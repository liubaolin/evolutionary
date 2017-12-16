package richey.springaop.proxy.original;

import richey.springaop.proxy.PerformanceMonitor;

/**
 * @author richey
 * 对每一个方法都进行了性能监控
 * 问题：
 *  代码重复
 *  监控代码和业务逻辑耦合
 */
public class CommonAdminServiceImpl implements CommonAdminService {

    @Override
    public void removeStaff(String staffId) {
        //性能监控代码跟业务代码耦合在一起了
        PerformanceMonitor.begin("richey.springaop.proxy.original.CommonAdminServiceImpl.removeStaff");
        System.out.println("模拟删除了一个员工记录：" + staffId);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        PerformanceMonitor.end();
    }

    @Override
    public void removeCompany(String companyId) {
        //性能检测代码重复出现
        PerformanceMonitor.begin("richey.springaop.proxy.original.CommonAdminServiceImpl.removeCompany");
        System.out.println("模拟删除了一个公司记录：" + companyId);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        PerformanceMonitor.end();
    }


}
