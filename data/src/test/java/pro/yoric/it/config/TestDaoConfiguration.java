package pro.yoric.it.config;

import pro.yoric.it.company.pojo.*;

import pro.yoric.it.parking.pojo.*;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import org.springframework.core.env.Environment;

import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

import java.util.Properties;

@Configuration
@PropertySource(
    value = "classpath:ds-test.properties"
)
@ComponentScan(
    basePackages = {
        "pro.yoric.it.company",
        "pro.yoric.it.parking"
    }
)
public class TestDaoConfiguration
{
    @Autowired
    Environment environment;

    @Bean
    public Properties dataSourceProperties()
    {
        Properties properties = new Properties();

        properties.setProperty(
            "useSSL",
            environment.getProperty(
                "useSSL"
            )
        );
        properties.setProperty(
            "serverTimezone",
            environment.getProperty(
                "serverTimezone"
            )
        );
        properties.setProperty(
            "createDatabaseIfNotExist",
            environment.getProperty(
                "createDatabaseIfNotExist"
            )
        );

        return properties;
    }


    @Bean
    public DataSource companyDataSource(Properties dataSourceProperties)
    {
        HikariConfig config = new HikariConfig();

        config
        .setJdbcUrl(
            environment
            .getProperty(
                "company.url"
            )
        );
        config
        .setUsername(
            environment
            .getProperty(
                "company.user"
            )
        );
        config
        .setPassword(
            environment
            .getProperty(
                "company.password"
            )
        );
        config
        .setDriverClassName(
            environment
            .getProperty(
                "jdbc.driver"
            )
        );
        config
        .setMaximumPoolSize(
            environment
            .getProperty(
                "company.pool_size",
                Integer.class
            )
        );
        config
        .setDataSourceProperties(
            dataSourceProperties
        );

        return new HikariDataSource(config);
    }


    @Bean
    public DataSource parkingDataSource(Properties dataSourceProperties)
    {
        HikariConfig config = new HikariConfig();

        config
        .setJdbcUrl(
            environment
            .getProperty(
                "parking.url"
            )
        );
        config
        .setUsername(
            environment
            .getProperty(
                "parking.user"
            )
        );
        config
        .setPassword(
            environment
            .getProperty(
                "parking.password"
            )
        );
        config
        .setDriverClassName(
            environment
            .getProperty(
                "jdbc.driver"
            )
        );
        config
        .setMaximumPoolSize(
            environment
            .getProperty(
                "parking.pool_size",
                Integer.class
            )
        );
        config
        .setDataSourceProperties(
            dataSourceProperties
        );

        return new HikariDataSource(config);
    }

    @Bean
    public LocalSessionFactoryBean companySessionFactory(
            @Qualifier("companyDataSource")
            DataSource dataSource,
            Properties hibernateProperties
        )
    {
        LocalSessionFactoryBean sessionFactory =
            new LocalSessionFactoryBean();

        sessionFactory
        .setDataSource(
            dataSource
        );
        sessionFactory
        .setHibernateProperties(
            hibernateProperties
        );

        sessionFactory
        .setAnnotatedPackages(
            "pro.yoric.it.company.pojo"
        );
        sessionFactory
        .setAnnotatedClasses(
            Company.class,
            Employee.class,
            EmployeeDetails.class,
            Meeting.class,
            Payslip.class
        );

        return sessionFactory;
    }

    @Bean
    public LocalSessionFactoryBean parkingSessionFactory(
            @Qualifier("parkingDataSource")
            DataSource dataSource,
            Properties hibernateProperties
        )
    {
        LocalSessionFactoryBean sessionFactory =
            new LocalSessionFactoryBean();

        sessionFactory
        .setDataSource(
            dataSource
        );
        sessionFactory
        .setHibernateProperties(
            hibernateProperties
        );

        sessionFactory
        .setAnnotatedPackages(
            "pro.yoric.it.parking.pojo"
        );
        sessionFactory
        .setAnnotatedClasses(
            AppParkingUser.class,
            Person.class,
            Ticket.class
        );

        return sessionFactory;
    }
}