package pro.yoric.it.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "persons")
public class Person
    implements Serializable
{
    // FIELDS
    @Id
    @Column (name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "second_name", length = 500)
    private String secondName;

    // CONSTRUCTORS
    public Person(){ }

    // GETTERS
    public Long getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getSecondName()
    {
        return secondName;
    }

    // SETTERS
    public void setId(Long id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setSecondName(String secondName)
    {
        this.secondName = secondName;
    }
}
