package cap_software.hrms.entities.concretes;

import javax.persistence.*;

@Entity
@Table(name="JopPositions")
public class JopPosition {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "JopPosition",length = 100,nullable = false,unique = true)
    private String positionName;


}
