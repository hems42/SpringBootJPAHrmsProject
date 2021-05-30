package cap_software.hrms.entities.concretes;

import cap_software.hrms.entities.concretes.users.Emplooyer;
import cap_software.hrms.entities.concretes.utils.City;
import cap_software.hrms.entities.concretes.utils.Currency;
import cap_software.hrms.entities.concretes.utils.DateParametres;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "JopAdvertisements")
public class JopAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;


    @Temporal(TemporalType.DATE)
    @Column(name="ApplicationDeadline")
    private Date applicationDeadline;


    @Embedded
    @AttributeOverride(name = "addedDate",column = @Column(name = "PostDate"))
    private DateParametres  dateParametres;



    @Column(name = "isActive",nullable = false)
    private boolean isActive=true;


    @Column(name = "Description",nullable = false)
    private String description;


    @Column(name = "Requirements",nullable = false)
    private String requirements;


    @Column(name = "SalaryRangeOfMinumun")
    private double salaryOfMin;


    @Column(name = "SalaryRangeOfMaximum")
    private double salaryOfMax;



    @Column(name = "AdvertisementTitle",length = 100,nullable = false)
    private String deatils;

    @ManyToOne
    @JoinColumn(name = "JoppositionId",nullable = false)
    private JopPosition jopPosition;

    @ManyToOne
    @JoinColumn(name = "CompanyId",nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "EmplooyerId",nullable = false)
    private Emplooyer emplooyer;

    @Column(name = "OpenPositionNumber",nullable = false)
    private  int openedPositionNumber;

    @ManyToOne
    @JoinColumn(name = "CityId",nullable = false)
    private City city;

    @ManyToOne
    @JoinColumn(name = "CurrencyId",nullable = false)
    private Currency currency;








}
