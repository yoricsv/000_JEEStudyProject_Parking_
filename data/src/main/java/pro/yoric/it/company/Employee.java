package pro.yoric.it.company;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_employee")
public class Employee
{
    // FIELDS
    @Id
    @Column(name  = "employee_id")
    @GeneratedValue(
        generator = "uuid-generator"
    )
    @GenericGenerator(
        name      = "uuid-generator",
        strategy  = "uuid"
    )
    private String id;

    @Column(name  = "first_name")
    private String firstName;

    @Column(name  = "second_name")
    private String secondName;

    @Column(name  = "phone_number")
    private String phoneNumber;


    // FIELDS RELATIONS
    @OneToOne(
        mappedBy = "employee",
        cascade  = CascadeType.ALL
    )
    private EmployeeDetails employeeDetails;

    @ManyToOne
    @JoinColumn(name = "fk_company_id"
    )
    private Company company;

    @ManyToMany
    @JoinTable(
        name         = "t_employee_meetings",
        joinColumns  =
            @JoinColumn(
                name = "employee_id"
            ),
        inverseJoinColumns =
            @JoinColumn(
                name = "meeting_id"
            )
    )
    private List<Meeting> meetings = new ArrayList<>();


    // CONSTRUCTORS
    public Employee(){ }
    public Employee(
            String firstName,
            String secondName,
            String phoneNumber
        )
    {
        this.firstName   = firstName;
        this.secondName  = secondName;
        this.phoneNumber = phoneNumber;
    }


    // GETTERS
    public String          getId() {
        return id;
    }
    public String          getFirstName() {
        return firstName;
    }
    public String          getSecondName() {
        return secondName;
    }
    public String          getPhoneNumber() {
        return phoneNumber;
    }
    public EmployeeDetails getEmployeeDetails()
    {
        return employeeDetails;
    }
    public Company         getCompany() {
        return company;
    }
    public List<Meeting>   getMeetings()
    {
        return meetings;
    }


    // SETTERS
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmployeeDetails(EmployeeDetails employeeDetails)
    {
        this.employeeDetails = employeeDetails;
    }
    public void setCompany(Company company)
    {
        this.company = company;
    }
    public void setMeetings(List<Meeting> meetings)
{
    this.meetings = meetings;
}
}
