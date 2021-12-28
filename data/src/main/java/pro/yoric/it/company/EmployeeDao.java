package pro.yoric.it.company;

import pro.yoric.it.data.SessionFactoryHolder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDao
{
    // INSTANCES
    private final SessionFactory sessionFactory;


    // CONSTRUCTORS
    public EmployeeDao()
    {
        sessionFactory = SessionFactoryHolder.getSessionFactoryCompany();
    }


    // SETTERS
    public boolean saveEmployee(Employee employee)
    {
              Session     session     = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        try
        {
            session.save(employee);
            transaction.commit();

            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            transaction.rollback();

            return false;
        }
        finally
        {
            session.close();
        }
    }
}