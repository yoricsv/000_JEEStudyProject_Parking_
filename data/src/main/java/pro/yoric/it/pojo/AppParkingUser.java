package pro.yoric.it.pojo;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(
    name = "t_app_parking_users"
)
@Getter
@Setter
public class AppParkingUser
{
    // FIELDS
    @Id
    @Column(
        name      = "app_parking_user_id"
    )
    @GeneratedValue(
        generator = "uuid-generator"
    )
    @GenericGenerator(
        name      = "uuid-generator",
        strategy  = "uuid"
    )
    private String id;

    @Column(
        name     = "user_login",
        nullable = false
    )
    private String appParkingUserLogin;

    @Column(
        name     = "user_password",
        nullable = true
    )
    private String appParkingUserPassword;


    // RELATIONS
    @OneToOne
    @JoinColumn(
        name     = "person_id"
    )
    private Person person;
}
