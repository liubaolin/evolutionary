package top.evolutionary.data.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.evolutionary.data.mongo.entity.Staff;

import java.util.List;

/**
 * 只能实现一些简单的操作，可使用MongoTemplate自己写复杂操作
 * Spring Data MongoDB uses the MongoTemplate to execute the queries behind your find* methods. You can use the template yourself for more complex queries, but this guide does not cover that. (see the Spring Data MongoDB Reference Guide ：https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#reference)
 */
public interface StaffCollectionRepository extends MongoRepository<Staff, String> {

    public Staff findByFirstName(String firstName);

    public List<Staff> findByLastName(String lastName);

}