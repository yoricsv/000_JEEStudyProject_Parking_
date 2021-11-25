package pro.yoric.it.ui.web;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pro.yoric.it.company.Employee;

public class EmployeeServlet
    extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        if("add-new.employee".equals(req.getAuthType(command)))
        {
            Employee employee = new Employee(
                    req.getParameter("firstName"),
                    req.getParameter("secondName"),
                    req.getParameter("phoneNumber")
            );
        }
    }
}
