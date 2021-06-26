package cap_software.hrms.entities.users;


import cap_software.hrms.entities.contacts.PersonalInformation;
import cap_software.hrms.entities.cv.CurriculumVitae;
import cap_software.hrms.entities.utils.AuthParametres;
import cap_software.hrms.entities.verifications.EmailVerification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name="JopSeekers")
@PrimaryKeyJoinColumn(name="UserId", referencedColumnName="UserId")
public class JopSeeker extends User implements Serializable  {

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user",targetEntity = PersonalInformation.class)
    @JoinColumn(name = "PersonalInformationId",unique = true,nullable = false)
    private PersonalInformation personalInformation;

    @Embedded
    private AuthParametres authParametres=new AuthParametres();

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="EmailVeriyId",unique = true)
    private EmailVerification emailVerification;


    @OneToMany(mappedBy = "user",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private List<CurriculumVitae> curriculumVitaes;



}
