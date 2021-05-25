package cap_software.hrms.entities.concretes.utils;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class AuthParametres {

    @Column(name="isActive",nullable = false)
    private boolean isActive=true;



}
