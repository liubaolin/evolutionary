package top.evolutionary.data.mongo.entity;

/**
 * @author richey
 * 教育经历
 */
public class Education {

    /**
     * 高中
     */
    private String seniorHighSchool;

    /**
     * 大学
     */
    private String college;


    public String getSeniorHighSchool() {
        return seniorHighSchool;
    }

    public void setSeniorHighSchool(String seniorHighSchool) {
        this.seniorHighSchool = seniorHighSchool;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
