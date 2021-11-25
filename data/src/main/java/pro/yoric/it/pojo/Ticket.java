package pro.yoric.it.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tickets")
public class Ticket
    implements Serializable
{
    @Column (name = "car_number")
    private String licensePlateNumber;

    @Column (name = "ticket_date")
    private   Date date;

    @Id
    @Column (name = "id")
    private long id;

    public String getLicensePlateNumber()
    {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber)
    {
        this.licensePlateNumber = licensePlateNumber;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Date getDate()
    {
        return date;
    }

    public int getId() { return (int) id; }
}

