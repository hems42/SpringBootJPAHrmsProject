package cap_software.hrms.entities.concretes.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class DateParametres {




    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AddDate",updatable = false)
    private Date addedDate= new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UpdateDate",insertable = false)
    private Date updateDate= new Date();


}
