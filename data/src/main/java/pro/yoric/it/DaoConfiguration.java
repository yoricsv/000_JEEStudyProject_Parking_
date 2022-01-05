package pro.yoric.it;

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

import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import java.util.Properties;


@Configuration
@EnableTransactionManagement
@PropertySource(
    value = "classpath:ds.properties"
)
@ComponentScan(
    basePackages = {
        "pro.yoric.it"//,
//        "pro.yoric.it.company",
//        "pro.yoric.it.parking"
    }
)
public class DaoConfiguration
{
    @Autowired
    private Environment environment;

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
    public Properties hibernateProperties()
    {
        Properties properties = new Properties();

        properties.setProperty(
            "hibernate.dialect",
            "org.hibernate.dialect.MySQL57Dialect"
        );
        properties.setProperty(
            "show_sql",
            "true"
        );
        properties.setProperty(
            "hibernate.hbm2ddl.auto",
            "update"
        );

        return properties;
    }

    @Bean
    public DataSource companyDataSource(Properties dataSourceProperties)
    {
        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig
        .setJdbcUrl(
            environment
            .getProperty(
                "company.url"
            )
        );
        hikariConfig
        .setUsername(
            environment
            .getProperty(
                "company.user"
            )
        );
        hikariConfig
        .setPassword(
            environment
            .getProperty(
                "company.password"
            )
        );
        hikariConfig
        .setDriverClassName(
            environment
            .getProperty(
                "jdbc.driver"
            )
        );
        hikariConfig
        .setMaximumPoolSize(
            environment
            .getProperty(
                "company.pool_size",
                Integer.class
            )
        );
        hikariConfig
        .setDataSourceProperties(
            dataSourceProperties
        );

        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public DataSource parkingDataSource(Properties dataSourceProperties)
    {
        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig
        .setJdbcUrl(
            environment
            .getProperty(
                "parking.url"
            )
        );
        hikariConfig
        .setUsername(
            environment
            .getProperty(
                "parking.user"
            )
        );
        hikariConfig
        .setPassword(
            environment
            .getProperty(
                "parking.password"
            )
        );
        hikariConfig
        .setDriverClassName(
            environment
            .getProperty(
                "jdbc.driver"
            )
        );
        hikariConfig
        .setMaximumPoolSize(
            environment
            .getProperty(
                "parking.pool_size",
                Integer.class
            )
        );
        hikariConfig
        .setDataSourceProperties(
            dataSourceProperties
        );

        return new HikariDataSource(hikariConfig);
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
