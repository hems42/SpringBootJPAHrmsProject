package cap_software.hrms.entities.concretes;

import cap_software.hrms.entities.concretes.utils.DateParametres;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="JopPositions")
public class JopPosition {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "JopPosition",length = 100,nullable = false,unique = true)
    private String positionName;

    @ManyToMany
    @JoinTable(name="CategoryJopposition",joinColumns = @JoinColumn(name = "JopId"),inverseJoinColumns = @JoinColumn(name = "CategoryId"))
   private List<Category> categoryList;

    @Embedded
    private DateParametres dateParametres;


}
