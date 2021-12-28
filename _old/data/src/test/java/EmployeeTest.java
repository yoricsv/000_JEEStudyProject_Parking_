package pro.yoric.it.company;

import org.hibernate.FlushMode; // OPTIONAL
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;

public class EmployeeTest
    extends BaseTest
{
    // INSTANCES
    Session session;

    @Test
    public void testSave()
        throws InterruptedException
    {
        // Given
        session = sessionFactory.openSession();
//        session.setHibernateFlushMode(FlushMode.ALWAYS); // OPTIONAL
        Transaction transaction = session.beginTransaction();

        Employee employee =
            new Employee(
                "Ivan",
                "Petrov",
                "+375295554433"
            );
        EmployeeDetails details = new EmployeeDetails("Lenina 21, Minsk"); // O-T-O
        employee.setEmployeeDetails(details); // O-T-O
        details.setEmployee(employee); // For cascade - don't need. (Have a sense for ONE-TO-ONE) @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)

        // When
        Serializable id = session.save(employee);
//        session.save(details);
//        session.flush();
//        Tread.sleep(5);
//        Tread.sleep(10);
        transaction.commit(); // don't need if flush()

        // Then
//        Employee saved = session.load(Employee.class, id);

        Employee saved = session.get(Employee.class, id); // O-t-O

        System.out.println(saved.getId());

        assertNotNull(saved.getId());
        assertNotNull(saved.getEmployeeDetails().getId());// O-t-O
    }

    @Test
    public void saveCompanyWithEmployees()
    {
        // Given
        Company company    = new Company("Coca-cola");
        Employee employee1 =
            new Employee(
                "First",
                "First",
                "+11111"
            );
        Employee employee2 =
            new Employee(
                "Second",
                "Second",
                "+22222"
            );

        employee1.setCompany(company);
        employee2.setCompany(company);

        // When
        Session     session     = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Serializable companyId  = session.save(company);
        session.save(employee1);
        session.save(employee2);

        transaction.commit();

        // Then
        Company saved = session.load(Company.class, companyId);

        session.refresh(saved); // need to right saving MANY-TO-ONE

        assertEquals(
            2,
            saved.getEmployees().size()
        );
    }
}

