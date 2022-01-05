package pro.yoric.it.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pro.yoric.it.company.pojo.Employee;
import pro.yoric.it.dao.IEmployeeDao;
import pro.yoric.it.data.SessionFactoryHolder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Repository
public class EmployeeDao
        implements IEmployeeDao
{
    // INSTANCES
    @Autowired
    @Qualifier("companySessionFactory")
    private SessionFactory sessionFactory;


    // SETTERS
    @Override
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