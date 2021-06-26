package cap_software.hrms.core.dtoRequestes.createRequest;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonalInformationRequest {

    private String name;
    private String surname;
    private String nationalIdentityNumber;
    private LocalDate birthOfDate;
    private String sex;
}
