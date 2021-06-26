package cap_software.hrms.core.dtoConvertors;


import cap_software.hrms.core.dto.userDtos.JopSeekerDto;
import cap_software.hrms.entities.users.JopSeeker;

public class JopSeekerDtoConvertor {

    public JopSeeker  convert(JopSeekerDto from)
    {
       return new JopSeeker();
    }

    public JopSeekerDto convert(JopSeeker from)
    {
        return new JopSeekerDto();
    }
}
