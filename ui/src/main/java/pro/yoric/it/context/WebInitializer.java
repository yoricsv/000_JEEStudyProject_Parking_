package pro.yoric.it.context;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

public class WebInitializer
    implements ServletContainerInitializer
{
    @Override
    public void onStartup(
            Set<Class<?>>  set,
            ServletContext servletContext
        )
        throws ServletException
    {
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(WebConfiguration.class);       //Init and load context

        DispatcherServlet servlet =
            new DispatcherServlet(context);

        final ServletRegistration.Dynamic dispatcher =
            servletContext.addServlet(
                "dispatcher",
                servlet
            );

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(
            "*.html",
            "*.do"
        );
    }


}
