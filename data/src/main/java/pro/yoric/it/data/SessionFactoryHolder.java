package pro.yoric.it.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryHolder
{
    private SessionFactoryHolder(){}

    public static SessionFactory getSessionFactory()
    {
        if (sessionFactory == null)
        {
            StandardServiceRegistry reg =
                new StandardServiceRegistryBuilder()
                    .configure("hibernate.parking.cfg.xml") // hibernate-test.cfg.xml
                    .build();
            sessionFactory =
                new MetadataSources(reg)
                    .buildMetadata()
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactoryCompany()
    {
        if (sessionFactoryCompany == null)
        {
            StandardServiceRegistry reg =
                new StandardServiceRegistryBuilder()
                    .configure("hibernate.company.cfg.xml")
                    .build();
            sessionFactoryCompany =
                new MetadataSources(reg)
                    .buildMetadata()
                    .buildSessionFactory();
        }
        return sessionFactoryCompany;
    }

    private static SessionFactory sessionFactory;
    private static SessionFactory sessionFactoryCompany;
}
