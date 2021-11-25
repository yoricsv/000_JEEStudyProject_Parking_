package pro.yoric.it.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pro.yoric.it.pojo.Person;

import java.io.Serializable;
import java.util.List;

public class PersonDao
{
    public PersonDao()
    {
        this(SessionFactoryHolder.getSessionFactory());
    }

    public PersonDao(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }


    private final SessionFactory sessionFactory;

    public Serializable savePerson(Person person)
    {
        Session session = sessionFactory.openSession();
        Serializable id = null;
        Transaction  tr = null;

        try
        {
            tr = session.beginTransaction();
            session.save(person);
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
        return (int) id;
    }

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

    public void deletePerson(Person person)
    {
        Session session = sessionFactory.openSession();
        Serializable id = null;
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
}
