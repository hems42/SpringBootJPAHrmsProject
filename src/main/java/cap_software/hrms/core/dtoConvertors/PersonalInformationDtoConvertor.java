package cap_software.hrms.core.dtoConvertors;

import cap_software.hrms.core.dto.contactDtos.PersonalInformationDto;
import cap_software.hrms.entities.contacts.PersonalInformation;
import org.springframework.stereotype.Component;

@Component
public class PersonalInformationDtoConvertor {

    public PersonalInformation convert(PersonalInformationDto from)
    {
        return  new PersonalInformation(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getNationalIdentityNumber(),
                from.getBirthOfDate(),
                 from.getSex().toString(),
                null,
                null);
    }

    public PersonalInformationDto convert(PersonalInformation from)
    {
        return new PersonalInformationDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getNationalIdentityNumber(),
                from.getBirthOfDate(),
                from.getSex().toString());
    }
}
