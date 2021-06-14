package cap_software.hrms.entities.mapstructExams;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParentMapper {

    ParentMapper  INSTANCE_PARENT_MAPPER= Mappers.getMapper(ParentMapper.class);


    @Mapping(source = "firstName",target = "name")
    @Mapping(source = "lastName",target = "surname")
    Parent toParent(ParentDto parentDto);

    @InheritInverseConfiguration
    ParentDto fromParent(Parent parent);

}
