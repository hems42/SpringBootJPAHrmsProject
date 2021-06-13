package cap_software.hrms.core.convertors;

import cap_software.hrms.entities.concretes.contacts.PersonalInformation;
import cap_software.hrms.entities.concretes.users.JopSeeker;
import cap_software.hrms.entities.dtos.contactDtos.PersonalInformationDto;
import cap_software.hrms.entities.dtos.userDtos.JopSeekerDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;


@AllArgsConstructor
public  class DtoConvertor {


    private static  ModelMapper modelMapper=new ModelMapper();




    public static PersonalInformation convertToPersonalInformation(PersonalInformationDto personalInformationDto)
    {PersonalInformation information=modelMapper.map(personalInformationDto, PersonalInformation.class); return information;}

    public  static  PersonalInformationDto convertToPersonalInformationDto(PersonalInformation personalInformation)
    {PersonalInformationDto information=modelMapper.map(personalInformation, PersonalInformationDto.class); return information;}

    public static JopSeeker convertToJopseeker(JopSeekerDto jopSeekerDto)
    {
    JopSeeker jopSeeker=modelMapper.map(jopSeekerDto,JopSeeker.class);
    jopSeeker.setPersonalInformation(convertToPersonalInformation(jopSeekerDto.getPersonalInformationDto()));
    return jopSeeker;
    }

    public  static  JopSeekerDto convertToJopSeekerDto(JopSeeker jopSeeker)
    {
        JopSeekerDto jopSeekerDto=modelMapper.map(jopSeeker,JopSeekerDto.class);
        jopSeekerDto.setPersonalInformationDto(convertToPersonalInformationDto(jopSeeker.getPersonalInformation()));
        return jopSeekerDto;
    }

}
