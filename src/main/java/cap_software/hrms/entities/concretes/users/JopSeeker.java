package cap_software.hrms.entities.concretes.users;
import cap_software.hrms.entities.concretes.contacts.Adress;
import cap_software.hrms.entities.concretes.contacts.PersonalInformation;
import cap_software.hrms.entities.concretes.contacts.PhoneNumber;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="JopSeekers")
public class JopSeeker implements Serializable {

    @Id
    @OneToOne()
    @JoinColumn(name = "UserId",unique = true,nullable = false)
    private User  userId;


    @OneToOne(mappedBy = "user")
    private PersonalInformation personalInformation;

    @OneToMany(mappedBy = "user")
    private List<Adress> adresses;

    @OneToMany(mappedBy = "user")
    private  List<PhoneNumber> phoneNumbers;

}
