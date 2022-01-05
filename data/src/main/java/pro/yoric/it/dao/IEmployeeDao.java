package pro.yoric.it.dao;

import pro.yoric.it.company.pojo.Employee;

public interface IEmployeeDao {
    // SETTERS
    boolean saveEmployee(Employee employee);
}
