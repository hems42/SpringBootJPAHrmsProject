package cap_software.hrms.entities.concretes.users;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Admins")
@PrimaryKeyJoinColumn(name="UserId", referencedColumnName="UserId")
public class Admin extends User implements Serializable {



    @ElementCollection
    @CollectionTable(name = "deneme_user",joinColumns = @JoinColumn(name = "UserId"))
    private List<String> deneme;




}
