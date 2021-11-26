package pro.yoric.it.data;

import pro.yoric.it.pojo.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * CRUD (Create Read Update Delete)
 */
public class TicketDao
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
    public List<Ticket> readAllTickets()
        throws SQLException
    {
        Connection con = dataSource.getConnection();

        Statement st = con.createStatement();
        ResultSet rs =
            st.executeQuery(
                "SELECT"    +
                    "* "        +
                "FROM "         +
                    "tickets"
            );

        List<Ticket> ticketList = new ArrayList<>();

        while(rs.next())
        {
            Ticket ticket = new Ticket();

            ticket.setLicensePlateNumber(
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
    public Ticket getTicketByNumber(String licensePlateNumber)
        throws SQLException
    {
        Connection con = dataSource.getConnection();

        String sql =
            "SELECT "       +
                "* "        +
            "FROM "         +
                "tickets "  +
            "WHERE "        +
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

            ticket.setLicensePlateNumber(
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
    public void saveNewTicket(Ticket ticket)
        throws SQLException
    {
        Connection con = dataSource.getConnection();

//        String sql =
//            "INSERT INTO "                      +
//                 "parking.ticket "              +
//            "VALUES ("                          +
//                 ticket.getDate()               +
//                 ", "                           +
//                 ticket.getLicensePlateNumber() +
//             ")";
        String sql =
            "INSERT INTO " +
                "tickets " +
            "VALUES " +
                "(?, ?, ?)";

        PreparedStatement preparedStatement =con.prepareStatement(sql); //        preparedStatement.setDate (1, new Date(ticket.getDate().getTime()));                       // get Date

        preparedStatement.setTimestamp(
            1,
            new Timestamp(
                    ticket.getDate().getTime()
            )
        );  // get Data & Time
        preparedStatement.setString(
            2,
            ticket.getLicensePlateNumber()
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
    public void deleteAll()
        throws SQLException
    {
        Connection connection = dataSource.getConnection();

        connection
        .prepareStatement(
            "TRUNCATE TABLE tickets"
        )
        .execute();

        connection.close();
    }
    public void removeByNumber(String number)
        throws SQLException
    {
        Connection connection = dataSource.getConnection();

        connection
        .prepareStatement(
            "DELETE FROM"   +
                "tickets"       +
            "WHERE"             +
                "car_number='"  +
                    number      +
                "'"
        )
        .execute();

        connection.close();
    }

    private final DataSource dataSource;
}
