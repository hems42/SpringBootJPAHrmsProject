package cap_software.hrms.entities.concretes.users;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserId")
    private int id;




    @Column(name="UserNumber", nullable = false,unique = true,length = 12)
    private int userNumber;


    @Column(name="Email", nullable = false,unique = true,length = 50)
    private String email;


    @Column(name="Password", nullable = false,length = 250)
    private String password;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AddDate",updatable = false)
    private Date addedDate;



    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UpdateDate",updatable = true,insertable = false)
    private Date updateDate;


    @OneToOne(mappedBy = "userId")
    private Admin admin;


    @OneToOne(mappedBy = "userId")
    private JopSeeker jobSeeker;

    @OneToOne(mappedBy = "userId")
    private Emplooyer emplooyer;


}
