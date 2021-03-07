package top.evolutionary.data.mongo.service;

import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author richey
 */
@Service
public class ViewService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 创建视图
     *
     * @param newViewName    视图名
     * @param collectionName 获取数据的集合名称
     * @param pipeline       视图的管道,可设置视图显示的内容多个筛选条件 new ArrayList<>()
     *                       设置条件，用于筛选集合中的文档数据，只有符合条件的才会映射到视图中
     *                       pipeline.add(Document.parse("{\"$match\":{\"sex\":\"女\"}}"));
     * @return
     */
    public boolean createView(String newViewName,
                              String collectionName,
                              List<Bson> pipeline) {

        // 执行创建视图
        mongoTemplate.getDb().createView(newViewName, collectionName, pipeline);
        // 检测新的集合是否存在，返回创建结果
        return mongoTemplate.collectionExists(newViewName);
    }


    /**
     * 删除视图
     *
     * @return
     */
    public boolean dropView(String viewName) {

        // 检测视图是否存在
        if (mongoTemplate.collectionExists(viewName)) {
            // 删除视图
            mongoTemplate.getDb().getCollection(viewName).drop();
            return true;
        }
        // 检测新的集合是否存在，返回结果
        return !mongoTemplate.collectionExists(viewName);
    }


}
