package cap_software.hrms.entities.concretes.contacts;

import cap_software.hrms.entities.concretes.users.Emplooyer;
import cap_software.hrms.entities.concretes.utils.DateParametres;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="WebSites")
public class WebSite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private DateParametres dateParametres;

    @Column(name="WebSite",length = 50,nullable = false,unique = true)
    private String webSite;


}
