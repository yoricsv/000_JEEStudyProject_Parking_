package pro.yoric.it.parking.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

import java.util.Date;

@Entity
@Table(
    name = "t_tickets"
)
@Getter
@Setter
public class Ticket
    implements Serializable
{
    // FIELDS
    @Id
    @Column(
        name = "tickets_id"
    )
    private long   id;

    @Column(
        name = "car_number"
    )
    private String carNumber;

    @Column(
        name = "ticket_date"
    )
    private   Date date;

    // RELATIONS
    @ManyToOne
    @JoinColumn(
        name = "person_id"
    )
    private Person person;

    /** Getters and Setters will generate by Lombok via Annotation */
//    // GETTERS
//    public long   getId() { return id; }
//    public String getCarNumber()
//    {
//        return carNumber;
//    }
//    public Date   getDate()
//    {
//        return date;
//    }
//
//    //SETTERS
//    public void setId(long id) {
//        this.id = id;
//    }
//    public void setDate(Date date)
//    {
//        this.date = date;
//    }
//    public void setCarNumber(String carNumber)
//    {
//        this.carNumber = carNumber;
//    }
}

