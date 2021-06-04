package cap_software.hrms.entities.concretes.users;





import cap_software.hrms.entities.concretes.utils.DateParametres;
import lombok.*;
import javax.persistence.*;



@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name="Users",

uniqueConstraints ={
        @UniqueConstraint(columnNames = "UserNumber", name = "UK_USER_NUMBER"),
        @UniqueConstraint(columnNames = "Email", name = "UK_EMAİL_ADDRESS")

}
)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserId")
    private int id;






    @Column(name="UserNumber", nullable = false,length =40, updatable = false)
    private String  userNumber;



    @Column(name="Email", nullable = false,length = 50)
    private String email;




    @Column(name="Password", nullable = false,length = 250)
    private String password;





    @Embedded
    private DateParametres dateParametres= new DateParametres();



    }

