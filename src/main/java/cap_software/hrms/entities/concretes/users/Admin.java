package cap_software.hrms.entities.concretes.users;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Admins")
public class Admin implements Serializable {

    @Id
   @OneToOne()
   @JoinColumn(name = "UserId",unique = true,nullable = false)
    private User  userId;

}
