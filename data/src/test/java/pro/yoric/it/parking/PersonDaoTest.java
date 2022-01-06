package pro.yoric.it.parking;

import pro.yoric.it.config.TestDaoConfiguration;

import pro.yoric.it.dao.IPersonDao;

import pro.yoric.it.parking.pojo.Person;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(
    classes = TestDaoConfiguration.class
)
@RunWith(
    SpringJUnit4ClassRunner.class
)
public class PersonDaoTest
//    extends BaseTest // If we're inherited from other class, might use without @BeforeClass
{
    // INSTANCES
    @Autowired
    private IPersonDao personDao;

    @Test
    public void savePerson()
    {
        // GIVEN
        Person person = new Person();

        person.setId(1001L);
        person.setName("Ivan");
        person.setSurname("Petrov");

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