package pro.yoric.it.company;

import pro.yoric.it.dao.IPayslipDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.math.BigDecimal;

@Repository
public class PayslipDao
    implements IPayslipDao
{
    // INSTANCES
    @Autowired
    @Qualifier("companySessionFactory")
    private SessionFactory sessionFactory;


    // GETTERS
    @Override
    public BigDecimal getAnnualSalary(
            String employeeId,
            short  year
        )
    {
        Session session = sessionFactory.openSession();

        session.getCriteriaBuilder();

        final Query<?> query =
            session.createQuery(
                "SELECT "                                +
                    "SUM "                               +
                        "(p.amount) "                    +
                "FROM "                                  +
                    "Payslip p "                         +  // HQL, not SQL! HQL works with a persistent object!!!
/** *********************************************************** *
 *          BE CAREFUL >> IMPORTANT << BE CAREFUL               *
 *                                                              *
 *  PAYSLIP is a persistent object for HIBERNATE (HQL, not SQL) *
 *     When we try to use a table name we get an error!         *
 *       (Smth like: ... t_payslip is not mapped...)            *
 *                                                              *
 *          IS A MISTAKE -->   "t_payslip p "  +                *
 * ************************************************************ */
                "WHERE "                                 +
                        "p.employee.id=:employee_id "    +
                    "AND "                               +
                        "p.year=:year"
            );

        query.setParameter(
            "employee_id",
            employeeId
        );
        query.setParameter(
            "year",
            year
        );

        BigDecimal sum = (BigDecimal) query.uniqueResult();

        session.close();
        return sum;
    }
}
