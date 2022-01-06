package pro.yoric.it.company;

import pro.yoric.it.config.TestDaoConfiguration;
import pro.yoric.it.dao.IPayslipDao;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * NOTE: if PATH without "/" find resource in the same name package
 * NOTE: if PATH with    "/" find resource start from package root
 *
 * EXAMPLE: cleanInsert("/pro/yoric/it/company/PayslipDaoTest.xml");
 * There is we transmit prepared data to check units operating
 */
@ContextConfiguration(
    classes = TestDaoConfiguration.class
)
@RunWith(
    SpringJUnit4ClassRunner.class
)
public class PayslipDaoTest
    extends BaseDbUnitTest
{
    // INSTANCES
    @Autowired
    Environment environment;
    @Autowired
    private IPayslipDao payslipDao;

    @Test
    public void getAnnualSalary()
    {
        System.out.println(
            "company.url="   +
            environment
            .getProperty(
                "company.url"
            )
        );

        // GIVEN
//        cleanInsert("PayslipDaoTest.xml");
        cleanInsert("/pro/yoric/it/company/PayslipDaoTest.xml");

        // WHEN
        BigDecimal res =
            payslipDao
            .getAnnualSalary(
                "2c9682067d101492017d101495ed0000",
                (short) 2021
            );

        // THEN
        assertEquals(new BigDecimal("22405.00"), res);
    }

    @After
    public void tearDown()
    {
        payslipDao = null;
//        deleteDataset();
    }
} 