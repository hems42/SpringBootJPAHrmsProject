package cap_software.hrms.entities.concretes.users;





import cap_software.hrms.entities.concretes.utils.DateParametres;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;



@Data
@AllArgsConstructor
@Entity
@Table(name="Users")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserId")
    private int id;



    @GeneratedValue
    @Column(name="UserNumber", nullable = false,unique = true,length =10,insertable = true, updatable = false)
    private String  userNumber;


    @Column(name="Email", nullable = false,unique = true,length = 50)
    private String email;



    @Column(name="Password", nullable = false,length = 250)
    private String password;





    @Embedded
    private DateParametres dateParametres;


    public User() {
        if(getClass()==JopSeeker.class)
        {
            userNumber="JP"+id;

        }
        else if (getClass()==Emplooyer.class)
        {


            userNumber="EMP"+id;
        }
        else if((getClass()==Admin.class))
        {
            userNumber="ADM"+id;
        }
    }
}
