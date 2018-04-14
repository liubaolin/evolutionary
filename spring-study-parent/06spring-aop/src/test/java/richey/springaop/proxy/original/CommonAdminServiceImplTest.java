package richey.springaop.proxy.original;


import org.junit.Test;

public class CommonAdminServiceImplTest {

    @Test
    public void removeStaffTest() {
        CommonAdminService commonAdminService = new CommonAdminServiceImpl();
        commonAdminService.removeStaff("1");
    }

}
