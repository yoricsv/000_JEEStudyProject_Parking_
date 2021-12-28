package pro.yoric.it.data;

import pro.yoric.it.dao.IAppParkingUserDao;
import pro.yoric.it.pojo.AppParkingUser;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AppParkingUserDao
    implements IAppParkingUserDao
{
    // INSTANCES
    private final SessionFactory sessionFactory;


    // CONSTRUCTORS
    public AppParkingUserDao()
    {
        sessionFactory = SessionFactoryHolder.getSessionFactory();
    }


    // GETTERS
    @Override
    public List<AppParkingUser> searchByAppParkingUserLogin(String login)
    {
        return null;
    }
    @Override
    public String findUserByPersonId(Long id)
    {
        return null;
    }


    // SETTERS
    @Override
    public void saveUser(AppParkingUser user)
    {
        final Session     session     = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        try
        {
            session.save(user);
            transaction.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            transaction.rollback();
        }

        session.close();
    }
}
