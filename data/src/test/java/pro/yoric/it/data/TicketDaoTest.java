package pro.yoric.it.data;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pro.yoric.it.parking.TicketDao;
import pro.yoric.it.parking.pojo.Ticket;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.Assert.*;

@ContextConfiguration(
        classes = ControllerSpringConfig.class
)
@RunWith(
        SpringJUnit4ClassRunner.class
)
public class TicketDaoTest
{
    // INSTANCES
    @Autowired
    TicketDao ticketDao;

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

    @org.junit.AfterClass
    public void tearDown()
        throws Exception
    {
        ticketDao = null;
    }
}