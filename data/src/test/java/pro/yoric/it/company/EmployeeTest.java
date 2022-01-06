package pro.yoric.it.company;


import pro.yoric.it.company.pojo.Company;
import pro.yoric.it.company.pojo.Employee;
import pro.yoric.it.company.pojo.EmployeeDetails;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EmployeeTest
    extends BaseTest
{
    @Test
    public void testSave()
        throws InterruptedException
    {
        // GIVEN
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Employee employee =
            new Employee(
                "Ivan",
                "Petrov",
                "+375295554433"
            );
        EmployeeDetails details =
            new EmployeeDetails(
                "Lenina 21, Minsk"
            );

        employee.setEmployeeDetails(details);
        details.setEmployee(employee);

        // WHEN
        Serializable serializableId =
            session
            .save(
                employee
            );

        transaction.commit();

        // THEN
        Employee saved =
            session
            .get(
                Employee.class,
                serializableId
            );

        System.out.println(saved.getId());

        assertNotNull(saved.getId());
        assertNotNull(saved.getEmployeeDetails().getId());
    }

    @Test
    public void saveCompanyWithEmployees()
    {
        // GIVEN
        Company company =
            new Company(
                "Coca-cola"
            );

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
        Session     session     = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Serializable companyId  = session.save(company);

        session.save(employee1);
        session.save(employee2);

        transaction.commit();

        // THEN
        Company saved =
            session
            .load(
                Company.class,
                companyId
            );

        session.refresh(saved);

        assertEquals(2, saved.getEmployees().size());
    }
}

