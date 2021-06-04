package cap_software.hrms.entities.concretes.contacts;


import cap_software.hrms.entities.concretes.users.User;
import cap_software.hrms.entities.concretes.utils.DateParametres;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PersonelInformations",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "NationalIdentityNumber",name = "UK_NATIONAL_IDENTITY_NUMBER")
})
public class PersonalInformation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;


    @Column(name="Name", length = 50, nullable = false)
    private String name;


    @Column(name="Surname", length = 50, nullable = false)
    private String surname;

    @Column(name="NationalIdentityNumber", length =11, nullable = false)
    private String nationalIdentityNumber;

    @Column(name="BirhtOfDate", length = 50, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthOfDate;


    @Column(name="Sex",nullable = false,length = 5)
    private String sex;

    @Embedded
    private DateParametres dateParametres=new DateParametres();


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "UserId",referencedColumnName = "UserId",nullable = false,foreignKey = @ForeignKey(name = "FK_PERSONALINFORMATION_USER",value = ConstraintMode.CONSTRAINT))
    private User user;





}
