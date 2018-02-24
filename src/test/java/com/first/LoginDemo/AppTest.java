package com.first.LoginDemo;



import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.registration.model.User;
 
public class AppTest {
    SessionFactory sessionFactory;

    public AppTest() {
       Configuration config=new Configuration();
        config.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/projectdb");
        config.setProperty("hibernate.connection.username","root");
        config.setProperty("hibernate.connection.password","admin");
        config.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
        config.setProperty("hibernate.current_session_context_class", "thread");
        config.setProperty("hibernate.show_sql", "true");
        config.addAnnotatedClass(User.class);

        sessionFactory=config.buildSessionFactory();
    }

    public Session getSession()
    {
        Session session;

        try {
            session = sessionFactory.getCurrentSession();
        } catch (SessionException se) {
            session = sessionFactory.openSession();
        }

        return session;
    }
}