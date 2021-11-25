package pro.yoric.it.controller;

import pro.yoric.it.company.Employee;
import pro.yoric.it.company.EmployeeDao;

public class EmployeeController
{
    EmployeeDao employeeDao = new EmployeeDao();

    public boolean save(Employee employee)
    {
        // CHECK GET VALUE employeeDao.get

        return employeeDao.saveEmployee(employee);
    }
}
