package pro.yoric.it.parking;

import org.springframework.stereotype.Repository;
import pro.yoric.it.dao.IPersonDao;
import pro.yoric.it.data.SessionFactoryHolder;
import pro.yoric.it.parking.pojo.Person;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

/**
 * CRUD (Create Read Update Delete)
 */
@Repository
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
    public List<Person> searchByNameAndSurname(
            String name,
            String surname
        )
    {
        Session session = sessionFactory.openSession();

        List<Person> personList =
            session
            .createQuery(
                "FROM "             +
                    "Person p "     +
                "WHERE "            +
                    "p.name=:name " +
                "AND "              +
                    "p.surname=:surname ",
                Person.class
            )
            .setParameter(
                "name",
                name
            )
            .setParameter(
                "surname",
                surname
            )
            .list();

        session.close();

        return personList;
    }

    @Override
    public List<Person> search(String param)
    {
        Session session = sessionFactory.openSession();

        List<Person> personList =
            session
            .createQuery(
                "FROM "             +
                    "Person p "     +
                "WHERE "            +
                    "p.name "       +
                "LIKE "             +
                    "'%"            + param +
                    "%' "           +
                "OR "               +
                    "p.surname " +
                "LIKE "             +
                    "'%"            + param +
                    "%' ",
                Person.class
            )
            .list();

        session.close();

        return personList;
    }

    private final SessionFactory sessionFactory;
}
