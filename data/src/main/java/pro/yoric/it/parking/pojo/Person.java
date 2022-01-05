package pro.yoric.it.parking.pojo;

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

    @Column (name = "surname", length = 500)
    private String surname;

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
//    public String getSurname()
//    {
//        return surname;
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
//    public void setSurname(String surname)
//    {
//        this.surname = surname;
//    }
}
