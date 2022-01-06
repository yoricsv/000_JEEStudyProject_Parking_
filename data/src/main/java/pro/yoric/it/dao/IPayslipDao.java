package pro.yoric.it.dao;

import java.math.BigDecimal;

public interface IPayslipDao
{
    // GETTERS
    BigDecimal getAnnualSalary(
        String employeeId,
        short  year
    );
}
