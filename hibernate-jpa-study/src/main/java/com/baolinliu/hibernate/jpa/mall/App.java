package com.baolinliu.hibernate.jpa.mall;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by richey on 17-1-8.
 */
public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        SpuItem spuItem = new SpuItem();
        spuItem.setName("iphone");
        StandardProductUnit spu = new StandardProductUnit();
        spu.setSpuItem(spuItem);
        Product product = new Product();
        spu.setProduct(product);
        product.setCode("pro001");
        List<StandardProductUnit> spus = new ArrayList<StandardProductUnit>();
        spus.add(spu);
        product.setSpus(spus);
        em.persist(spuItem);
        em.persist(product);
        tx.commit();
        em.close();
        emf.close();
    }
}
