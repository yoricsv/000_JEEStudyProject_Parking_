package pro.yoric.it.data;

import pro.yoric.it.dao.ITicketDao;
import pro.yoric.it.pojo.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * CRUD (Create Read Update Delete)
 */
public class TicketDao
    implements ITicketDao
{
    /** CREATE */
    // CONSTRUCTORS
    public TicketDao()
        throws ClassNotFoundException
    {
        this(false);
    }
    public TicketDao(boolean useTestDataSource)
            throws ClassNotFoundException
    {
        dataSource = new DataSource(useTestDataSource); // NOT NEED Class.forName("com.mysql.cj.jdbc.Driver");
    }

    /** READ */
    // GETTERS
    @Override
    public List<Ticket> readAllTickets()
        throws SQLException
    {
        Connection con = dataSource.getConnection();

        Statement st = con.createStatement();
        ResultSet rs =
            st.executeQuery(
                "SELECT "        +
                    "* "        +
                "FROM "         +
                    "t_tickets"
            );

        List<Ticket> ticketList = new ArrayList<>();

        while(rs.next())
        {
            Ticket ticket = new Ticket();

            ticket.setCarNumber(
                rs.getString(
                    "car_number"
                )
            );

            ticket.setDate(
                rs.getTimestamp(
                    "ticket_date"
                )
            );

            ticketList.add(ticket);
        }

        st.close();
        con.close();

        return ticketList;
    }
    @Override
    public Ticket       getTicketByNumber(String licensePlateNumber)
        throws SQLException
    {
        Connection con = dataSource.getConnection();

        String sql =
            "SELECT "           +
                "* "            +
            "FROM "             +
                "t_tickets "    +
            "WHERE "            +
                "car_number = '?'";

        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(
            1,
            licensePlateNumber
        );

        ResultSet rs = preparedStatement.executeQuery();

        Ticket ticket = null;

        if(rs.next())
        {
            ticket = new Ticket();

            ticket.setCarNumber(
                rs.getString("car_number")
            );
            ticket.setDate(
                rs.getTimestamp("ticket_date")
            );
        }

//        preparedStatement.executeUpdate();
        preparedStatement.close();
        con.close();

        return ticket;
    }

    /** UPDATE */
    // SETTERS
    @Override
    public void saveNewTicket(Ticket ticket)
        throws SQLException
    {
        Connection con = dataSource.getConnection();

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

        PreparedStatement preparedStatement = con.prepareStatement(sql);

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
        con.close();
    }

    /** DELETE */
    @Override
    public void deleteAll()
        throws SQLException
    {
        Connection connection = dataSource.getConnection();

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
        Connection connection = dataSource.getConnection();

        connection
        .prepareStatement(
            "DELETE FROM "       +
                "t_tickets "     +
            "WHERE "             +
                "car_number='"  +
                    number      +
                "'"
        )
        .execute();

        connection.close();
    }

    @Override
    public List<Ticket> findByPersonId(Set<Long> ids) {
        return null;
    }

    // FIELDS
    private final DataSource dataSource;
}
