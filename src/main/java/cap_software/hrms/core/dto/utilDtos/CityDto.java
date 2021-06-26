package cap_software.hrms.core.dto.utilDtos;

import cap_software.hrms.entities.utils.String;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {


    private int id;
    private String cityName;
}
