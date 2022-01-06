package pro.yoric.it.parking;

import pro.yoric.it.dao.ITicketDao;

import pro.yoric.it.parking.pojo.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * CRUD (Create Read Update Delete)
 */
@Repository
public class TicketDao
    implements ITicketDao
{
    @Autowired
    @Qualifier("parkingDataSource")
    private DataSource parkingDataSource;

    /** CREATE */
    // CONSTRUCTORS (WILL CREATE BY SPRING)
//    public TicketDao()
//        throws ClassNotFoundException
//    {
//        this(false);
//    }
//    public TicketDao(boolean useTestDataSource)
//            throws ClassNotFoundException
//    {
//        dataSource = new DataSource(useTestDataSource); // NOT NEED Class.forName("com.mysql.cj.jdbc.Driver");
//    }

    /** READ */
    // GETTERS
    @Override
    public List<Ticket> readAllTickets()
        throws SQLException
    {
        Connection connection = parkingDataSource.getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet =
            statement.executeQuery(
                "SELECT "        +
                    "* "        +
                "FROM "         +
                    "t_tickets"
            );

        List<Ticket> ticketList = new ArrayList<>();

        while(resultSet.next())
        {
            Ticket ticket = new Ticket();

            ticket.setCarNumber(
                resultSet.getString(
                    "car_number"
                )
            );

            ticket.setDate(
                resultSet.getTimestamp(
                    "ticket_date"
                )
            );

            ticketList.add(ticket);
        }

        statement.close();
        connection.close();
        return ticketList;
    }

    @Override
    public List<Ticket> findByPersonId(Set<Long> ids) {
        return null;
    }

    @Override
    public Ticket       getTicketByNumber(String licensePlateNumber)
        throws SQLException
    {
        Connection connection = parkingDataSource.getConnection();

        String sql =
            "SELECT "           +
                "* "            +
            "FROM "             +
                "t_tickets "    +
            "WHERE "            +
                "car_number = '?'";

        PreparedStatement preparedStatement =
            connection.prepareStatement(sql);

        preparedStatement.setString(
            1,
            licensePlateNumber
        );

        ResultSet resultSets = preparedStatement.executeQuery();

        Ticket ticket = null;

        if(resultSets.next())
        {
            ticket = new Ticket();

            ticket.setCarNumber(
                resultSets.getString(
                    "car_number"
                )
            );
            ticket.setDate(
                resultSets.getTimestamp(
                    "ticket_date"
                )
            );
        }

//        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return ticket;
    }

    /** UPDATE */
    // SETTERS
    @Override
    public void saveNewTicket(Ticket ticket)
        throws SQLException
    {
        Connection connection = parkingDataSource.getConnection();

//        String sql =
//            "INSERT INTO "             +
//                 "parking.t_ticket "   +
//            "VALUES ("                 +
//                 ticket.getDate()      +
//                 ", "                  +
//                 ticket.getCarNumber() +
//             ")";
        String sql =
            "INSERT INTO "      +
                "t_tickets "    +
            "VALUES "           +
                "(?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setTimestamp(
            1,
            new Timestamp(
                ticket.getDate().getTime()
            )
        );  // get Data & Time
        preparedStatement.setString(
            2,
            ticket.getCarNumber()
        );
        preparedStatement.setString(
            3,
            String.valueOf(ticket.getId())
        );

        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

    /** DELETE */
    @Override
    public void deleteAll()
        throws SQLException
    {
        Connection connection = parkingDataSource.getConnection();

        connection
        .prepareStatement(
            "TRUNCATE TABLE t_tickets"
        )
        .execute();

        connection.close();
    }
    @Override
    public void removeByNumber(String number)
        throws SQLException
    {
        Connection connection = parkingDataSource.getConnection();

        connection
        .prepareStatement(
            "DELETE FROM "       +
                "t_tickets "     +
            "WHERE "             +
                "car_number=\""  +  number +
                "\""
        )
        .execute();

        connection.close();
    }
}
