package pro.yoric.it.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "t_persons")                      // to check, see: data/src/main/resources/changelog-parking.xml
@Getter
@Setter
public class Person
    implements Serializable
{
    // FIELDS
    @Id
    @Column (name = "person_id")
    private Long   id;

    @Column (name = "name")
    private String name;

    @Column (name = "second_name", length = 500)
    private String secondName;

//    // RELATIONS
//    @OneToOne
//    @JoinColumn(name = "person_id")
//    private Person person;


//    // CONSTRUCTORS
//    public Person(){ }

/** Getters and Setters will generate by Lombok via Annotation */
    // GETTERS
//    public Long   getId()
//    {
//        return id;
//    }
//    public String getName()
//    {
//        return name;
//    }
//    public String getSecondName()
//    {
//        return secondName;
//    }


    // SETTERS
//    public void setId(Long id)
//    {
//        this.id = id;
//    }
//    public void setName(String name)
//    {
//        this.name = name;
//    }
//    public void setSecondName(String secondName)
//    {
//        this.secondName = secondName;
//    }
}
