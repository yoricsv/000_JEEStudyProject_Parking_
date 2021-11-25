package pro.yoric.it.company;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_COMPANY")
public class Company
{
    @Id
    @Column(name = "COMPANY_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @Column(name = "COMPANY_NAME")
    private String companyName;

    // FIELDS Relations
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Employee> employees;

    // CONSTRUCTORS
    public Company(){ }
    public Company(String companyName) {
        this.companyName = companyName;
    }

    // GETTERS
    public String getId()
    {
        return id;
    }
    public String getCompanyName()
    {
        return companyName;
    }
    public List<Employee> getEmployees()
    {
        return employees;
    }

    // SETTERS
    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }
    public void setEmployees(List<Employee> employees)
    {
        this.employees = employees;
    }
}
