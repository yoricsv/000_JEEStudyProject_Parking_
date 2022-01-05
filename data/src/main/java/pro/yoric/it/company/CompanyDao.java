package pro.yoric.it.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pro.yoric.it.company.pojo.Company;
import pro.yoric.it.dao.ICompanySearchDao;
import pro.yoric.it.data.SessionFactoryHolder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@Repository
public class CompanyDao
    implements ICompanySearchDao
{
    // INSTANCES
    @Autowired
    @Qualifier("companySessionFactory")
    private SessionFactory sessionFactory;


    // METHODS
    @Override
    public List<Company> search(String namePattern)
    {
        Session session = sessionFactory.openSession();

    // FIRST VARIATION
        String query =
            "FROM "                 +
                "Company c "        +  // HQL, not SQL! HQL works with a persistent object not a Table!!!
/** *********************************************************** *
 *          BE CAREFUL >> IMPORTANT << BE CAREFUL               *
 *                                                              *
 *  COMPANY is a persistent object for HIBERNATE (HQL, not SQL) *
 *     When we try to use a table name we get an error!         *
 *       (Smth like: ... t_company is not mapped...)            *
 *                                                              *
 *          IS A MISTAKE -->   "t_company c "  +                *
 * ************************************************************ */
            "WHERE "                +
                "c.company_name "   +
            "LIKE \""               + namePattern +
                "\";";

        List<Company> companies =
            session.createQuery(
                query,
                Company.class
            )
            .list();

    // SECOND VARIATION
//        String query =
//            "FROM "                 +
//                "t_company c "      +
//            "WHERE "                +
//                "c.company_name "   +
//            "LIKE "                 +
//                ":namePattern";
//
//        List<Company> companies =
//            session.createQuery(
//                query,
//                Company.class
//            ).setParameter(
//                "namePattern",
//                namePattern
//            ).list();

        session.close();
        return companies;
    }
}
