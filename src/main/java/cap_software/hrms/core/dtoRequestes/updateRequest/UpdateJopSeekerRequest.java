package cap_software.hrms.core.dtoRequestes.updateRequest;

import cap_software.hrms.core.dtoRequestes.createRequest.BaseCreateUserRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateJopSeekerRequest extends BaseCreateUserRequest {

    private UpdatePersonalInformationRequest personalInformationRequest;
}
