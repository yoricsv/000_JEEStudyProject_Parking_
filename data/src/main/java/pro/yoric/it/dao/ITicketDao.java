package pro.yoric.it.dao;

import pro.yoric.it.pojo.Ticket;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface ITicketDao
{
    // GETTERS
    List<Ticket> readAllTickets()
            throws SQLException;

    Ticket getTicketByNumber(String licensePlateNumber)
            throws SQLException;

    // SETTERS
    void saveNewTicket(Ticket ticket)
            throws SQLException;

    void deleteAll()
            throws SQLException;

    void removeByNumber(String number)
            throws SQLException;

    List<Ticket> findByPersonId(Set<Long> ids);
}
