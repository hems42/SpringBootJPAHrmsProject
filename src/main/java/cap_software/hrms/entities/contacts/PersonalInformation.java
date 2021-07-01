package cap_software.hrms.entities.contacts;


import cap_software.hrms.entities.users.User;
import cap_software.hrms.entities.utils.DateParameters;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PersonelInformations",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "NationalIdentityNumber", name = "UK_NATIONAL_IDENTITY_NUMBER")
        })
public class PersonalInformation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "Name", length = 50, nullable = false)
    private String name;


    @Column(name = "Surname", length = 50, nullable = false)
    private String surname;

    @Column(name = "NationalIdentityNumber", length = 11, nullable = false)
    private String nationalIdentityNumber;

    @Column(name = "BirhtOfDate", nullable = false)
    private LocalDate birthOfDate;


    @Column(name = "Sex", nullable = false, length = 5)
    private String sex;


    @Embedded
    private DateParameters dateParameters = new DateParameters();


    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "UserId", referencedColumnName = "UserId",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_PERSONALINFORMATION_USER", value = ConstraintMode.CONSTRAINT), unique = true)
    private User user;


}
