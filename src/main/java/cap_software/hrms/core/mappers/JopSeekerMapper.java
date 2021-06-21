package cap_software.hrms.core.mappers;

import cap_software.hrms.entities.concretes.users.JopSeeker;
import cap_software.hrms.entities.dtos.userDtos.JopSeekerDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG)
public interface JopSeekerMapper {

    JopSeekerMapper INSTANCE_JOP_SEEKER_MAPPER= Mappers.getMapper(JopSeekerMapper.class);


    @Mapping(source = "personalInformationDto",target = "personalInformation")
    JopSeeker toJopSeeker(JopSeekerDto jopSeekerDto);

    @InheritInverseConfiguration
    JopSeekerDto fromJopSeeker(JopSeeker jopSeeker);

}
