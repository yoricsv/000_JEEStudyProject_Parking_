package pro.yoric.it.validator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pro.yoric.it.company.Employee;

@Component
@Scope("prototype")
public class EmployeeValidator
    implements IEmployeeValidator
{
    public EmployeeValidator()
    {
        super();
    }

    @Override
    public boolean validate(Employee employee)
    {
        System.out.println("Call EmployeeValidatorImpl");
        return false;
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    @Override
    protected Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
