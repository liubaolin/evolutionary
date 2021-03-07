package top.evolutionary.data.mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author richey
 */
@Service
public class QueryCollectionService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 获取【集合名称】列表
     *
     * @return 集合名称列表
     */
    public Set<String> getCollectionNames() {
        // 执行获取集合名称列表
        return mongoTemplate.getCollectionNames();
    }

    /**
     * 检测集合【是否存在】
     *
     * @return 集合是否存在
     */
    public boolean collectionExists(String collectionName) {
        // 检测新的集合是否存在，返回检测结果
        return mongoTemplate.collectionExists(collectionName);
    }




}
