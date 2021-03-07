package top.evolutionary.data.mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @author richey
 */
@Service
public class SaveService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 存储【一条】用户信息，如果文档信息已经【存在就执行更新】
     *
     * @return 存储的文档信息
     */
    public <T> T save(T obj, String collectionName) {

        // 存储信息,如果文档信息已经存在就执行更新
        return mongoTemplate.save(obj, collectionName);
    }
}
