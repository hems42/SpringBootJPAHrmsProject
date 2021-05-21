package cap_software.hrms.entities.concretes.users;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Emplooyers")
public class Emplooyer implements  Serializable{

    @Id
    @OneToOne()
    @JoinColumn(name = "UserId",unique = true,nullable = false)
    private User  userId;

}
