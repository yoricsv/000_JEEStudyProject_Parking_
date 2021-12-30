package pro.yoric.it.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("pro.yoric")
public class WebConfiguration
{
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver()
    {
        InternalResourceViewResolver resolver =
            new InternalResourceViewResolver();

        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

    @Bean
    public CommonsMultipartResolver commonsMultipartResolver()
    {
        CommonsMultipartResolver multipartResolver =
            new CommonsMultipartResolver();

        multipartResolver.setMaxUploadSize(5_000_000);

        return multipartResolver;
    }
}
