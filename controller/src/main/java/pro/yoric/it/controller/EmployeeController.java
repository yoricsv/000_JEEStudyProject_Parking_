package pro.yoric.it.controller;

import org.springframework.stereotype.Service;
import pro.yoric.it.company.Employee;
import pro.yoric.it.company.EmployeeDao;
import pro.yoric.it.company.PayslipDao;

@Service // for webapp - controller, for jar - service // NEED FOR AUTO BEAN CREATION
public class EmployeeController
{

    // CONTROLLER
    public EmployeeController()
    {
        this.employeeDao = null;
        this.payslipDao = null;
    }
    public EmployeeController(
            EmployeeDao employeeDao,
            PayslipDao  payslipDao
        )
    {
        this.employeeDao = employeeDao;
        this.payslipDao = payslipDao;
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
    private final EmployeeDao employeeDao;
    private final PayslipDao  payslipDao;
}
