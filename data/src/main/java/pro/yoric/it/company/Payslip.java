package pro.yoric.it.company;

import org.hibernate.annotations.GenericGenerator;
import pro.yoric.it.data.DataSource;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Month;
// import java.util.Date;

@Entity
@Table(name = "T_PAYSLIP")
public class Payslip
{
    // FIELDS
    @Id
    @Column(name = "PAYSLIP_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "YEAR")
    private short year;
    
    @Column
    @Enumerated(EnumType.ORDINAL)
    private Month payslipMonth;

//    @Column(name = "START_DATE")
//    private Date startDate;
//
//    @Column(name = "END_DATE")
//    private Date endDate;
//
//    @Column(name = "UPDATE_DATE")
//    private Date updateDate;

    // FIELDS Relations
    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;


    // CONSTRUCTORS
    public Payslip(){}

    // GETTERS
    public String getId()
    {
        return id;
    }
    public BigDecimal getAmount()
    {
        return amount;
    }
    public short getYear()
    {
        return year;
    }
    public Month getPayslipMonth()
    {
        return payslipMonth;
    }
//    public Date getStartDate()
//    {
//        return startDate;
//    }
//    public Date getEndDate()
//    {
//        return endDate;
//    }
//    public Date getUpdateDate()
//    {
//        return updateDate;
//    }
    public Employee getEmployee()
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
//    public void setStartDate(Date startDate)
//    {
//        this.startDate = startDate;
//    }
//    public void setEndDate(Date endDate)
//    {
//        this.endDate = endDate;
//    }
//    public void setUpdateDate(Date updateDate)
//    {
//        this.updateDate = updateDate;
//    }
    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
}
