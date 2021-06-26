package cap_software.hrms.entities;

import cap_software.hrms.entities.utils.DateParameters;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private DateParameters dateParameters;


    @JsonIgnore
    @ManyToMany(mappedBy = "categoryList")
    private List<JopPosition> jopPosition;

}
