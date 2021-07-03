package cap_software.hrms.core.dtoRequestes.updateRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePersonalInformationRequest {
    private String name;
    private String surname;
    private String nationalIdentityNumber;
    private LocalDate birthOfDate;
    private String sex;
}
