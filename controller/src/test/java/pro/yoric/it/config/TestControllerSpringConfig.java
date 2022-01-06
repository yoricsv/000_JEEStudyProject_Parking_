package pro.yoric.it.config;

import pro.yoric.it.dao.*;

import lombok.Getter;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@ComponentScan(
    basePackages = {
        "pro.yoric.it.service",
        "pro.yoric.it.validator"
    }
)
@PropertySource(
    "classpath:/controller.properties"
)
public class TestControllerSpringConfig
{
    @Mock
    IEmployeeDao employeeDao;
    @Mock
    IPayslipDao payslipDao;
    @Mock
    IPersonDao personDao;
    @Mock
    IAppParkingUserDao appParkingUserDao;
    @Mock
    ICompanySearchDao companySearchDao;
    @Mock
    ITicketDao ticketDao;

    @Value(
        "${default.working.dir}"
    )
    private String defaultWorkingDir;

    public TestControllerSpringConfig()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Bean
    public IEmployeeDao employeeDao()
    {
        return employeeDao;
    }
    @Bean
    public IPayslipDao payslipDao()
    {
        return payslipDao;
    }
    @Bean
    public IPersonDao personDao()
    {
        return personDao;
    }
    @Bean
    public IAppParkingUserDao appParkingUserDao()
    {
        return appParkingUserDao;
    }
    @Bean
    public ICompanySearchDao companySearchDao()
    {
        return companySearchDao;
    }
    @Bean
    public ITicketDao ticketDao()
    {
        return ticketDao;
    }
}
