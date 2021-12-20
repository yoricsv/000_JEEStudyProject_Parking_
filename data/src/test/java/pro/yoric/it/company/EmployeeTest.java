package pro.yoric.it.company;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

import org.junit.Test;
import org.junit.After;

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
        // GIVEN
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Employee employee =
            new Employee(
                "Ivan",
                "Petrov",
                "+375295554433"
            );
        EmployeeDetails details = new EmployeeDetails("Lenina 21, Minsk");

        employee.setEmployeeDetails(details);
        details.setEmployee(employee);

        // WHEN
        Serializable id = session.save(employee);
        transaction.commit();

        // THEN
        Employee saved = session.get(Employee.class, id);

        System.out.println(saved.getId());

        assertNotNull(saved.getId());
        assertNotNull(saved.getEmployeeDetails().getId());
    }

    @Test
    public void saveCompanyWithEmployees()
    {
        // GIVEN
        Company company = new Company("Coca-cola");

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

        // WHEN
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Serializable companyId  = session.save(company);
        session.save(employee1);
        session.save(employee2);

        transaction.commit();

        // THEN
        Company saved = session.load(Company.class, companyId);

        session.refresh(saved);

        assertEquals(2, saved.getEmployees().size());
    }

    @After
    public void tearDown()
    {
        session.close();
    }
}

