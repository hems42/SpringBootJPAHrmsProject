package cap_software.hrms.core.dtoConvertors;

import cap_software.hrms.core.dto.utilDtos.AuthParametersDto;
import cap_software.hrms.entities.utils.AuthParameters;
import org.springframework.stereotype.Component;

@Component
public class AuthParametersDtoConvertor {

    public AuthParameters convert(AuthParametersDto from)
    {
        return new AuthParameters(
                from.getIsActive()
        );
    }

    public AuthParametersDto convert(AuthParameters from)
    {
        return  new AuthParametersDto(
                from.getIsActive()
        );
    }
}
