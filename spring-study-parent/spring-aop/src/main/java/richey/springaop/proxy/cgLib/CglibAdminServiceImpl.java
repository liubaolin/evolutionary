package richey.springaop.proxy.cgLib;

/**
 * @author richey
 * 对每一个方法都进行了性能监控
 * 问题：
 *  代码重复
 *  监控代码和业务逻辑耦合
 */
public class CglibAdminServiceImpl implements CglibAdminService {

    @Override
    public void removeStaff(String staffId) {

        System.out.println("模拟删除了一个员工记录：" + staffId);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeCompany(String companyId) {

        System.out.println("模拟删除了一个公司记录：" + companyId);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
