package cap_software.hrms.bussiness.concretes;

import cap_software.hrms.bussiness.abstracts.JopSeekerService;
import cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts.CheckValidPersonService;
import cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts.EmailService;
import cap_software.hrms.core.utilities.results.DataResult;
import cap_software.hrms.core.utilities.results.SuccessDataResult;
import cap_software.hrms.dataAccess.abstracts.JopSeekerDao;
import cap_software.hrms.entities.concretes.contacts.PersonalInformation;
import cap_software.hrms.entities.concretes.users.JopSeeker;
import cap_software.hrms.entities.concretes.verifications.EmailVerification;
import cap_software.hrms.entities.dtos.contactDtos.PersonalInformationDto;
import cap_software.hrms.entities.dtos.userDtos.JopSeekerDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class JopSeekerManager implements JopSeekerService {

    @Autowired
    private  JopSeekerDao  jopSeekerDao;





    private final ModelMapper modelMapper;
    private EmailService  emailService;
    private CheckValidPersonService checkValidPersonService;

    @Override
    public DataResult<JopSeekerDto> addJopSeeker(JopSeekerDto jopSeekerDto) {







        EmailVerification emailVerification= new EmailVerification();
        emailVerification.setVerifed(false);
        emailVerification.setExpiryDate(Date.valueOf("2021-06-01"));
        emailVerification.setToken("n56+df54g56df455645d64fg56df4g5s" +
                "d4f5s6f4s56f4sd5645w6e456sd4f56sd4f65sd4f56sf" +
                "sd6s5ad56as4d6s4ad6+as4d6as45d56as4d56a4s5d64as5d4as56");


        JopSeeker jopSeeker=modelMapper.map(jopSeekerDto,JopSeeker.class);
        PersonalInformation information=modelMapper.map(jopSeekerDto.getPersonalInformationDto(), PersonalInformation.class);


        jopSeeker.setUserNumber("JBSKR-"+ LocalDateTime.now());
        information.setUser(jopSeeker);
        jopSeeker.setPersonalInformation(information);
        jopSeeker.setEmailVerification(emailVerification);





        jopSeekerDao.save(jopSeeker);

        JopSeekerDto resJopSeekerDto=modelMapper.map(jopSeeker,JopSeekerDto.class);
        PersonalInformationDto resInformationDto=modelMapper.map(jopSeeker.getPersonalInformation(), PersonalInformationDto.class);

        resJopSeekerDto.setPersonalInformationDto(resInformationDto);



        return new SuccessDataResult<JopSeekerDto>(resJopSeekerDto,"Kullanıcı Eklemesi Başarılı");



    }

    @Override
    public DataResult<List<JopSeekerDto>> getAllJobSeekers() {

        List<JopSeekerDto> jobSeekerDtos= new ArrayList<JopSeekerDto>();
        JopSeekerDto jopSeekerDto = null;
        PersonalInformationDto personalInformationDto=null;

       for(JopSeeker jopSeeker:jopSeekerDao.findAll())
       {
           jopSeekerDto=modelMapper.map(jopSeeker,JopSeekerDto.class);
           personalInformationDto=modelMapper.map(jopSeeker.getPersonalInformation(),PersonalInformationDto.class);
           jopSeekerDto.setPersonalInformationDto(personalInformationDto);
           jobSeekerDtos.add(jopSeekerDto);

       }

        return new SuccessDataResult<List<JopSeekerDto>>(jobSeekerDtos,"Kullanıcı Listesi Getirildi");
    }

    @Override
    public DataResult<JopSeekerDto> getById(int id) {
        return null;
    }



}
