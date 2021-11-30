package pro.yoric.it.config;

import org.springframework.beans.factory.annotation.Qualifier;
import pro.yoric.it.company.EmployeeDao;
import pro.yoric.it.company.PayslipDao;
import pro.yoric.it.controller.EmployeeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//import org.springframework.stereotype.Component; // Need for use @Component("myFirstBean") and @Configuration OR see below

import lombok.Getter;
import pro.yoric.it.validator.EmployeeValidator;

import java.util.Arrays;

// @Component("myFirstBean") // Need for use @Component("myFirstBean") and @Configuration OR see below
@Getter
@Configuration("myFirstBean")
@ComponentScan(basePackages = "pro.yoric.it.controller")
public class ControllerSpringConfig
{
    @Value("1")                                                 // property value injection
    private String id;

    @Autowired // for automatic wiring (to get any exception need add annotation into a class and need to register in context)
    private EmployeeController employeeController;

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
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        final ControllerSpringConfig myFirstBean = (ControllerSpringConfig) context.getBean("myFirstBean");
        System.out.println(myFirstBean);

        System.out.println("My first bean Id" + myFirstBean.getId()); // need add Lombok and Annotation
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
