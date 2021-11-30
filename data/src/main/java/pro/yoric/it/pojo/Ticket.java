package pro.yoric.it.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "T_TICKETS")
public class Ticket
    implements Serializable
{
    // FIELDS
    @Id
    @Column (name = "TICKETS_ID")
    private long id;

    @Column (name = "CAR_NUMBER")
    private String licensePlateNumber;

    @Column (name = "TICKET_DATE")
    private   Date date;

    // GETTERS
    public long getId() { return id; }
    public String getLicensePlateNumber()
    {
        return licensePlateNumber;
    }
    public Date getDate()
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
    public void setLicensePlateNumber(String licensePlateNumber)
    {
        this.licensePlateNumber = licensePlateNumber;
    }
}

