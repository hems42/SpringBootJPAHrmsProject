package cap_software.hrms.entities.concretes.users;
import cap_software.hrms.entities.concretes.Company;
import cap_software.hrms.entities.concretes.JopAdvertisement;
import cap_software.hrms.entities.concretes.contacts.PhoneNumber;
import cap_software.hrms.entities.concretes.contacts.WebSite;
import cap_software.hrms.entities.concretes.utils.AuthParametres;
import cap_software.hrms.entities.concretes.verifications.AdminVerification;
import cap_software.hrms.entities.concretes.verifications.EmailVerification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Emplooyers")
@PrimaryKeyJoinColumn(name="UserId", referencedColumnName="UserId")
public class Emplooyer extends User implements  Serializable{




    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="EmailVerifyId",unique = true,nullable = false)
    private EmailVerification emailVerification;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="AdminVerifyId",unique = true,nullable = false)
    private AdminVerification adminVerification;


    @OneToMany
    @JoinTable(name = "EmplooyersCompanies",
            joinColumns = @JoinColumn(name="EmplooyerId"),
            inverseJoinColumns = @JoinColumn(name = "CompanyId"))
    private List<Company> companies;

    @OneToMany
    @JoinTable(name = "EmplooyersJopAdvertisements",
            joinColumns = @JoinColumn(name="EmplooyerId"),
            inverseJoinColumns = @JoinColumn(name = "JopAdvertisementId"))
    private List<JopAdvertisement> jopAdvertisementies;

    @Embedded
    private AuthParametres authParametres;



}
