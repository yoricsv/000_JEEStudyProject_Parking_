package pro.yoric.it.controller;

import pro.yoric.it.pojo.Ticket;
import pro.yoric.it.data.TicketDao;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketController
{
    // INJECTIONS
    TicketDao ticketDao;

    // CONSTRUCTORS
    public TicketController()
        throws ClassNotFoundException
    {
        ticketDao = new TicketDao();
    }

    // CONTROLLERS
    public List<String> handleTicketRequest(
            String number,
            Date   currentDate
        )
        throws SQLException
    {
        List<String> messeges = new ArrayList<>();

        // Validation
        if (ticketDao.getTicketByNumber(number) != null)
        {
            Date startDate =
                ticketDao
                .getTicketByNumber(number)
                .getDate();

            ticketDao.removeByNumber(number);

            long seconds = (currentDate.getTime() - startDate.getTime()) / 1000;

            messeges.add(
                "Your stayed in our parking: "
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

            ticketDao.saveNewTicket(ticket);

            messeges.add(
                "Welcome to our Parking!"
            );
            messeges.add(
                currentDate.toString()
            );
        }

        return messeges;
    }
}
