package pro.yoric.it.service;

import pro.yoric.it.company.EmployeeDao;
import pro.yoric.it.company.PayslipDao;
import pro.yoric.it.company.pojo.Employee;

import pro.yoric.it.dao.IEmployeeDao;
import pro.yoric.it.dao.IPayslipDao;

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
    private final IEmployeeDao iEmployeeDao;
    private final IPayslipDao  iPayslipDao;


    // CONSTRUCTORS
    public EmployeeService(
            EmployeeDao employeeDao,
            PayslipDao  payslipDao
        )
    {
        this.iEmployeeDao = employeeDao;
        this.iPayslipDao  = payslipDao;
    }


    // SETTERS
    public boolean save(Employee employee)
    {
        // Check employee input value
        return iEmployeeDao.saveEmployee(employee);
    }
}
