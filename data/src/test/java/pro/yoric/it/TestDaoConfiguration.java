package pro.yoric.it;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(
    value = "classpath:ds-test.properties"
)
@ComponentScan(basePackages = {"pro.yoric.it.company", "pro.yoric.it.parking"})
public class TestDaoConfiguration
{
}
