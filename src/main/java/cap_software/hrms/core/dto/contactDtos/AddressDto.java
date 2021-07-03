package cap_software.hrms.core.dto.contactDtos;

import cap_software.hrms.core.dto.utilDtos.DateParametersDto;
import cap_software.hrms.entities.utils.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private int id;
    private City city;
    private String  district;
    private String street;

}
