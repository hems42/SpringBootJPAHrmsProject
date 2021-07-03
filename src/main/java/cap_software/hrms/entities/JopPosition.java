package cap_software.hrms.entities;

import cap_software.hrms.entities.utils.DateParameters;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="JopPositions")
public class JopPosition {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "JopPosition",length = 100,nullable = false,unique = true)
    private String positionName;



    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="CategoryJopposition",
            joinColumns = @JoinColumn(name = "JopId",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "CategoryId",referencedColumnName = "id"))
   private List<Category> categoryList;

    @Column(name = "CreatedDate",updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "UpdatedDate",insertable = false)
    private LocalDateTime updatedDate;




}
