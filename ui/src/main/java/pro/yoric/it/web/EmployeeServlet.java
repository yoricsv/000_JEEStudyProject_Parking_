package pro.yoric.it.web;

import pro.yoric.it.company.Employee;
import pro.yoric.it.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EmployeeServlet
    extends HttpServlet
{
    // INJECTIONS
    EmployeeService employeeController =
        new EmployeeService(
            null,
            null
        );

    @Override
    protected void doGet(
            HttpServletRequest  req,
            HttpServletResponse resp
        )
        throws
            ServletException,
            IOException
    {
        if ("add-new.employee".equals(
                    req.getParameter("command")
                )
            )
        {
            Employee employee =
                new Employee(
                    req.getParameter("firstName"),
                    req.getParameter("secondName"),
                    req.getParameter("phoneNumber")
            );

            boolean result = employeeController.save(employee);
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest  req,
            HttpServletResponse resp
    )
            throws
            ServletException,
            IOException
    {
        doGet(req, resp);
    }
}
