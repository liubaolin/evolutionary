package top.evolutionary.data.mongo.service.demo;

import java.util.Date;

/**
 * @author richey
 */
public class StaffDemo {

    private String name;

    private int age;

    private String title;

    private Date enrollDate;

    private boolean regularEmployee;

    private Double baseSalary;

    private String companyName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public boolean isRegularEmployee() {
        return regularEmployee;
    }

    public void setRegularEmployee(boolean regularEmployee) {
        this.regularEmployee = regularEmployee;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
