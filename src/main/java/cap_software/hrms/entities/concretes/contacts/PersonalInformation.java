package cap_software.hrms.entities.concretes.contacts;


import cap_software.hrms.entities.concretes.users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PersonelInformations")
public class PersonalInformation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;


    @Column(name="Name", length = 50, nullable = false)
    private String name;


    @Column(name="Surname", length = 50, nullable = false)
    private String surname;

    @Column(name="NationalIdentityNumber", length =11, nullable = false,unique = true)
    private String nationalIdentityNumber;

    @Column(name="BirhtOfDate", length = 50, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthOfDate;


    @Column(name="Sex",nullable = false,length = 5)
    private String sex;

    @OneToOne
    @JoinColumn(name = "UserId",referencedColumnName = "UserId")
    private User user;





}
