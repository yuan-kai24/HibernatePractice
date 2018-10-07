package com.myxq.uitile;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Tianhao on 2018/10/7.
 */
public class HibernateUtil {
    public static SessionFactory sessionFactory;
    static{
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }
    public static Session openSession()
    {
        Session session = sessionFactory.openSession();
        return session;
    }
}
