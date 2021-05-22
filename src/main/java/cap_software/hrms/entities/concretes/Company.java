package cap_software.hrms.entities.concretes;

import cap_software.hrms.entities.concretes.users.User;

import javax.persistence.*;

@Entity
@Table(name = "Companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "ownerId")
    private User user;
}
