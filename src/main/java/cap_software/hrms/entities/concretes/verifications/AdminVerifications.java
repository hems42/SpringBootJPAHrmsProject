package cap_software.hrms.entities.concretes.verifications;

import cap_software.hrms.entities.concretes.users.Admin;
import cap_software.hrms.entities.concretes.users.User;
import cap_software.hrms.entities.concretes.utils.DateParametres;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name="AdminVerifications")
public class AdminVerifications {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PrivilageId")
    private int id;

    @Embedded
    private DateParametres dateParametres;


    @JoinColumn(name="VerifierId")
   private int verifierId;


    @JoinColumn(name="TobeVerifiedId",unique = true,foreignKey = @ForeignKey(foreignKeyDefinition = "UserId"))
    private int tobeVerifiedId;

}
