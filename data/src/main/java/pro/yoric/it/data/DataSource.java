package pro.yoric.it.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource
{
    // CONSTRUCTOR
    public DataSource(boolean useTestDataSource)
    {
        this.useTestDataSource = useTestDataSource;
    }

    public Connection getConnection()
        throws SQLException
    {
        return
            DriverManager
            .getConnection(
                useTestDataSource                           ?
                "jdbc:mysql://localhost:3306/parking_test"  :
                "jdbc:mysql://localhost:3306/parking",
                "root",
                "root"
            );
    }

    // FIELDS
    private final boolean useTestDataSource;
}
