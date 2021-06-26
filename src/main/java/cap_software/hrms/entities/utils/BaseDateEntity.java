package cap_software.hrms.entities.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Column;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDateEntity {


    @CreationTimestamp
    @Column(name = "CreatedDate",updatable = false)
    private LocalDateTime createdDate;


    @UpdateTimestamp
    @Column(name = "UpdatedDate",insertable = false)
    private LocalDateTime updatedDate;
}
