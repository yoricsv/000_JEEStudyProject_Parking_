package pro.yoric.it.config;

import pro.yoric.it.company.CompanyDao;
import pro.yoric.it.company.EmployeeDao;
import pro.yoric.it.company.PayslipDao;

import pro.yoric.it.dao.IAppParkingUserDao;
import pro.yoric.it.dao.ICompanySearchDao;
import pro.yoric.it.dao.IPersonDao;
import pro.yoric.it.dao.ITicketDao;

import pro.yoric.it.parking.AppParkingUserDao;
import pro.yoric.it.parking.PersonDao;
import pro.yoric.it.parking.TicketDao;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration(
    "controllerConfiguration"
)
@ComponentScan(
    basePackages = {
        "pro.yoric.it.service",                     // might need use "pro.yoric"
        "pro.yoric.it.validator"
    }
)
@PropertySource(
    "classpath:/controller.properties"              // PATH TO controller/src/main/resources/controller.properties
)
public class ControllerSpringConfig
{
    @Value("${default.working.dir}")                // GET FROM controller/src/main/resources/controller.properties
    private String defaultWorkingDir;

    @Bean                                           // always PUBLIC (Let's register class as bean)
    public EmployeeDao employeeDao()
    {
        return new EmployeeDao();
    }

    @Bean
    public PayslipDao payslipDao()
    {
        return new PayslipDao();
    }

    @Bean
    public IAppParkingUserDao iAppParkingUserDao()
    {
        return new AppParkingUserDao();
    }

    @Bean
    public ICompanySearchDao iCompanySearchDao()
    {
        return new CompanyDao();
    }

    @Bean
    public IPersonDao iPersonDao()
    {
        return new PersonDao();
    }

    @Bean
    public ITicketDao iTicketDao()
        throws ClassNotFoundException
    {
        return new TicketDao();
    }
}
