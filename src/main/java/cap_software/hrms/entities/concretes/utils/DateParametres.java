package cap_software.hrms.entities.concretes.utils;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
public class DateParametres {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AddDate",updatable = false)
    private Date addedDate;



    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UpdateDate",updatable = true,insertable = false)
    private Date updateDate;

    public DateParametres() {
        Date date= new Date();

        this.updateDate=date;
        this.addedDate=date;
    }
}
