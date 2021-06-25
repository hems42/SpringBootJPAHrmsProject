package cap_software.hrms.core.dto.convertors;


import cap_software.hrms.core.dto.userDtos.JopSeekerDto;
import cap_software.hrms.entities.concretes.users.JopSeeker;

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
