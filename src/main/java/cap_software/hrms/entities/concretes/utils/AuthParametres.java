package cap_software.hrms.entities.concretes.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AuthParametres {

    @Column(name="isActive",nullable = false)
    private boolean isActive=true;



}
