package cap_software.hrms.core.testSupport;

import cap_software.hrms.core.dto.contactDtos.PersonalInformationDto;
import cap_software.hrms.core.dto.userDtos.JopSeekerDto;
import cap_software.hrms.core.dtoRequestes.createRequest.CreateJopSeekerRequest;
import cap_software.hrms.core.dtoRequestes.createRequest.CreatePersonalInformationRequest;
import cap_software.hrms.entities.contacts.PersonalInformation;
import cap_software.hrms.entities.users.JopSeeker;

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

    public static PersonalInformation generatePersonalInformation()
    {
        return new PersonalInformation(
                0,
                "ALİ",
                "YILMAZ",
                "00000000000",
                LocalDate.of(1991,8,16),
                "ERKEK",
                null,
                null,
                null
        );
    }

    public static JopSeeker generateJopSeeker()
    {
        JopSeeker jopSeeker= new JopSeeker();
        PersonalInformation  personalInformation=generatePersonalInformation();


        personalInformation.setUser(jopSeeker);
        jopSeeker.setIsActive(true);
        jopSeeker.setPersonalInformation(personalInformation);
        jopSeeker.setEmail("deneme@gmail.com");
        jopSeeker.setPassword("password");
        jopSeeker.setId("id");
        return jopSeeker;
    }
}
