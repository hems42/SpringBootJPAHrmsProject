package cap_software.hrms.entities.concretes.verifications;

import cap_software.hrms.entities.concretes.users.Admin;
import cap_software.hrms.entities.concretes.users.User;
import cap_software.hrms.entities.concretes.utils.DateParametres;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="AdminVerifications")
public class AdminVerification {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PrivilageId")
    private int id;

    @Embedded
    private DateParametres dateParametres;

    @Column(name="isVerified",updatable = false)
    private  boolean isVerifed=false;

    @JoinColumn(name="VerifierId")
   private int verifierId;


    @JoinColumn(name="TobeVerifiedId",unique = true,foreignKey = @ForeignKey(foreignKeyDefinition = "UserId"))
    private int tobeVerifiedId;

}
