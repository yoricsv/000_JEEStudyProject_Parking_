package pro.yoric.it.data;

import pro.yoric.it.dao.IPersonDao;
import pro.yoric.it.pojo.Person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

/**
 * CRUD (Create Read Update Delete)
 */
public class PersonDao
    implements IPersonDao
{
    /** CREATE */
    // CONSTRUCTORS
    public PersonDao()
    {
        this(SessionFactoryHolder.getSessionFactory());
    }
    public PersonDao(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    /** READ */
    @Override
    public List<Person> readPerson()
    {
        Session session = sessionFactory.openSession();

        List<Person> personList =
            session
            .createQuery(
                "FROM Person",      // HQL, not SQL! HQL works with a persistent object not a Table!!!
                Person.class)
            .list();

        session.close();

        return personList;
    }

    /** UPDATE */
    @Override
    public Serializable savePerson(Person person)
    {
        Session session = sessionFactory.openSession();

        Serializable serializableId = null;
        Transaction  transaction    = null;

        try
        {
            transaction    = session.beginTransaction();

            serializableId = session.save(person);
            transaction.commit();
        }
        catch (Exception e)
        {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }

        return serializableId;
    }

    /** DELETE */
    @Override
    public void         deletePerson(Person person)
    {
        Session session = sessionFactory.openSession();

        Transaction  transaction = null;

        try
        {
            transaction = session.beginTransaction();

            session.delete(person);
            transaction.commit();
        }
        catch (Exception e)
        {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

    @Override
    public List<Person> searchByNameAndSecondName(String name, String secondName) {
        return null;
    }

    private final SessionFactory sessionFactory;
}
