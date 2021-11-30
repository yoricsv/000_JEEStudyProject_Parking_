package pro.yoric.it.ui;

import pro.yoric.it.controller.TicketController;

public class Main
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        TicketController printer = new TicketController();
//        Ticket ticket = printer.printTicket("A1020-7 AA", "2021-09-25 21:20:23");

        System.out.println(printer);
    }
}
