package cap_software.hrms.entities;

import cap_software.hrms.entities.contacts.PhoneNumber;
import cap_software.hrms.entities.contacts.WebSite;
import cap_software.hrms.entities.users.Emplooyer;
import cap_software.hrms.entities.utils.DateParameters;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "CompanyName",nullable = false,length = 100,unique = true)
    private String companyName;

    @Column(name = "CompanyDetails")
    private String companyDetails;

    @Column(name = "CreatedDate",updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "UpdatedDate",insertable = false)
    private LocalDateTime updatedDate;



    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "companies_web_sites")
    private List<WebSite> webSites= new ArrayList<>();


    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "companies_phone_numbers")
    private List<PhoneNumber> phoneNumbers= new ArrayList<>();


    @JsonIgnore
    @ManyToMany
    @JoinTable(name="CompanyJopAdvertisement",joinColumns = @JoinColumn(name="CompanyId"),inverseJoinColumns = @JoinColumn(name = "JopAdvertisemenId"))
    private List<JopAdvertisement> jopAdvertisement;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="EmplooyerId")
    private Emplooyer emplooyer;


    public void addWebSite(WebSite webSite)
    {
        this.webSites.add(webSite);
    }


    public void addPhoneNumber(PhoneNumber phoneNumber)
    {
        this.phoneNumbers.add(phoneNumber);
    }

}
