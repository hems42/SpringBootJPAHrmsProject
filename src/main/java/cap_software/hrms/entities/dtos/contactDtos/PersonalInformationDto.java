package cap_software.hrms.entities.dtos.contactDtos;


import cap_software.hrms.core.validations.ValidRealPerson;
import cap_software.hrms.entities.concretes.contacts.PersonalInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.Converters;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInformationDto {


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
    private Date birthOfDate;

    @NotBlank
    @NotNull
    private String sex;



}
