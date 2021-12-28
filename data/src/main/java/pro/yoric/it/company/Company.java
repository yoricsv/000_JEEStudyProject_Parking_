package pro.yoric.it.company;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "t_company")
public class Company
{
    // FIELDS
    @Id
    @Column(name  = "company_id")
    @GeneratedValue(
        generator = "uuid-generator"
    )
    @GenericGenerator(
        name      = "uuid-generator",
        strategy  = "uuid"
    )
    private String id;

    @Column(name  = "company_name")
    private String companyName;

    // FIELDS RELATIONS
    @OneToMany(
        mappedBy  = "company",
        cascade   = CascadeType.ALL
    )
    private List<Employee> employees;


    // CONSTRUCTORS
    public Company(){ }
    public Company(String companyName) {
        this.companyName = companyName;
    }


    // GETTERS
    public String         getId()
    {
        return id;
    }
    public String         getCompanyName()
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
