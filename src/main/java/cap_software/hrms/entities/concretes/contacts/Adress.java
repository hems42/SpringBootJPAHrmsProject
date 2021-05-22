package cap_software.hrms.entities.concretes.contacts;

import cap_software.hrms.entities.concretes.users.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data

@Entity
@Table(name="Adresses")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserId",  nullable = false)
    private User user;


    @Getter
    @Setter
    private String city;

    private String  district;


    private String street;
}

