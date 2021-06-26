package cap_software.hrms.core.dto.contactDtos;

import cap_software.hrms.entities.utils.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdressDto {
    private int id;
    private City city;
    private String  district;
    private String street;
}
