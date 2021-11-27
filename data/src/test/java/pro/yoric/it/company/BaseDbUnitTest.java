package pro.yoric.it.company;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.io.IOException;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDbUnitTest
    extends BaseTest
{
    // INSTANCES
    private IDatabaseConnection connection;
    private IDataSet            dataSet;

    public void cleanInsert(String resourceName)
    {
        try
        {
            if (connection == null)
            {
                connection =
                    new MySqlConnection(
                        MySqlDataSource
                        .getTestConnection(),
                            "company_test"
                        );
            }

            dataSet =
                new FlatXmlDataSetBuilder()
                    .build(
                        BaseTest.class
                        .getResourceAsStream(
                            resourceName
                        )
                    );

            DatabaseOperation.CLEAN_INSERT.execute(
                connection,
                dataSet
            );
        }
        catch (SQLException | DatabaseUnitException e)
        {
            log.log(
                Level.SEVERE,
                e.getMessage(),
                e
            );
        }
    }

    public void deleteDataset()
    {
        try
        {
            DatabaseOperation.DELETE.execute(
                connection,
                dataSet
            );

            connection.close();
        }
        catch (SQLException | DatabaseUnitException e)
        {
            log.log(
                Level.SEVERE,
                e.getMessage(),
                e
            );
        }
    }

    // LOGGER
    private final static Logger log =
        Logger.getLogger(
            BaseDbUnitTest.class.getName()
        );
}

class MySqlDataSource
{
    // INSTANCES
    private static final Properties properties = new Properties();

    public static Connection getTestConnection()
            throws SQLException
    {
        return
            DriverManager.getConnection(
                properties.getProperty("url"),
                properties
            );
    }

    // LOGGER
    private final static Logger log =
        Logger
        .getLogger(
            MySqlDataSource.class.getName()
        );

    static
    {
        try
        {
            properties.load(
                MySqlDataSource.class
                .getResourceAsStream(
                    "/company_test.ds.properties"
                )
            );

            Class.forName(
                properties
                .getProperty(
                    "jdbc.drivers"
                )
            );
        }
        catch (ClassNotFoundException | IOException e)
        {
            log.log(
                Level.SEVERE,
                e.getMessage(),
                e
            );
        }
    }
}