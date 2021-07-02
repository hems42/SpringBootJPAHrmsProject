package cap_software.hrms.core.dto.contactDtos;


import cap_software.hrms.core.dto.utilDtos.DateParametersDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInformationDto {

    private int id;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String surname;



    @Size(max = 11,min = 11,message = "NationalIdentityNumber Size Must Be 11")
    @NotBlank
    @NotNull
    private String nationalIdentityNumber;


    @NotNull
    private LocalDate birthOfDate;

    @NotBlank
    @NotNull
    private String sex;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;


}
