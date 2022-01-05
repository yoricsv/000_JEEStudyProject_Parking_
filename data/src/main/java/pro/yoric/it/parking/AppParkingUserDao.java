package pro.yoric.it.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pro.yoric.it.dao.IAppParkingUserDao;
import pro.yoric.it.data.SessionFactoryHolder;
import pro.yoric.it.parking.pojo.AppParkingUser;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

@Repository
public class AppParkingUserDao
    implements IAppParkingUserDao
{
    // INSTANCES
    @Autowired
    @Qualifier("parkingSessionFactory")
    private SessionFactory sessionFactory;


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
