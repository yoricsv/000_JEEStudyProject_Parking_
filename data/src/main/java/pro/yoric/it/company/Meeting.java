package pro.yoric.it.company;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_MEETING")
public class Meeting
{
    @Id
    @Column(name = "MEETING_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees;
    @Column(name = "SUBJECT")
    private String subject;
    @Column(name = "MEETING_DATE")
    private Date meetingDate;

    @OneToMany(mappedBy = "meetings")
    private List<Employee> attendees;

    public Meeting(
            String subject,
            Date meetingDate
        )
    {
        this.subject = subject;
        this.meetingDate = meetingDate;
    }

    public Meeting() { }

    public String getId() {
        return id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getSubject() {
        return subject;
    }

    public Date getMeetingDate() {
        return meetingDate;
    }

    public List<Employee> getAttendees() {
        return attendees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }

    public void setAttendees(List<Employee> attendees) {
        this.attendees = attendees;
    }
}
