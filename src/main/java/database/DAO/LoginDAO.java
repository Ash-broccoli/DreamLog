package database.DAO;

import database.Connector;
import models.Dream;
import models.Login;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {

    public List<Login> select(){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();

        List<Login> result =  em.createQuery("select d from Login d", Login.class).getResultList();

        em.getTransaction().commit();
        em.close();
        return result;
    }

    public List<Login> selectUsernames(){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();

        List<Login> result =  em.createQuery("select d.username from Login d", Login.class).getResultList();

        em.getTransaction().commit();
        em.close();
        return result;
    }

    public List<Login> selectPassword(int loginId){
        EntityManager em = Connector.getInstance().open();
        em.getTransaction().begin();

        List<Login> result =  em.createQuery("select l.password from Login l where l.loginId = :loginId", Login.class).setParameter("loginId", loginId).getResultList();

        em.getTransaction().commit();
        em.close();
        return result;
    }

}
