package cap_software.hrms.core.dto.contactDtos;


import cap_software.hrms.core.dto.utilDtos.DateParametersDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumberDto {
    private int id;
    private String phoneNumber;
}
