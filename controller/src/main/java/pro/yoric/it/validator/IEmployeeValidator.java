package pro.yoric.it.validator;

import org.springframework.stereotype.Component;
import pro.yoric.it.company.Employee;

@Component
public interface IEmployeeValidator
{
    boolean validate(Employee employee);
}
