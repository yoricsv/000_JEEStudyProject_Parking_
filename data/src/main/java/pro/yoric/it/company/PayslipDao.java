package pro.yoric.it.company;

import pro.yoric.it.data.SessionFactoryHolder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.math.BigDecimal;

public class PayslipDao
{
    // CONSTRUCTORS
    public PayslipDao()
    {
        sessionFactory = SessionFactoryHolder.getSessionFactoryCompany();
    }
    public PayslipDao(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    public BigDecimal getAnnualSalary(
            String employeeId,
            short year
        )
    {
        Session session = sessionFactory.openSession();
        session.getCriteriaBuilder();

        final Query query =
            session.createQuery(
                "SELECT "                                +
                    "SUM "                               +
                        "(p.amount) "                    +
                "FROM "                                  +
                    "t_payslip p "                       +
                "WHERE "                                 +
                        "p.employee.id=:employee_id "    +
                    "AND "                               +
                        "p.year=:year"
            );

        query.setParameter("employee_id", employeeId);
        query.setParameter("year", year);

        BigDecimal sum = (BigDecimal) query.uniqueResult();

        session.close();
        return sum;
    }

    // FIELDS
    private final SessionFactory sessionFactory;
}
