package com.baolinliu.hibernate.jpa.mall;

import org.joyful4j.persistence.entity.pojo.NumberIdObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by richey on 17-1-7.
 * 标准产品单元
 */
@Entity
public class StandardProductUnit extends NumberIdObject<Long>{
    private static final long serialVersionUID = -7565348428602264171L;

    /** spu属性 */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private SpuItem spuItem;

    /** spu属性值 */
    @Column(length = 1000)
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    public SpuItem getSpuItem() {
        return spuItem;
    }

    public void setSpuItem(SpuItem spuItem) {
        this.spuItem = spuItem;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
