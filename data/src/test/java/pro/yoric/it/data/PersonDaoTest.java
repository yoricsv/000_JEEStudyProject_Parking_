package pro.yoric.it.data;

import pro.yoric.it.pojo.Person;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonDaoTest
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
        // GIVEN
        Person person = new Person();
        person.setId(1001L);
        person.setName("Ivan");
        person.setSecondName("Petrov");

        // WHEN
        Serializable id = personDao.savePerson(person);

        // THEN
        assertEquals(1001L, id);

        // check Read
        List<Person> list = personDao.readPerson();
        assertEquals(1, list.size());

        personDao.deletePerson(list.get(0));
    }
}