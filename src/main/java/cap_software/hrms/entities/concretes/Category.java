package cap_software.hrms.entities.concretes;

import javax.persistence.*;

@Entity
@Table(name="JopCategories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CategoryName",length = 100,nullable = false,unique = true)
    private String categoryName;


}
