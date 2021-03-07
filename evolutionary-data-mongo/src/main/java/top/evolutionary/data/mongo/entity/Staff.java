package top.evolutionary.data.mongo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * MongoDB stores data in collections. Spring Data MongoDB maps the Staff class into a collection called customer. If you want to change the name of the collection, you can use Spring Data MongoDB’s @Document annotation on the class.
 */
@Accessors(chain = true)
@Document("staff")
public class Staff {

    @Id
    private String id;

    private String name;

    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthDay;

    private Education education;

    public Staff() {
    }

    public Staff(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }
}