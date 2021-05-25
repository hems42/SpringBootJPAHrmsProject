package cap_software.hrms.entities.concretes.contacts;

import cap_software.hrms.entities.concretes.users.User;
import cap_software.hrms.entities.concretes.utils.DateParametres;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Adresses")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;

    private String  district;

    private String street;


    @Embedded
    private DateParametres dateParametres;
}

