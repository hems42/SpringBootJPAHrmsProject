package cap_software.hrms.core.dtoRequestes.createRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseCreateUserRequest {


    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    private  String password;

    @NotNull
    @NotBlank
    private String matchingPassword;
}
