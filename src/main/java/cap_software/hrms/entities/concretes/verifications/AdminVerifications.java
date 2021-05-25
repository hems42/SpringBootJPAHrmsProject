package cap_software.hrms.entities.concretes.verifications;

import cap_software.hrms.entities.concretes.users.Admin;
import cap_software.hrms.entities.concretes.users.User;
import cap_software.hrms.entities.concretes.utils.DateParametres;

import javax.persistence.*;

@Entity
@Table(name="AdminVerifications")
public class AdminVerifications {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PrivilageId")
    private int id;

    @Embedded
    private DateParametres dateParametres;

    @ManyToOne
    @JoinColumn(name="VerifierId")
   private Admin admin;

    @OneToOne
    @JoinColumn(name="TobeVerifiedId",unique = true)
    private User user;

}
