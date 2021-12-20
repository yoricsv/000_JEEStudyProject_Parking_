package pro.yoric.it.validator;

import pro.yoric.it.company.Employee;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Annotation: @Scope("prototype")
 * Param: singleton (by default),
 * Param: prototype (generic),
 * Param: request   (only for WEB),
 * Param: session   (only for WEB)
 */

@Component
@Scope("singleton")
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
