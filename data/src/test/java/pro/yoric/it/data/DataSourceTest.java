package pro.yoric.it.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DataSourceTest
{
    // INSTANCES
    DataSource dataSourceTroubleshoot;

    @Before
    public void setUp()
    {
        dataSourceTroubleshoot = new DataSource(true);
    }

    @Test
    public void testInstance()
    {
        assertNotNull(dataSourceTroubleshoot);
    }

    @Test
    public void testGetConnection()
        throws SQLException
    {
        // GIVEN
        Connection connection = dataSourceTroubleshoot.getConnection();

        // THEN
        assertNotNull(connection);
        assertTrue(connection.isValid(1));
        assertFalse(connection.isClosed());

        connection.close();
    }

    @After
    public void close()
        throws SQLException
    {
    }
}



