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

    public BigDecimal getAnnualSalary(String employeeId, short year)
    {
        Session session = sessionFactory.openSession();

        final Query query =
            session.createQuery(
                "SELECT " +
                        "SUM (p.amount) " +
                "FROM " +
                    "T_PAYSLIP p " +
                "WHERE " +
                    "p.employee.id=:EMPLOYEE_ID " +
                "AND " +
                    "p.year=:YEAR"
            );

        query.setParameter("EMPLOYEE_ID", employeeId);
        query.setParameter("YEAR", year);

        BigDecimal sum = (BigDecimal) query.uniqueResult();
        session.close();

        return sum;
    }

    private final SessionFactory sessionFactory;
}
