package database.DAO;

import database.Connector;
import models.Dream;

import javax.persistence.EntityManager;
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
}
