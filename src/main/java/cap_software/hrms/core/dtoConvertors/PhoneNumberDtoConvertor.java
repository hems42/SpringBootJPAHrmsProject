package cap_software.hrms.core.dtoConvertors;

import cap_software.hrms.core.dto.contactDtos.PhoneNumberDto;
import cap_software.hrms.entities.contacts.PhoneNumber;
import org.springframework.stereotype.Component;

@Component
public class PhoneNumberDtoConvertor {


    public PhoneNumberDto convert(PhoneNumber from)
    {
        return new PhoneNumberDto(
                from.getId(),
                from.getPhoneNumber());
    }

    public PhoneNumber convert(PhoneNumberDto from)
    {
        return new PhoneNumber(
                from.getId(),
                from.getPhoneNumber());
    }
}
