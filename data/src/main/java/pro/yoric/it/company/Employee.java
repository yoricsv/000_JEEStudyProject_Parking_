package pro.yoric.it.company;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_EMPLOYEE")
public class Employee
{
    @Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue(generator = "uuid-generator" )
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "SECOND_NAME")
    private String secondName;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    // FIELDS Relations
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL) // name of link field EmployeeDetales (private String employee;)
    private EmployeeDetails employeeDetails;

    @ManyToOne
    @JoinColumn(name = "FK_COMPANY_ID")
    private Company company;

    @ManyToMany
    @JoinTable(
        name               = "T_EMPLOYEE_MEETINGS",
        joinColumns        = @JoinColumn(name = "EMPLOYEE_ID"),
        inverseJoinColumns = @JoinColumn(name = "MEETING_ID")
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
    public String getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getSecondName() {
        return secondName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public EmployeeDetails getEmployeeDetails()
    {
        return employeeDetails;
    }
    public Company getCompany() {
        return company;
    }
    public List<Meeting> getMeetings()
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
        this.employeeDetails = employeeDetails; //        employeeDetails.setEmployee(this); // not work if we use library LAMBOCK
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
