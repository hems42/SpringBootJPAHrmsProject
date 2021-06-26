package cap_software.hrms.core.dtoRequestes.createRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseCreateUserRequest {
    private String email;
    private  String password;
    private String matchingPassword;
}
