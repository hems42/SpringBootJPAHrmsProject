package cap_software.hrms.entities.concretes.contacts;

import cap_software.hrms.entities.concretes.users.User;

import javax.persistence.*;

@Entity
@Table(name="WebSites")
public class WebSites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserId",nullable = false,unique = true)
    private User user;
}
