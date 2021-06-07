package cap_software.hrms.entities.concretes.users;

import cap_software.hrms.entities.concretes.contacts.PersonalInformation;

import cap_software.hrms.entities.concretes.cv.CurriculumVitae;
import cap_software.hrms.entities.concretes.utils.AuthParametres;
import cap_software.hrms.entities.concretes.utils.DateParametres;
import cap_software.hrms.entities.concretes.verifications.EmailVerification;
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

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user")
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
