package cap_software.hrms.entities.concretes;

import cap_software.hrms.entities.concretes.users.Emplooyer;
import cap_software.hrms.entities.concretes.utils.DateParametres;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "CompanyName",nullable = false,length = 100,unique = true)
    private String companyName;

    @Embedded
    DateParametres dataParametres;
}
