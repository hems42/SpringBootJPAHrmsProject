package cap_software.hrms.entities.users;
import cap_software.hrms.entities.Company;
import cap_software.hrms.entities.JopAdvertisement;
import cap_software.hrms.entities.utils.AuthParameters;
import cap_software.hrms.entities.verifications.AdminVerification;
import cap_software.hrms.entities.verifications.EmailVerification;
import com.fasterxml.jackson.annotation.JsonIgnore;
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





    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST},targetEntity = EmailVerification.class)
    @JoinColumn(name="EmailVerifyId",unique = true)
    private EmailVerification emailVerification;


    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="AdminVerifyId",unique = true)
    private AdminVerification adminVerification;


    @OneToMany
    @JoinTable(name = "EmplooyersCompanies",
            joinColumns = @JoinColumn(name="EmplooyerId"),
            inverseJoinColumns = @JoinColumn(name = "CompanyId"))
    private List<Company> companies;

    @JsonIgnore
    @OneToMany
    @JoinTable(name = "EmplooyersJopAdvertisements",
            joinColumns = @JoinColumn(name="EmplooyerId"),
            inverseJoinColumns = @JoinColumn(name = "JopAdvertisementId"))
    private List<JopAdvertisement> jopAdvertisementies= new ArrayList<>();

    @Embedded
    private AuthParameters authParameters;


    public void addAdvertisement(JopAdvertisement jopAdvertisement)
    {
        jopAdvertisementies.add(jopAdvertisement);
    }



}
