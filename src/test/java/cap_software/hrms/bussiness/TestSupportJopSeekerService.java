package cap_software.hrms.bussiness;

import cap_software.hrms.core.dto.contactDtos.PersonalInformationDto;
import cap_software.hrms.core.dto.userDtos.JopSeekerDto;
import cap_software.hrms.core.dtoRequestes.createRequest.CreateJopSeekerRequest;
import cap_software.hrms.core.dtoRequestes.createRequest.CreatePersonalInformationRequest;

import java.time.LocalDate;

public class TestSupportJopSeekerService {

    public static CreatePersonalInformationRequest generateCreatePersonalInformationRequest()
    {
        return new CreatePersonalInformationRequest(
                "ALİ",
                "YILMAZ",
                "00000000000",
                LocalDate.of(1991,8,16),
                "ERKEK");
    }

    public static CreateJopSeekerRequest generateCreateJopSeekerRequest()
    {
        CreateJopSeekerRequest jopSeekerRequest=new CreateJopSeekerRequest(generateCreatePersonalInformationRequest());

        jopSeekerRequest.setEmail("deneme@gmail.com");
        jopSeekerRequest.setPassword("password");
        jopSeekerRequest.setMatchingPassword("password");

        return jopSeekerRequest;
    }

    public static PersonalInformationDto generatePersonalInformationDto()
    {
        return new PersonalInformationDto(
                0,
                "ALİ",
                "YILMAZ",
                "00000000000",
                LocalDate.of(1991,8,16),
                "ERKEK",
                null,
                null);
    }

    public static JopSeekerDto generateJopSeekerDto()
    {
        JopSeekerDto jopSeekerDto=new JopSeekerDto(
                true,
                generatePersonalInformationDto());

        jopSeekerDto.setEmail("deneme@gmail.com");
        jopSeekerDto.setPassword("password");
        jopSeekerDto.setId("id");
        return jopSeekerDto;
    }
}
