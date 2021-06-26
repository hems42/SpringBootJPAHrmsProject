package cap_software.hrms.core.dtoConvertors;


import cap_software.hrms.core.dto.contactDtos.AdressDto;
import cap_software.hrms.entities.contacts.Adress;
import org.springframework.stereotype.Component;

@Component
public class AdressDtoConvertor {

    public Adress convert(AdressDto  from)
    {
        return new Adress(
                from.getId(),
                from.getCity(),
                from.getDistrict(),
                from.getStreet(),
                null);
    }

    public AdressDto convert(Adress from)
    {
        return new AdressDto(
                from.getId(),
                from.getCity(),
                from.getDistrict(),
                from.getStreet());
    }
}
