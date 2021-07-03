package cap_software.hrms.entities.contacts;

import cap_software.hrms.entities.utils.DateParameters;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="WebSites")
public class WebSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name="WebSite",length = 50,nullable = false,unique = true)
    private String webSite;


}
