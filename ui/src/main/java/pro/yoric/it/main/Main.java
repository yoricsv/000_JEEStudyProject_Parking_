package pro.yoric.it.main;

import pro.yoric.it.controller.TicketController;

public class Main
{
    public static void main(String[] args)
        throws ClassNotFoundException
    {
        // INJECTIONS
        TicketController printer = new TicketController();

        System.out.println(printer);
    }
}
