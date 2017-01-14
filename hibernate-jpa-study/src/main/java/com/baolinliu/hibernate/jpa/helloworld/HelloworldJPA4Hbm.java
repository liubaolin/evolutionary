package com.baolinliu.hibernate.jpa.helloworld;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by richey on 17-1-7.
 */
public class HelloworldJPA4Hbm {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldPU");
        EntityManager em = emf.createEntityManager();
        Session session = (SessionImpl) em.getDelegate();
        Transaction tx = session.getTransaction();
        tx.begin();
        List<Map<String,String>> list = session.createSQLQuery("SELECT id,text FROM Message")
                .setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP)
                .list();
        for(Map<String,String> map :list){
            Set set  =map.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }

        }
        tx.commit();
        em.close();
        emf.close();
    }

}
