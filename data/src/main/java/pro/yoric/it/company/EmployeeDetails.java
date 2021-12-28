package pro.yoric.it.company;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_employee_details")
public class EmployeeDetails
{
    // FIELDS
    @Id
    @Column(name  = "employee_details_id")
    @GeneratedValue(
        generator = "uuid-generator"
    )
    @GenericGenerator(
        name      = "uuid-generator",
        strategy  = "uuid"
    )
    private String   id;

    @Column(name  = "address")
    private String   address;


    // FIELDS RELATIONS
    @OneToOne
    private Employee employee;


    // CONSTRUCTORS
    public EmployeeDetails(){}
    public EmployeeDetails(String address)
    {
        this.address = address;
    }


    // GETTERS
    public String   getId()
    {
        return id;
    }
    public String   getAddress()
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
