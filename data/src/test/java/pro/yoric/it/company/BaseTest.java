package pro.yoric.it.company;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.junit.BeforeClass;

public class BaseTest
{
    // INSTANCES
    static SessionFactory sessionFactory;

    @BeforeClass
    public static void init()
    {
        StandardServiceRegistry reg =
            new StandardServiceRegistryBuilder()
                .configure("hibernate.company.cfg-test.xml") // Find in resources folder
                .build();

        sessionFactory =
            new MetadataSources(reg)
                .buildMetadata()
                .buildSessionFactory();
    }
}
