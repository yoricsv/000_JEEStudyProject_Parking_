package pro.yoric.it.ui.web;

import pro.yoric.it.controller.TicketController;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import java.sql.SQLException;

@WebServlet(name = "parkingServlet", urlPatterns = "/parking")
public class ParkingServlet
    extends HttpServlet
{
//    private  HashMap<Object, Object> map = new HashMap<>();
//    private TicketDao ticketDao;

    private TicketController controller;

    @Override
    public void init(
        ServletConfig config
        )
        throws ServletException
    {
        super.init(config);

        try
        {
            controller = new TicketController();
        }
        catch (ClassNotFoundException e)
        {
            throw new ServletException(
                e.getMessage(),
                e
            );
        }
    }
    @Override
    public void doGet(
            HttpServletRequest  req,
            HttpServletResponse resp
        )
    {
        try
        {
            HttpSession session = req.getSession();
            PrintWriter writer  = resp.getWriter();
            String number       = req.getParameter("number");
            Date currentDate    = new Date();

            List <String> messages =
                controller
                .handleTicketRequest(
                    number,
                    currentDate
                );

            resp.setContentType("text/html");
            messages.forEach(writer::println);

            writer.println(
                "Car Number: " + number
            );

            session.setAttribute("number", number);
            addParkingCookies(resp, number);
        }
        catch (IOException | SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,
                   IOException
    {
        doGet(req, resp);
    }
    private void addParkingCookies( HttpServletResponse resp,
                                    String number)
    {
        Cookie cookie = new Cookie("PLATENUMBER", number);
        cookie.setMaxAge(300);
        resp.addCookie(cookie);
    }
}
