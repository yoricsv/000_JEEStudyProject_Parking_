package pro.yoric.it.data;

import pro.yoric.it.pojo.Ticket;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.Assert.*;

public class TicketDaoTest
{
    // INSTANCES
    TicketDao ticketDao;

    @Before
    public void setUp()
        throws Exception
    {
        ticketDao = new TicketDao(true);
    }

    @Test
    public void testInstance()
    {
        assertNotNull(ticketDao);
    }

    @Test
    public void testSaveNewTicket()
        throws SQLException
    {
        // GIVEN
        Ticket newTicket = new Ticket();

        // TODO: id is not uuid
        newTicket.setDate(new Date());
        newTicket.setCarNumber("5322HH-4");

        // WHEN
        ticketDao.saveNewTicket(newTicket);

        // THEN
        Ticket ticket = ticketDao.readAllTickets().get(0);

        assertNotNull(ticket);
        assertEquals("5322HH-4", ticket.getCarNumber());

        ticketDao.deleteAll();
    }

    @After
    public void tearDown()
        throws Exception
    { }
}