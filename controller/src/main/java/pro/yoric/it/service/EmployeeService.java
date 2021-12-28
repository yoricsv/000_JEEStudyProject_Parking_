package pro.yoric.it.service;

import pro.yoric.it.company.Employee;
import pro.yoric.it.company.EmployeeDao;
import pro.yoric.it.company.PayslipDao;

import org.springframework.stereotype.Service;


/**
 * Param: @Service - NEED FOR AUTO BEAN CREATION
 * Typical use:
 *      in the context of a WEB application as a controller,
 *      in the context of a JAR application as a service
 */
@Service
public class EmployeeService
{
    /** ******************************************************* *
     *            If using the SPRING framework,                *
     *        DO NOT USE THE ORDINARY INSTANTIATION             *
     *                                                          *
     *  Example: EmployeeDao employeeDao = new EmployeeDao();   *
     *                                                          *
     *            Below we use SPRING INJECTION                 *
     *            (We will create constructors)                 *
     *  ******************************************************* *
    */
    // INSTANCES
    final PayslipDao  payslipDao;
    final EmployeeDao employeeDao;


    // CONSTRUCTORS
    public EmployeeService(
            EmployeeDao employeeDao,
            PayslipDao  payslipDao
        )
    {
        this.employeeDao = employeeDao;
        this.payslipDao  = payslipDao;
    }


    // SETTERS
    public boolean save(Employee employee)
    {
        // Check employee input value
        return employeeDao.saveEmployee(employee);
    }
}
