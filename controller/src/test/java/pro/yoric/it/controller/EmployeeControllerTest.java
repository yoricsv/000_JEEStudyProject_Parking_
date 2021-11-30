package pro.yoric.it.controller;

import org.junit.Assertion;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pro.yoric.it.config.ControllerSpringConfig;

@ContentConfiguration(classes = ControllerSpringConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeControllerTest
{
    @Autowired
    EmployeeController employeeController;

    @Test
    public void save()
    {
        assertNotNull(employeeController);
    }
}