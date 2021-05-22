package cap_software.hrms.entities.concretes.contacts;

import cap_software.hrms.entities.concretes.users.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="PhoneNumbers")
public class PhoneNumber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="UserId",nullable = false)
    private User user;

    @Column(name = "PhoneNumber",nullable = false,length = 20,unique = true)
    private  String phoneNumber;
}
