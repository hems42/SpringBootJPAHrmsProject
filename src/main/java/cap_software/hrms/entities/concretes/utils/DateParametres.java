package cap_software.hrms.entities.concretes.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@Embeddable

public class DateParametres {


    @Temporal(TemporalType.DATE)
    @Column(name = "AddDate",updatable = false)
    private Date addedDate;



    @Temporal(TemporalType.DATE)
    @Column(name = "UpdateDate",insertable = false)
    private Date updateDate;

    public DateParametres() {
        Date date= new Date();

        this.updateDate=date;
        this.addedDate=date;
    }
}
