package cap_software.hrms.entities.concretes.users;
import cap_software.hrms.entities.concretes.contacts.Adress;
import cap_software.hrms.entities.concretes.contacts.PersonalInformation;
import cap_software.hrms.entities.concretes.contacts.PhoneNumber;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="JopSeekers")
@PrimaryKeyJoinColumn(name="UserId", referencedColumnName="UserId")
public class JopSeeker extends User implements Serializable  {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PersonalInformationId")
    private PersonalInformation personalInformation;

    @ElementCollection
    @CollectionTable(name = "deneme_user",joinColumns = @JoinColumn(name = "UserId"))
    private  List<String> deneme;

   /* @OneToOne()
    @JoinColumn(name = "UserId",unique = true,nullable = false)
    private User  userId;





    @OneToMany(mappedBy = "user")
    private List<Adress> adresses;

    @OneToMany(mappedBy = "user")
    private  List<PhoneNumber> phoneNumbers;
*/
}
