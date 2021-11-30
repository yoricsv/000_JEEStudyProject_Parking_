package pro.yoric.it.company;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import static org.junit.Assert.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MeetingTest
    extends BaseTest
{
    private static Meeting meeting(int count)
    {
        return new Meeting("Subject " + count, new Date());
    }

    public static Employee employee (int count)
    {
        return new Employee(
            "Name" + count,
            "SecondName" + count,
            "+80292134112");
    }

    public static void addEmployeeToMeeting(
            Meeting meeting,
            List<Employee> attendees
        )
    {
        for(Employee employee : attendees)
        employee.getMeetings().add(meeting);
        meeting.setAttendees(attendees);
    }

    @Test
    public void saveMeetings()
    {
        // Given
        Meeting meeting1 = meeting(1);
        Meeting meeting2 = meeting(2);
        Meeting meeting3 = meeting(3);

        Employee employee1 = employee(1);
        Employee employee2 = employee(2);
        Employee employee3 = employee(3);
        Employee employee4 = employee(4);
        Employee employee5 = employee(5);

        addEmployeeToMeeting(meeting1, List.of(employee1, employee2));
        addEmployeeToMeeting(meeting2, List.of(employee1, employee3));
        addEmployeeToMeeting(meeting3, List.of(employee2, employee4, employee5));

        // When
        Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        Serializable mId1 = session.save(meeting1);
        Serializable mId2 = session.save(meeting2);
        Serializable mId3 = session.save(meeting3);

        session.save(meeting1);
        session.save(meeting2);
        session.save(meeting3);

        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        session.save(employee3);
        session.save(employee4);

        transaction.commit();
        session.close();

        // Then
        Session newSession = sessionFactory.openSession();
        Meeting savedMeeting3 = newSession.get(Meeting.class, mId3);

        // Check
        assertNotNull(savedMeeting3);
//        assertNotNull();
        newSession.close();
    }
}