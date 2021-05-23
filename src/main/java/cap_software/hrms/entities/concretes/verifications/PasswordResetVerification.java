package cap_software.hrms.entities.concretes.verifications;
import cap_software.hrms.entities.concretes.users.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;


@Data
@AllArgsConstructor
@Entity
@Table(name="PasswordResetVerications")
public class PasswordResetVerification {

    @Transient
    private final int EXPIRY_DATE=60*24;  // geçerlilik süresi olarak kullanıcaz....

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PrivilageId")
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AddDate",updatable = false)
    private Date addedDate;



    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UpdateDate",updatable = true,insertable = false)
    private Date updateDate;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="UserId",unique = true,nullable = false,updatable = false,insertable = true )
    private User user;

    @Column(name="Token",length = 200,nullable = false)
    private String token;

    @Column(name="Expirydate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;


    public PasswordResetVerification()
    {
        expiryDate=calculateExpiryDate(EXPIRY_DATE);
    }

    public PasswordResetVerification(String token, User user)
    {
        this.token=token;
        this.user=user;
        this.expiryDate=calculateExpiryDate(EXPIRY_DATE);
    }


    private Date calculateExpiryDate(int EXPIRY_DATE)
    {
        Calendar calender=Calendar.getInstance();

        calender.setTimeInMillis(new Date().getTime());

        calender.add(Calendar.MINUTE,EXPIRY_DATE);

        return new Date(calender.getTime().getTime());
    }


}
