package pro.yoric.it.company;

import pro.yoric.it.data.SessionFactoryHolder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDao
{
    // CONSTRUCTORS
    public EmployeeDao()
    {
        sessionFactory = SessionFactoryHolder.getSessionFactoryCompany();
    }

    public boolean saveEmployee(Employee employee)
    {
              Session     session     = sessionFactory.openSession();
        final Transaction TRANSACTION = session.beginTransaction();

        try
        {
            session.save(employee);
            TRANSACTION.commit();

            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            TRANSACTION.rollback();

            return false;
        }
        finally
        {
            session.close();
        }
    }

    private final SessionFactory sessionFactory;
}