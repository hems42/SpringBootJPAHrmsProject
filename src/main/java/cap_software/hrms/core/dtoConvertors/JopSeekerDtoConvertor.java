package cap_software.hrms.core.dtoConvertors;


import cap_software.hrms.core.dto.userDtos.JopSeekerDto;
import cap_software.hrms.entities.users.JopSeeker;
import org.springframework.stereotype.Component;

@Component
public class JopSeekerDtoConvertor {

    private final DateParametersDtoConvertor convertorDate;
    private final PersonalInformationDtoConvertor convertorPerson;
    private final AuthParametersDtoConvertor convertorAuth;


    public JopSeekerDtoConvertor(DateParametersDtoConvertor convertorDate, PersonalInformationDtoConvertor convertorPerson, AuthParametersDtoConvertor convertorAuth) {
        this.convertorDate = convertorDate;
        this.convertorPerson = convertorPerson;
        this.convertorAuth = convertorAuth;
    }

    public JopSeeker  convert(JopSeekerDto from)
    {
       return new JopSeeker(
               convertorPerson.convert(from.getPersonalInformationDto()),
               convertorAuth.convert(from.getAuthParametersDto()),
               null,
               null
       );
    }

    public JopSeekerDto convert(JopSeeker from)
    {
        JopSeekerDto jopSeekerDto=new JopSeekerDto(

                convertorAuth.convert(from.getAuthParameters()),
                convertorPerson.convert(from.getPersonalInformation())
        );

        jopSeekerDto.setEmail(from.getEmail());
        jopSeekerDto.setId(from.getId());
        jopSeekerDto.setPassword(from.getPassword());
        jopSeekerDto.setDateParametersDto(convertorDate.convert(from.getDateParameters()));
        return jopSeekerDto;
    }
}
