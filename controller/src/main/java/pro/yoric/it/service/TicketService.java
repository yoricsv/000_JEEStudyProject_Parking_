package pro.yoric.it.service;

import pro.yoric.it.dao.ITicketDao;

import pro.yoric.it.parking.pojo.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService
{
    // INJECTIONS
    @Autowired
    private ITicketDao iTicketDao;


    // CONTROLLERS (SERVICES)
    public List<String> handleTicketRequest(
            String number,
            Date   currentDate
        )
        throws SQLException
    {
        List<String> messeges = new ArrayList<>();

        // Validation
        if (iTicketDao.getTicketByNumber(number) != null)
        {
            Date startDate =
                iTicketDao
                .getTicketByNumber(number)
                .getDate();

            iTicketDao.removeByNumber(number);

            long seconds = (currentDate.getTime() - startDate.getTime()) / 1000;

            messeges.add(
                "You were in our parking lot: "
            );
            messeges.add(
                seconds + " seconds"
            );
        }
        else
        {
            Ticket ticket = new Ticket();

            ticket.setCarNumber(number);
            ticket.setDate(currentDate);

            iTicketDao.saveNewTicket(ticket);

            messeges.add(
                "Welcome to our Parking lot!"
            );
            messeges.add(
                currentDate.toString()
            );
        }

        return messeges;
    }
}
