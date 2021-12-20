package pro.yoric.it.config;

import pro.yoric.it.company.EmployeeDao;
import pro.yoric.it.company.PayslipDao;
import pro.yoric.it.service.EmployeeService;

import pro.yoric.it.validator.EmployeeValidator;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.Arrays;

// @Component("myFirstBean") // Need for use @Component("myFirstBean") and @Configuration OR see below
@Getter
@Configuration("myFirstBean")
@ComponentScan(basePackages = "pro.yoric.it")
@PropertySource("classpath:/controller.properties")
public class ControllerSpringConfig
{
    @Value("default.working.dir") // Forbidden use '--' in name
    private String defaultWorkingDir;

    @Value("1.0")                                                 // property value injection
    private Double id;

    @Autowired // for automatic wiring (to get any exception need add annotation into a class and need to register in context)
    private EmployeeService employeeController;

    @Autowired // for automatic wiring (to get any exception need add annotation into a class and need to register in context)
    @Qualifier("employeeValidator")
    private EmployeeValidator employeeValidator;

    public static void main(String... args)
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        context.register(ControllerSpringConfig.class);
        context.refresh();

        System.out.println(context.getBeanDefinitionCount());

        Arrays
        .stream(
            context
            .getBeanDefinitionNames()
        )
        .forEach(
            System.out::println
        );

        final ControllerSpringConfig myFirstBean =
            (ControllerSpringConfig) context.getBean(
                "myFirstBean"
            );
        System.out.println(myFirstBean);

        System.out.println(
            "My first bean Id = " +
            myFirstBean.getId()             // need add Lombok and Annotation
        );

        myFirstBean.getEmployeeValidator().validate(null);

        System.out.println(
            "Default working dir :" +
            myFirstBean.getDefaultWorkingDir()
        );
    }

    @Bean // always PUBLIC (Let to registering class as bean)
    public EmployeeDao employeeDao()
    {
        return new EmployeeDao();
    }
    @Bean
    public PayslipDao payslipDao()
    {
        return new PayslipDao();
    }
}
