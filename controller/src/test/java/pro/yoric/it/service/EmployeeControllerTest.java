package pro.yoric.it.service;

import pro.yoric.it.config.TestControllerSpringConfig;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(
    classes = {
        TestControllerSpringConfig.class
    }
)
@RunWith(
    SpringJUnit4ClassRunner.class
)
public class EmployeeControllerTest
{
    @Autowired
    EmployeeService employeeController;

    @Test
    public void save()
    {
        assertNotNull(employeeController);
    }
}