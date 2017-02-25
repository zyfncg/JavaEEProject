package edu.nju.j2ee.dao.hibernateSession;

import edu.nju.j2ee.model.Course;
import edu.nju.j2ee.model.Grade;
import edu.nju.j2ee.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by ZhangYF on 2017/2/24.
 */
public class SessionConnect {
    private static Configuration config;
    private static ServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;
    private static Session session;

    public static Session getSession(){
        config = new Configuration().configure();
        config.addAnnotatedClass(Grade.class);
        config.addAnnotatedClass(Course.class);
        config.addAnnotatedClass(Student.class);
        serviceRegistry =new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory=config.buildSessionFactory(serviceRegistry);
        session=sessionFactory.openSession();

        return session;
    }
}
