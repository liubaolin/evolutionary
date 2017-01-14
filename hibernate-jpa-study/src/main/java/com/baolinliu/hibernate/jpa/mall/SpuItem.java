package com.baolinliu.hibernate.jpa.mall;

import org.hibernate.annotations.NaturalId;
import org.joyful4j.persistence.entity.pojo.NumberIdObject;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by richey on 17-1-7.
 * SPU项
 */
@Entity
public class SpuItem extends NumberIdObject<Long>{

    private static final long serialVersionUID = -5036289026528935208L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(length = 100)
    @NaturalId
    private String name;

}
