package pro.yoric.it.company;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.Serializable;

public class EmployeeTest
    extends BaseTest
{
    private Thread Tread;

    public void testSave()
        throws InterruptedException
    {
        // Given
        Session session = sessionFactory.openSession();
        session.setHibernateFlushMode(FlushMode.ALWAYS);

        Transaction tr = session.beginTransaction();
        Employee employee =
            new Employee(
                "Ivan",
                "Petrov",
                "+375295558874"
            );
        EmployeeDetails details = new EmployeeDetails("Lenina 21, Minsk");// O-T-O
        employee.setEmployeeDetails(details);// O-T-O
//        details.setEmployee(employee); // If we use cascade - don't need. (Have a sense for ONE-TO-ONE) @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)

        // When
        Serializable id = session.save(employee);
        session.save(details);
//        session.flush();
//        Tread.sleep(5);
//        Tread.sleep(10);
        tr.commit(); // don't need use flush()

        // Then
//        Employee saved = session.load(Employee.class, id);

        Employee saved = session.get(Employee.class, id); // O-T-O
        System.out.println(saved.getId());

        assertNotNull(saved.getId());
        assertNotNull(saved.getEmployeeDetails().getId());// O-T-O
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
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();

        Serializable companyId = session.save(company);
        session.save(employee1);
        session.save(employee2);

        tr.commit();

        // Then
        Company saved = session.load(Company.class, companyId);
        session.refresh(saved); // neen to right saving many-to-one
        assertEquals(2, saved.getEmployees().size());
    }
}

