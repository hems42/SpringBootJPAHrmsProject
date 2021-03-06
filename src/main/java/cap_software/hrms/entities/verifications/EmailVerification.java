package cap_software.hrms.entities.verifications;


import cap_software.hrms.entities.utils.DateParameters;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;


@Data
@AllArgsConstructor
@Entity
@Table(name="EmailVerications")
public class EmailVerification {

    @Transient
    private final int EXPIRY_DATE=60*24;  // geçerlilik süresi olarak kullanıcaz....

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PrivilageId")
    private int id;


    @Embedded
    private DateParameters dateParameters =new DateParameters();


    @Column(name="isVerified",updatable = false)
    private  boolean isVerifed=false;


    @Column(name="Token",length = 200,nullable = false)
    private String token;

    @Column(name="Expirydate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;


    public EmailVerification()
    {
       this.expiryDate=calculateExpiryDate(EXPIRY_DATE);
    }


    @Transient
    private Date calculateExpiryDate(int EXPIRY_DATE)
    {
        Calendar calender=Calendar.getInstance();

        calender.setTimeInMillis(new Date().getTime());

        calender.add(Calendar.MINUTE,EXPIRY_DATE);

        return new Date(calender.getTime().getTime());
    }

}
