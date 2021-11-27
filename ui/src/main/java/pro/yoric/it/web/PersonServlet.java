package pro.yoric.it.web;

import pro.yoric.it.controller.PersonController;
import pro.yoric.it.pojo.Person;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(
    name        = "personServlet",
    urlPatterns = "/person"
)
public class PersonServlet
    extends HttpServlet
{
    @Override
    public void init()
        throws ServletException
    {
        super.init();

        personController = new PersonController();
    }

    @Override
    protected void doGet(
            HttpServletRequest  req,
            HttpServletResponse resp
        )
        throws
            ServletException,
            IOException
    {
        String command = req.getParameter("command");

        if("new".equals(command))
        {
            Person person = new Person();

            person.setName(
                req.getParameter(
                    "name"
                )
            );

            person.setSecondName(
                req.getParameter(
                    "second_name"
                )
            );

            List<String> errors =
                personController
                .saveNewPerson(
                    person
                );

            if(errors.isEmpty())
                req
                .getRequestDispatcher(
                    "/person.jsp"
                )
                .forward(
                    req,
                    resp
                );
            else
            {
                req
                .setAttribute(
                    "errors",
                    errors
                );

                req
                .getRequestDispatcher(
                    "/add-person.jsp"
                )
                .forward(
                    req,
                    resp
                );
            }
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

    // FIELDS
    private  PersonController personController;
}
