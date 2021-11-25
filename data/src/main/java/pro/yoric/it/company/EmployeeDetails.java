package pro.yoric.it.company;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "T_EMPLOYEE_DETALES")
public class EmployeeDetails
{
    // FIELDS
    @Id
    @Column(name = "EMPLOYEE_DETAILS_ID")
    @GeneratedValue(generator = "uuid-generator" )
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @Column(name = "ADDRESS") //not necessary might generate by hibernate
    private String address;

    // FIELDS Relations
    @OneToOne
    private  Employee employee;

    // CONSTRUCTORS
    public EmployeeDetails(){}

    public EmployeeDetails(String address)
    {
        this.address = address;
    }

    // GETTERS
    public String getId()
    {
        return id;
    }
    public String getAddress()
    {
        return address;
    }
    public Employee getEmployee()
    {
        return employee;
    }

    // SETTERS
    public void setAddress(String address)
    {
        this.address = address;
    }
    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
}
