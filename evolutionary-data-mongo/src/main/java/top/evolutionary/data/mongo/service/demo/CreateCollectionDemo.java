package top.evolutionary.data.mongo.service.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author richey
 */
@Service
public class CreateCollectionDemo {

    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 创建100000个大小没有限制的集合
     */
    public void createCollectionDemo() {


        int collectionCount = 100000;
        String collectionPrefix = "TestCollection";

        for (int i = 1; i <= collectionCount; i++) {
            String collectionName = collectionPrefix + i;
            System.out.println("create collection " + collectionName);
            mongoTemplate.dropCollection(collectionName);
            mongoTemplate.createCollection(collectionName);
        }

    }

    public void insertLageData() {
        String collectionName = "TestCollection98252";
        long documentCount = 10000000;
        List<StaffDemo> batchStaffs = new ArrayList<>();
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 1; i <= documentCount; i++) {
            StaffDemo staff = new StaffDemo();
            staff.setTitle("title" + i);
            staff.setAge(i % 100);
            staff.setBaseSalary(Double.valueOf(i));
            staff.setCompanyName("cnb");
            staff.setEnrollDate(new Date(currentTimeMillis + i * 1000));
            staff.setName("Foo" + i);
            staff.setRegularEmployee(true);
            batchStaffs.add(staff);
            if (i % 100 == 0) {
                System.out.println("intert " + i);
                mongoTemplate.insert(batchStaffs, collectionName);
                batchStaffs.clear();
            }
        }
    }


}
