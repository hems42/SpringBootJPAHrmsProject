package cap_software.hrms.entities.concretes.contacts;

import cap_software.hrms.entities.concretes.users.User;
import cap_software.hrms.entities.concretes.utils.DateParametres;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;




@Data
@Entity
@Table(name="PhoneNumbers")
@Inheritance(strategy = InheritanceType.JOINED)
public class PhoneNumber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @Column(name = "PhoneNumber", nullable = false, length = 20, unique = true)
    private String phoneNumber;

    @Embedded
    private DateParametres dateParametres;
}


