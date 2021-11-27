package pro.yoric.it.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_tickets")
public class Ticket
    implements Serializable
{
    // FIELDS
    @Id
    @Column (name = "tickets_id")
    private long id;

    @Column (name = "car_number")
    private String carNumber;

    @Column (name = "ticket_date")
    private   Date date;

    // GETTERS
    public long   getId() { return id; }
    public String getCarNumber()
    {
        return carNumber;
    }
    public Date   getDate()
    {
        return date;
    }

    //SETTERS
    public void setId(long id) {
        this.id = id;
    }
    public void setDate(Date date)
    {
        this.date = date;
    }
    public void setCarNumber(String carNumber)
    {
        this.carNumber = carNumber;
    }
}

