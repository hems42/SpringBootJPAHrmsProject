package cap_software.hrms.entities.concretes.contacts;

import cap_software.hrms.entities.concretes.users.User;

import javax.persistence.*;

@Entity
@Table(name="WebSites")
public class WebSites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @Column(name="WebSite",length = 50,nullable = false,unique = true)
    private String webSite;
}
