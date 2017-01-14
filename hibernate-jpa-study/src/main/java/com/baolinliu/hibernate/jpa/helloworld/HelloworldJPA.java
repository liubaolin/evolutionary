package com.baolinliu.hibernate.jpa.helloworld;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by richey on 17-1-7.
 */
public class HelloworldJPA {


    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HelloWorldPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Message message = new Message("Helloworld");
        em.persist(message);
        tx.commit();
        em.close();

        EntityManager newEm = emf.createEntityManager();
        EntityTransaction newTx = newEm.getTransaction();
        newTx.begin();
        List<Message> messages =
                newEm.createQuery("select m from Message m order by m.text asc")
                .getResultList();
        for (Message m: messages){
            System.out.println(m.getId()+":"+m.getText());
        }
        newTx.commit();
        newEm.close();
        emf.close();
    }

}
