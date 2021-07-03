package cap_software.hrms.entities.contacts;

import cap_software.hrms.entities.utils.City;
import cap_software.hrms.entities.utils.DateParameters;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Adresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "CityId",nullable = false)
    private City city;

    private String  district;

    private String street;



}

