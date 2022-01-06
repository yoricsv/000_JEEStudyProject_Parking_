package pro.yoric.it.parking;

import pro.yoric.it.config.TestDaoConfiguration;

import pro.yoric.it.dao.ITicketDao;

import pro.yoric.it.parking.pojo.Ticket;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(
    classes = TestDaoConfiguration.class
)
@RunWith(
    SpringJUnit4ClassRunner.class
)
public class TicketDaoTest
{
    // INSTANCES
    @Autowired
    ITicketDao ticketDao;

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
}