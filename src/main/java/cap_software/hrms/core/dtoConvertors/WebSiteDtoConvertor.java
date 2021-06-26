package cap_software.hrms.core.dtoConvertors;

import cap_software.hrms.core.dto.contactDtos.WebSiteDto;
import cap_software.hrms.entities.contacts.WebSite;
import org.springframework.stereotype.Component;

@Component
public class WebSiteDtoConvertor {

    private final DateParametersDtoConvertor convertor;

    public WebSiteDtoConvertor(DateParametersDtoConvertor convertor) {
        this.convertor = convertor;
    }

    public WebSite convert(WebSiteDto from)
    {
        return new WebSite(
                from.getId(),
                convertor.convert(from.getDateParametersDto()),
                from.getWebSite()
                );
    }

    public WebSiteDto convert(WebSite from)
    {
        return new WebSiteDto(
                from.getId(),
                from.getWebSite(),
                convertor.convert(from.getDateParameters()));
    }
}
