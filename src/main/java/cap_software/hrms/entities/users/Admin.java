package cap_software.hrms.entities.users;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name="Admins")
@PrimaryKeyJoinColumn(name="UserId", referencedColumnName="UserId")
public class Admin extends User implements Serializable {







}
