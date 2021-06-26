package cap_software.hrms.core.dtoConvertors;

import cap_software.hrms.core.dto.contactDtos.WebSiteDto;
import cap_software.hrms.entities.contacts.WebSite;
import org.springframework.stereotype.Component;

@Component
public class WebSiteDtoConvertor {

    public WebSite convert(WebSiteDto from)
    {
        return new WebSite(
                from.getId(),
                null,
                from.getWebSite()
                );
    }

    public WebSiteDto convert(WebSite from)
    {
        return new WebSiteDto(
                from.getId(),
                from.getWebSite());
    }
}
