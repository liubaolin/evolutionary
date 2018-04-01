package richey.springaop.advice.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import richey.springaop.entity.Staff;

public class StaffServiceTest {

    private ApplicationContext context;

    @Before
    public void initContext() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void removeStaff() throws Exception {
        StaffService staffService = (StaffService) context.getBean("staffService");
        staffService.removeStaff(1);

    }

    @Test
    public void updateStaff() throws Exception {
        StaffService staffService = (StaffService) context.getBean("staffService");
        staffService.updateStaff(new Staff());
    }



}
