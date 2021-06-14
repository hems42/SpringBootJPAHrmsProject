package cap_software.hrms.entities.mapstructExams;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface ChildMapper {

    ChildMapper  INSTANCE_CHILD_MAPPER= Mappers.getMapper(ChildMapper.class);


    @Mapping(source = "firstName",target = "name")
    @Mapping(source = "lastName",target = "surname")
    Child toChild(ChildDto childDto);

    @InheritInverseConfiguration
    ChildDto fromChild(Child child);
}
