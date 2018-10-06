package top.richpeople.springTransaction.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.richpeople.springTransaction.service.UserService;
import top.richpeople.springTransaction.vo.User;

public class UserServiceImplTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void save() throws Exception {

        UserService userService = (UserService) applicationContext.getBean("userService");
        User user = new User();
        user.setName("Richey");
        user.setAge(18);
        user.setGender("man");

        userService.save(user);

    }




}