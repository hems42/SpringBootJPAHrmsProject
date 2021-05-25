package cap_software.hrms.entities.concretes.users;

import cap_software.hrms.entities.concretes.contacts.PersonalInformation;

import cap_software.hrms.entities.concretes.utils.AuthParametres;
import cap_software.hrms.entities.concretes.verifications.EmailVerification;
import io.swagger.models.properties.EmailProperty;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name="JopSeekers")
@PrimaryKeyJoinColumn(name="UserId", referencedColumnName="UserId")
public class JopSeeker extends User implements Serializable  {

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "PersonalInformationId",unique = true,nullable = false)
    private PersonalInformation personalInformation;

    @Embedded
    private AuthParametres authParametres;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="EmailVeriyId",unique = true,nullable = false)
    private EmailVerification emailVerification;



}
