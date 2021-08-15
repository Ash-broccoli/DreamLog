package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Class to manage Hibernate Connections
 *
 * @author Andreas
 * @author Alyssa Heimlicher
 * @since TODO alyssa i love you change this thank you
 */
public class Connector {
    private static Connector instance = null;
    private EntityManagerFactory sessionFactory = null;

    /**
     * Private Constructor to initialize the SessionFactory
     *
     * @author Andreas
     * @since 17.07.2021
     */
    private Connector() {
        sessionFactory = Persistence.createEntityManagerFactory("dreams");
    }

    /**
     * @return the Connector Instance
     * @author Andreas
     * @since 17.07.2021
     */
    public static Connector getInstance() {
        if (Connector.instance == null)
            Connector.instance = new Connector();
        return Connector.instance;
    }

    /**
     * Opens a connection to the Database
     *
     * @return an EntityManager
     * @author Andreas
     * @since 17.07.2021
     */
    public EntityManager open() {
        return sessionFactory.createEntityManager();
    }
}