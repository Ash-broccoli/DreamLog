package database.DAO;

import database.Connector;
import models.Dream;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DreamDAO {
    public ArrayList<Dream> select() {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();

        ArrayList<Dream> result = (ArrayList<Dream>) em.createQuery("select d from Dream d", Dream.class).getResultList();

        em.getTransaction().commit();
        em.close();
        return result;
    }

    public Dream selectWithId(int id) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();

        Dream result = selectWithId(id, em);
        em.getTransaction().commit();
        em.close();
        return result;
    }

    public Dream selectWithId(int id, EntityManager em) {
        try {
            return em.createQuery("select d from Dream d where d.dreamID = :id", Dream.class).setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public ArrayList<Dream> selectMonth(String date) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();

        ArrayList<Dream> result = (ArrayList<Dream>) em.createQuery("select d from Dream d where d.date like '" + date + "%'", Dream.class).getResultList();

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

    public void delete(Dream d) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        em.remove(em.contains(d) ? d : em.merge(d));
        em.getTransaction().commit();
        em.close();
    }

    public void update(Dream d) {
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();
        Dream dreamDB = selectWithId(d.getDreamID(), em);
        if (dreamDB != null) {
            dreamDB.setEverything(d);
        }
        em.getTransaction().commit();
        em.close();
    }
}
