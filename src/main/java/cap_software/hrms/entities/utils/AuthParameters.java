package cap_software.hrms.entities.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AuthParameters {

    @Column(name="isActive",nullable = false)
    private Boolean isActive=true;



}
