package cap_software.hrms.entities.dtos.userDtos;

import cap_software.hrms.core.validations.ValidPasswordMatches;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ValidPasswordMatches
public class UserDto {

    @Email
    @NotBlank
    @NotNull
    private String email;

    @NotBlank
    @NotNull
    private  String password;

    @NotBlank
    @NotNull
    private String matchingPassword;
}
