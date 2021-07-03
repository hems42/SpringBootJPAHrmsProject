package cap_software.hrms.core.dtoConvertors;


import cap_software.hrms.core.dto.userDtos.JopSeekerDto;
import cap_software.hrms.entities.users.JopSeeker;
import org.springframework.stereotype.Component;

@Component
public class JopSeekerDtoConvertor {


    private final PersonalInformationDtoConvertor convertorPerson;


    public JopSeekerDtoConvertor(PersonalInformationDtoConvertor convertorPerson)
    {
        this.convertorPerson = convertorPerson;
    }

    public JopSeeker convert(JopSeekerDto from) {

        JopSeeker jopSeeker = new JopSeeker(
                convertorPerson.convert(from.getPersonalInformation()),
                from.getIsActive(),
                null,
                null
        );

        jopSeeker.setCreatedDate(from.getCreatedDate());
        if (from.getUpdatedDate() != null) {
            jopSeeker.setUpdatedDate(from.getUpdatedDate());
        }

        return jopSeeker;
    }

    public JopSeekerDto convert(JopSeeker from) {
        JopSeekerDto jopSeekerDto = new JopSeekerDto(
                from.getIsActive(),
                convertorPerson.convert(from.getPersonalInformation())
        );

        jopSeekerDto.setEmail(from.getEmail());
        jopSeekerDto.setId(from.getId());
        jopSeekerDto.setPassword(from.getPassword());
        jopSeekerDto.setCreatedDate(from.getCreatedDate());
        if (from.getUpdatedDate() != null) {
            jopSeekerDto.setUpdatedDate(from.getUpdatedDate());
        }
        return jopSeekerDto;
    }
}
