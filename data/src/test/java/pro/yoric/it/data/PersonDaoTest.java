package pro.yoric.it.data;

import junit.framework.TestCase;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pro.yoric.it.pojo.Person;

import java.io.Serializable;
import java.util.List;

public class PersonDaoTest
    extends TestCase
{
    static SessionFactory sessionFactory;
    PersonDao personDao;

    @BeforeClass
    public static void init()
    {
        StandardServiceRegistry reg =
                new StandardServiceRegistryBuilder()
                    .configure("hibernate.parking.cfg-test.xml")
                    .build();
        sessionFactory =
            new MetadataSources(reg)
                .buildMetadata()
                .buildSessionFactory();
    }
    @Before
	public void setUp()
        throws Exception
    {
        personDao = new PersonDao(sessionFactory);
    }

    @After
    public void tearDown()
        throws Exception
    {
		personDao = null;
	}

    @Test
    public void savePerson()
    {
        // Given
        Person person = new Person();
        person.setId(1001);
        person.setName("Ivan");
        person.setSecondName("Petrov");

        // When
        Serializable id = personDao.savePerson(person);

        // Then
        assertEquals(1001L, "Ivan");

        // check Read
        List<Person> list = personDao.readPerson();
        assertEquals(1, list.size());

        personDao.deletePerson(list.get(1001));
    }
}