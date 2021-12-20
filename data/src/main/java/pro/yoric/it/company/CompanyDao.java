package pro.yoric.it.company;

import org.hibernate.Session;
import pro.yoric.it.dao.ICompanySearchDao;
import pro.yoric.it.data.SessionFactoryHolder;

import org.hibernate.SessionFactory;

import java.util.List;

public class CompanyDao
    implements ICompanySearchDao
{
    // INSTANCES
    private final SessionFactory sessionFactory;


    // CONSTRUCTORS
    public CompanyDao()
    {
        this.sessionFactory = SessionFactoryHolder.getSessionFactoryCompany();
    }

    @Override
    public List<Company> search(String namePattern)
    {
        Session session = sessionFactory.openSession();

        String query =
            "FROM "                 +
                "t_company c "      +
            "WHERE "                +
                "c.company_name "   +
            "LIKE"                  +
            namePattern;

        List<Company> companies =
            session
            .createQuery(
                query,
                Company.class
            )
            .list();

        session.close();
        return companies;
    }
}
