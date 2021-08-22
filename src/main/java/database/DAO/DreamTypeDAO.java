package database.DAO;

import database.Connector;
import models.DreamType;

import javax.persistence.EntityManager;
import java.util.ArrayList;

public class DreamTypeDAO {

    public ArrayList<DreamType> select(){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();

        ArrayList<DreamType> result = (ArrayList<DreamType>) em.createQuery("select d from DreamType d", DreamType.class).getResultList();

        em.getTransaction().commit();
        em.close();
        return result;
    }
}
