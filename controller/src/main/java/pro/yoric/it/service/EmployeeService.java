package pro.yoric.it.service;

import pro.yoric.it.company.Employee;
import pro.yoric.it.company.EmployeeDao;
import pro.yoric.it.company.PayslipDao;

import org.springframework.stereotype.Service;


/**
 * Param: @Service
 * need for webapp - controller,
 * for jar - service
 * and
 * NEED FOR AUTO BEAN CREATION
 */
@Service
public class EmployeeService
{

    // CONTROLLER
    public EmployeeService(
            EmployeeDao employeeDao,
            PayslipDao  payslipDao
        )
    {
        this.employeeDao = employeeDao;
        this.payslipDao  = payslipDao;
    }

    // INJECTIONS (DON'T NEED FOR SPRING REGISTRATION. HERE WE CREATE CONSTRUCTORS!!!!!)
//    EmployeeDao employeeDao = new EmployeeDao();

    // SETTERS
    public boolean save(Employee employee)
    {
        // Check employee input value
        return employeeDao.saveEmployee(employee);
    }

    // FIELDS
    final EmployeeDao employeeDao;
    final PayslipDao  payslipDao;
}
