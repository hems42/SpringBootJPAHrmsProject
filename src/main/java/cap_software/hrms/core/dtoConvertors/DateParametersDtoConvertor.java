package cap_software.hrms.core.dtoConvertors;

import cap_software.hrms.core.dto.utilDtos.DateParametersDto;
import cap_software.hrms.entities.utils.DateParameters;
import org.springframework.stereotype.Component;

@Component
public class DateParametersDtoConvertor {

    public DateParameters convert(DateParametersDto from) {
        return new DateParameters(
                from.getCreatedDate(),
                from.getUpdatedDate());
    }

    public DateParametersDto convert(DateParameters from) {
        return new DateParametersDto(
                from.getCreatedDate(),
                from.getUpdatedDate());
    }
}
