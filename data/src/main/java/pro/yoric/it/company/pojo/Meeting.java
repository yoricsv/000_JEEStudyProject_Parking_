package pro.yoric.it.company.pojo;

import org.hibernate.annotations.GenericGenerator;
import pro.yoric.it.company.pojo.Employee;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

// TABLE
@Entity
@Table(name = "t_meetings")
public class Meeting
{
    // FIELDS
    @Id
    @Column(name  = "meeting_id")
    @GeneratedValue(
        generator = "uuid-generator"
    )
    @GenericGenerator(
        name      = "uuid-generator",
        strategy  = "uuid"
    )
    private String id;

    @Column(name  = "subject")
    private String subject;

    @Column(name  = "meeting_date")
    private Date   meetingDate;

    // FIELDS RELATIONS
    @OneToMany(
        mappedBy  = "company"
    )
    private List<Employee> employees;

    @OneToMany(
        mappedBy  = "meetings"
    )
    private List<Employee> attendees;


    // CONSTRUCTORS
    public Meeting(){ }
    public Meeting(
            String subject,
            Date   meetingDate
        )
    {
        this.subject     = subject;
        this.meetingDate = meetingDate;
    }


    // GETTERS
    public String         getId() {
        return id;
    }
    public String         getSubject() {
        return subject;
    }
    public Date           getMeetingDate() {
        return meetingDate;
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public List<Employee> getAttendees() {
        return attendees;
    }


    // SETTERS
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    public void setAttendees(List<Employee> attendees) {
        this.attendees = attendees;
    }
}
