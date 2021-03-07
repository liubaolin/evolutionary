package top.evolutionary.data.mongo.repository;

import com.mongodb.client.MongoClients;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import top.evolutionary.data.mongo.entity.Education;
import top.evolutionary.data.mongo.entity.Staff;

import java.util.Date;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @author richey
 */

public class CustomerMongoOperator {
    private static final Log log = LogFactory.getLog(CustomerMongoOperator.class);


    public void simpleMongoOperatorDemo() {
        MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "database");

        Staff staff = new Staff();
        staff.setName("Richey");
        staff.setAge(18);
        staff.setBirthDay(new Date());

        Education education = new Education();
        education.setSeniorHighSchool("清华附中");
        education.setCollege("清华大学");
        staff.setEducation(education);

        mongoOps.insert(staff);

        log.info(mongoOps.findOne(new Query(where("name").is("Richey")), Staff.class));

//        mongoOps.dropCollection("staff");
    }
}
