package pro.yoric.it.company;
        
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * NOTE: if PATH without "/" find resource in the same name package
 * NOTE: if PATH with    "/" find resource start from package root
 *
 * EXAMPLE: cleanInsert("/pro/yoric/it/company/PayslipDaoTest.xml");
 * There is we transmit prepared data to check units operating
 */

public class PayslipDaoTest
    extends BaseDbUnitTest
{
    // INSTANCES
    private PayslipDao payslipDao;

    @Before
    public void setUp()
    {
        payslipDao = new PayslipDao(sessionFactory);
    }

    @Test
    public void getAnnualSalary()
    {
        // GIVEN
        cleanInsert("PayslipDaoTest.xml");

        // WHEN
        BigDecimal res =
            payslipDao
            .getAnnualSalary(
                "2c9682067d101492017d101495ed0000",
                (short) 2021
            );

        // THEN
        assertEquals(new BigDecimal("24420.00"), res);
    }

    @After
    public void tearDown()
    {
        payslipDao = null;
        deleteDataset();
    }
} 