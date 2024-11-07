package org.aehibernate.dao;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase utilitaria para manejar la configuración de Hibernate.
 */
public class HibernateUtil {
    @Getter
    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .configure()
                .setProperty("hibernate.connection.password", System.getenv("MYSQL_ROOT_PASSWORD"))
                .setProperty("hibernate.connection.username", System.getenv("MYSQL_USER"))
                .buildSessionFactory();
    }
}