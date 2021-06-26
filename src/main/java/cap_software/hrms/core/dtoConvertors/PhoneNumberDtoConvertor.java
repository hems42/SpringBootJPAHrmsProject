package cap_software.hrms.core.dtoConvertors;

import cap_software.hrms.core.dto.contactDtos.PhoneNumberDto;
import cap_software.hrms.entities.contacts.PhoneNumber;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberDtoConvertor {

    private final DateParametersDtoConvertor convertor;

    public PhoneNumberDtoConvertor(DateParametersDtoConvertor convertor) {
        this.convertor = convertor;
    }

    public PhoneNumberDto convert(PhoneNumber from)
    {
        return new PhoneNumberDto(
                from.getId(),
                from.getPhoneNumber(),
                convertor.convert(from.getDateParameters()));
    }

    public PhoneNumber convert(PhoneNumberDto from)
    {
        return new PhoneNumber(
                from.getId(),
                from.getPhoneNumber(),
                convertor.convert(from.getDateParametersDto()));
    }
}
