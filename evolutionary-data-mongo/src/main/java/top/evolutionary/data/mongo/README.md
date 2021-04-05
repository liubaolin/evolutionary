# 初始化
将module模块的所有数据初始化到mongoDB
```sql
use ihr360_collections
db.dropDatabase()
db.types.insertMany("[]")
db.groups.insertMany("[]")
db.collections.insertMany("[]")
db.collection_data.insertMany("[]")

```

# 关联查询$lookup

collection_data中的存在多个集合数据（1-N）
```sql
db.collection_data.aggregate(
    [
      {
        $lookup:{
          from:"collections",
          localField:"collection_id",
          foreignField:"collection_id",
          as:"collection"
        }
      }
    ]
)

```





