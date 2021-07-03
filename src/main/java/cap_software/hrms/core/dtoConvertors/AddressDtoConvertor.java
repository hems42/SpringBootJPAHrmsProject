package cap_software.hrms.core.dtoConvertors;


import cap_software.hrms.core.dto.contactDtos.AddressDto;
import cap_software.hrms.entities.contacts.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoConvertor {


    public Address convert(AddressDto from) {
        return new Address(
                from.getId(),
                from.getCity(),
                from.getDistrict(),
                from.getStreet());
    }

    public AddressDto convert(Address from) {
        return new AddressDto(
                from.getId(),
                from.getCity(),
                from.getDistrict(),
                from.getStreet());
    }
}
