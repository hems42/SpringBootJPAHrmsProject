package cap_software.hrms.entities.contacts;

import cap_software.hrms.entities.utils.DateParameters;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PhoneNumbers")
@Inheritance(strategy = InheritanceType.JOINED)
public class PhoneNumber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @Column(name = "PhoneNumber", nullable = false, length = 20, unique = true)
    private String phoneNumber;


}


