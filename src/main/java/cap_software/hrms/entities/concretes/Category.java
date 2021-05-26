package cap_software.hrms.entities.concretes;

import cap_software.hrms.entities.concretes.utils.DateParametres;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="JopCategories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CategoryName",length = 100,nullable = false,unique = true)
    private String categoryName;

    @Embedded
    private DateParametres dateParametres;

    @ManyToMany(mappedBy = "categoryList",cascade = CascadeType.ALL)
    private List<JopPosition> jopPosition;

}
