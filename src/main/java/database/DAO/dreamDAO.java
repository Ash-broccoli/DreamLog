package database.DAO;

import database.Connector;
import models.Dream;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class dreamDAO {
    public ArrayList<Dream> select(){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();

        ArrayList<Dream> result = (ArrayList<Dream>) em.createQuery("select d from Dream d", Dream.class).getResultList();

        em.getTransaction().commit();
        em.close();
        return result;
    }

    public ArrayList<Dream> selectWithId(int id){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();

        ArrayList<Dream> result = (ArrayList<Dream>) em.createQuery("select d from Dream d where d.dreamID = :id", Dream.class).setParameter("id", id).getResultList();

        em.getTransaction().commit();
        em.close();
        return result;
    }

    public ArrayList<Dream> selectMonth(String date){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();

        ArrayList<Dream> result = (ArrayList<Dream>) em.createQuery("select d from Dream d where d.date like '"+date+"%'", Dream.class).getResultList();

        em.getTransaction().commit();
        em.close();
        return result;
    }

    public void insert(Dream d) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Dream d){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        em.remove(em.contains(d) ? d : em.merge(d));
        em.getTransaction().commit();
        em.close();
    }
}
