package pro.yoric.it.data;

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
    public List<Person> readPerson()
    {
        Session session = sessionFactory.openSession();

        List<Person> personList =
                session
                        .createQuery(
                                "from Person",
                                Person.class)
                        .list();

        session.close();

        return personList;
    }

    /** UPDATE */
    public Serializable savePerson(Person person)
    {
        Session session = sessionFactory.openSession();

        Serializable id = null;
        Transaction  tr = null;

        try
        {
            tr = session.beginTransaction();
            id = session.save(person);
            tr.commit();
        }
        catch (Exception e)
        {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return id;
    }

    /** DELETE */
    public void         deletePerson(Person person)
    {
        Session session = sessionFactory.openSession();

        Transaction  tr = null;

        try
        {
            tr = session.beginTransaction();
            session.delete(person);
            tr.commit();
        }
        catch (Exception e)
        {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

    private final SessionFactory sessionFactory;
}
