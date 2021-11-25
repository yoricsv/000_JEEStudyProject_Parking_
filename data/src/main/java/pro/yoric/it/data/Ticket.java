package pro.yoric.it.data;

import java.io.Serializable;
import java.util.Date;

public class Ticket
    implements Serializable
{
    private String licensePlateNumber;
    private   Date date;

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
}

