package pro.yoric.it.company;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.Month;

@Entity
@Table(name = "t_payslip")
public class Payslip
{
    // FIELDS
    @Id
    @Column(name  = "payslip_id")
    @GeneratedValue(
        generator = "uuid-generator"
    )
    @GenericGenerator(
        name      = "uuid-generator",
        strategy  = "uuid"
    )
    private String     id;

    @Column(name  = "amount")
    private BigDecimal amount;

    @Column(name  = "year")
    private short      year;
    
    @Column
    @Enumerated(EnumType.ORDINAL)
    private Month      payslipMonth;


    // FIELDS RELATIONS
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee   employee;


    // CONSTRUCTORS
    public Payslip(){}


    // GETTERS
    public String     getId()
    {
        return id;
    }
    public BigDecimal getAmount()
    {
        return amount;
    }
    public short      getYear()
    {
        return year;
    }
    public Month      getPayslipMonth()
    {
        return payslipMonth;
    }
    public Employee   getEmployee()
    {
        return employee;
    }


    // SETTERS
    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }
    public void setYear(short year)
    {
        this.year = year;
    }
    public void setPayslipMonth(Month payslipMonth)
    {
        this.payslipMonth = payslipMonth;
    }
    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
}
