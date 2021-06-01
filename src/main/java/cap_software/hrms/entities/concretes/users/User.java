package cap_software.hrms.entities.concretes.users;





import cap_software.hrms.entities.concretes.utils.DateParametres;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name="Users")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserId")
    private int id;





    @Column(name="UserNumber", nullable = false,unique = true,length =40, updatable = false)
    private String  userNumber;


    @Email
    @NotNull
    @NotBlank
    @Column(name="Email", nullable = false,unique = true,length = 50)
    private String email;



    @NotNull
    @NotBlank
    @Column(name="Password", nullable = false,length = 250)
    private String password;





    @Embedded
    private DateParametres dateParametres;



    }

