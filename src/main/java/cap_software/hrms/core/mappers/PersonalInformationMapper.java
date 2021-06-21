package cap_software.hrms.core.mappers;

import cap_software.hrms.entities.concretes.contacts.PersonalInformation;
import cap_software.hrms.entities.dtos.contactDtos.PersonalInformationDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonalInformationMapper {

    PersonalInformationMapper INSTANCE_PERSONAL_INFORMATION_MAPPER= Mappers.getMapper(PersonalInformationMapper.class);


    PersonalInformation toPersonalInformation(PersonalInformationDto personalInformationDto);

    @InheritInverseConfiguration
    PersonalInformationDto fromPersonalInformation(PersonalInformation personalInformationn);

}
