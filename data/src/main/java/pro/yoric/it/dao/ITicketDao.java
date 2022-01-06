package pro.yoric.it.dao;

import pro.yoric.it.parking.pojo.Ticket;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface ITicketDao
{
    // CREATE
    void saveNewTicket(Ticket ticket)
        throws SQLException;

    // READ
    List<Ticket> readAllTickets   ()
        throws SQLException;
    List<Ticket> findByPersonId   (Set<Long> ids);
    Ticket       getTicketByNumber(String carNumber)
        throws SQLException;

    // DELETE
    void deleteAll()
        throws SQLException;
    void removeByNumber(String number)
        throws SQLException;
}
