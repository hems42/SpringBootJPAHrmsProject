package cap_software.hrms.core.dtoConvertors;

import cap_software.hrms.core.dto.contactDtos.PersonalInformationDto;
import cap_software.hrms.entities.contacts.PersonalInformation;
import org.springframework.stereotype.Component;

@Component
public class PersonalInformationDtoConvertor {

    private final DateParametersDtoConvertor convertor;

    public PersonalInformationDtoConvertor(DateParametersDtoConvertor convertor) {
        this.convertor = convertor;
    }

    public PersonalInformation convert(PersonalInformationDto from) {
        return new PersonalInformation(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getNationalIdentityNumber(),
                from.getBirthOfDate(),
                from.getSex(),
                convertor.convert(from.getDateParametersDto()),
                null);
    }

    public PersonalInformationDto convert(PersonalInformation from) {
        return new PersonalInformationDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getNationalIdentityNumber(),
                from.getBirthOfDate(),
                from.getSex(),
                convertor.convert(from.getDateParameters()));
    }
}
