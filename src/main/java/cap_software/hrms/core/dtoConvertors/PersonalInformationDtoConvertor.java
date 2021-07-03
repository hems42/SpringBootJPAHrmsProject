package cap_software.hrms.core.dtoConvertors;

import cap_software.hrms.core.dto.contactDtos.PersonalInformationDto;
import cap_software.hrms.entities.contacts.PersonalInformation;
import org.springframework.stereotype.Component;

@Component
public class PersonalInformationDtoConvertor {



    public PersonalInformation convert(PersonalInformationDto from)
    {
        PersonalInformation personalInformation=new PersonalInformation(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getNationalIdentityNumber(),
                from.getBirthOfDate(),
                from.getSex(),
                from.getCreatedDate(),
                null,
                null);

        if(from.getUpdatedDate()!=null)
        {
            personalInformation.setUpdatedDate(from.getUpdatedDate());
        }

        return personalInformation;
    }

    public PersonalInformationDto convert(PersonalInformation from) {

        PersonalInformationDto personalInformationDto=new PersonalInformationDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getNationalIdentityNumber(),
                from.getBirthOfDate(),
                from.getSex(),
                from.getCreatedDate(),
                null);

        if(from.getUpdatedDate()!=null)
        {
            personalInformationDto.setUpdatedDate(from.getUpdatedDate());
        }

        return personalInformationDto;
    }
}
