package top.evolutionary.springbootdemo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.evolutionary.springbootdemo.dto.primary.Staff;
import top.evolutionary.springbootdemo.dto.secdary.Company;
import top.evolutionary.springbootdemo.repository.primary.StaffRepository;
import top.evolutionary.springbootdemo.repository.secdary.CompanyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
public class MultipleDatasource4JpaTest {

    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @Before
    public void delete() {
        staffRepository.deleteAll();
        companyRepository.deleteAll();
    }


    @Test
    public void test() throws Exception{
        staffRepository.save(new Staff("richey1",18));
        staffRepository.save(new Staff("richey2",19));
        staffRepository.save(new Staff("richey3",20));

        Assert.assertEquals(3, staffRepository.findAll().size());

        companyRepository.save(new Company("company1", "add1"));
        companyRepository.save(new Company("company2", "add2"));

        Assert.assertEquals(2, companyRepository.findAll().size());


    }

}
