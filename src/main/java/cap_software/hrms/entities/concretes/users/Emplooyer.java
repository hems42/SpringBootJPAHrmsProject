package cap_software.hrms.entities.concretes.users;
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



    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "emplooyers_web_sites")
    private List<WebSite> webSites= new ArrayList<>();


    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "emplooyers_phone_numbers")
    private List<PhoneNumber> phoneNumbers= new ArrayList<>();

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="EmailVerifyId",unique = true,nullable = false)
    private EmailVerification emailVerification;

    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="AdminVerifyId",unique = true,nullable = false)
    private AdminVerification adminVerification;



    @Embedded
    private AuthParametres authParametres;

    public void addWebSite(WebSite webSite)
    {
        this.webSites.add(webSite);
    }


    public void addPhoneNumber(PhoneNumber phoneNumber)
    {
        this.phoneNumbers.add(phoneNumber);
    }



}
