package pro.yoric.it.company;

import pro.yoric.it.data.SessionFactoryHolder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.math.BigDecimal;

public class PayslipDao
{
    private final SessionFactory sessionFactory;

    public PayslipDao()
    {
        sessionFactory = SessionFactoryHolder.getSessionFactoryCompany();
    }
    public PayslipDao(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    public BigDecimal getAnnualSalary(Employee employeeId, short year)
    {
        Session session = sessionFactory.openSession();

        final Query query =
        session.createQuery(
                "select sum (p.amount) from T_PAYSLIP p " +
                "where p.employee.id=:EMPLOYEE_ID and p.year=:YEAR"
            );

        query.setParameter("EMPLOYEE_ID", employeeId);
        query.setParameter("YEAR", year);

        BigDecimal sum = (BigDecimal) query.uniqueResult();
        session.close();

        return sum;
    }
}
