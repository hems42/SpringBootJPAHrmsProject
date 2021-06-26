package cap_software.hrms.core.dtoConvertors;


import cap_software.hrms.core.dto.contactDtos.AddressDto;
import cap_software.hrms.entities.contacts.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoConvertor {

    private final DateParametersDtoConvertor convertor;

    public AddressDtoConvertor(DateParametersDtoConvertor convertor) {
        this.convertor = convertor;
    }

    public Address convert(AddressDto from)
    {
        return new Address(
                from.getId(),
                from.getCity(),
                from.getDistrict(),
                from.getStreet(),
                convertor.convert(from.getDateParametersDto()));
    }

    public AddressDto convert(Address from)
    {
        return new AddressDto(
                from.getId(),
                from.getCity(),
                from.getDistrict(),
                from.getStreet(),
                convertor.convert(from.getDateParameters()));
    }
}
