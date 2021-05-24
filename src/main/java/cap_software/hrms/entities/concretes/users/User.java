package cap_software.hrms.entities.concretes.users;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;


import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserId")
    @FieldNameConstants.Exclude
    private int id;




    @Column(name="UserNumber", nullable = false,unique = true,length =10)
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



}
