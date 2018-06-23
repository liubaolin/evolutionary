# 传统访问数据库的方式
## 环境准备
* 数据库驱动包及junit测试包

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
        </dependency>
        
* 数据表准备

        create schema spring_data;
        
        use spring_data;
        
        show tables;
        
        create table student(
            id int not null auto_increment,
            name varchar(20) not null,
            age int not null,
            primary key(id)
        )
        
        desc student; -- 查看表结构
        
        insert into student(name,age) values("zhangSan",18);
        insert into student(name,age} values("liSi",28);
        insert into student(name,age} values("wangWu",38);

* 代码开发