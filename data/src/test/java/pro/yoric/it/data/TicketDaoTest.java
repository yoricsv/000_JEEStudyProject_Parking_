package pro.yoric.it.data;

import org.junit.Test;
import pro.yoric.it.pojo.Ticket;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.Assert.*;
//import static junit.framework.TestCase.assertNotNull;

public class TicketDaoTest
{
    TicketDao ticketDao;
//    private Object ticketList;

    @org.junit.Before
    public void setUp()
        throws Exception
    {
        ticketDao = new TicketDao(true);
    }

    @org.junit.After
    public void tearDown()
        throws Exception
    {
    }

    @Test
    public void testInstance()
    {
        assertNotNull(ticketDao);
    }

//    need for test Class DataSource
//    @Test
//    public void testGetConnection()
//        throws SQLException
//    {
//        Connection con = ticketDao.getConnection();
//
//        assertNotNull(con);
//        con.close();
//    }

//    @Test
//    public void testRealAllTickets()
//        throws SQLException
//    {
//        List<Ticket> ticketList = ticketDao.readAllTickets();
//
//        assertNotNull(ticketList);
//        assertEquals(1, ticketList.size());
//    }

    @Test
    public void testSaveNewTicket()
        throws SQLException
    {
        // Given
        Ticket newTicket = new Ticket();

        newTicket.setDate(new Date());
        newTicket.setLicensePlateNumber("5322HH-4");

        // When
        ticketDao.saveNewTicket(newTicket);

        // Then
        Ticket ticket = ticketDao.readAllTickets().get(0);

        assertNotNull(ticket);
        assertEquals("5322HH-4", ticket.getLicensePlateNumber());

        ticketDao.deleteAll();
    }
}