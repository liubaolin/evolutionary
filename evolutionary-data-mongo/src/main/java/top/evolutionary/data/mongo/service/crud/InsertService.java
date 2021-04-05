package top.evolutionary.data.mongo.service.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @author richey
 */
@Service
public class InsertService {

    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 插入【一条】文档数据，如果文档信息已经【存在就抛出异常】
     *
     * @return 插入的文档信息
     */
    public <T> T insert(T obj, String collectionName) {

        // 插入一条用户数据，如果文档信息已经存在就抛出异常
        return mongoTemplate.insert(obj, collectionName);
    }


    /**
     * 插入【多条】文档数据，如果文档信息已经【存在就抛出异常】
     *
     * @return 插入的多个文档信息
     */
    public <T> T insertMany(T objList, String collectionName) {

        // 插入一条用户数据，如果某个文档信息已经存在就抛出异常
        return mongoTemplate.insert(objList, collectionName);
    }

}
