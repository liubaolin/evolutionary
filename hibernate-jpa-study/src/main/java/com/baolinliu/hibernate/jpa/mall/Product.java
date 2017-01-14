package com.baolinliu.hibernate.jpa.mall;

import org.hibernate.annotations.NaturalId;
import org.joyful4j.persistence.entity.pojo.NumberIdObject;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by richey on 17-1-7.
 */
@Entity
public class Product extends NumberIdObject<Long>{
    private static final long serialVersionUID = 2971378772737714296L;

    @Column(length = 100)
    @NaturalId(mutable = true)
    private String name;

    //TODO 自动生成code
        /** 编码 */
    //    @CodeGenerator(length = 8)
    @Column(length = 32, unique = true, nullable = false)
    private String code;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<StandardProductUnit> spus;

    @ManyToOne
    private ProductCategory productCategory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<StandardProductUnit> getSpus() {
        return spus;
    }

    public void setSpus(List<StandardProductUnit> spus) {
        this.spus = spus;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
