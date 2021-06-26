package cap_software.hrms.entities.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class DateParameters {






    @Column(name = "CreatedDate",updatable = false)
    private LocalDateTime createdDate=LocalDateTime.now();



    @Column(name = "UpdatedDate",insertable = false)
    private LocalDateTime updatedDate=LocalDateTime.now();


}
