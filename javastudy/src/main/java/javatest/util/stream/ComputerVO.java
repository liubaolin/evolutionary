package javatest.util.stream;

import javax.print.attribute.standard.MediaSize;

/**
 * DESCRIPTION: 这是一个Computer的值对象,用来作测试
 *
 * @author richey
 * @create 2017-07-09-下午9:41
 */
public class ComputerVO {

    private Integer id;
    private String name;
    private Double price;

    public ComputerVO() {
    }

    public ComputerVO(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
