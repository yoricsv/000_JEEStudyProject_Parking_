package pro.yoric.it.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "persons")
public class Person
    implements Serializable
{
    @Id
    @Column (name = "id")
    private long id;

    @Column (name = "name")
    private String name;

    @Column (name = "second_name")
    private String secondName;

    public Person(){ }

    public long getId()
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

    public void setId(long id)
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
