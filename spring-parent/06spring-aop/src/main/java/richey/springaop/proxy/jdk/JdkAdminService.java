package richey.springaop.proxy.jdk;

/**
 * @author richey
 * 管理员服务类，用于测试
 */
public interface JdkAdminService {

    /**
     * 删除一个员工
     * @param staffId
     */
    public void removeStaff(String staffId);

    /**
     * 删除一个公司
     * @param companyId
     */
    public void removeCompany(String companyId);

}
