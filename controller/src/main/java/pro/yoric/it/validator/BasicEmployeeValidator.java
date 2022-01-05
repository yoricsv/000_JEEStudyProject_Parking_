package pro.yoric.it.validator;

import pro.yoric.it.company.pojo.Employee;

import org.springframework.stereotype.Component;


/**
 * Annotation: @Scope("prototype")
 * Param: singleton (by default),
 * Param: prototype (generic),
 * Param: request   (only for WEB),
 * Param: session   (only for WEB)
 */

@Component
public class BasicEmployeeValidator
    implements IEmployeeValidator
{
    // METHODS
    @Override
    public boolean validate(Employee employee)
    {
        System.out.println(
            "Calling the BasicEmployeeValidator implementation"
        );

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
