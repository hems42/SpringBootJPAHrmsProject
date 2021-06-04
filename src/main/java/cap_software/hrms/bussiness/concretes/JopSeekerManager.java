package cap_software.hrms.bussiness.concretes;

import cap_software.hrms.bussiness.abstracts.JopSeekerService;
import cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts.CheckPersonService;
import cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts.EmailService;
import cap_software.hrms.core.utilities.results.DataResult;
import cap_software.hrms.core.utilities.results.SuccessDataResult;
import cap_software.hrms.dataAccess.abstracts.JopSeekerDao;
import cap_software.hrms.entities.concretes.contacts.PersonalInformation;
import cap_software.hrms.entities.concretes.users.JopSeeker;
import cap_software.hrms.entities.concretes.utils.DateParametres;
import cap_software.hrms.entities.concretes.verifications.EmailVerification;
import cap_software.hrms.entities.dtos.userDtos.JopSeekerDto;
import cap_software.hrms.entities.dtos.userDtos.PersonalInformationDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class JopSeekerManager implements JopSeekerService {

    @Autowired
    private  JopSeekerDao  jopSeekerDao;





    private final ModelMapper modelMapper;
    private EmailService  emailService;
    private CheckPersonService checkPersonService;

    @Override
    public DataResult<JopSeekerDto> addJopSeeker(JopSeekerDto jopSeekerDto) {


        EmailVerification emailVerification= new EmailVerification();
        emailVerification.setVerifed(false);
        emailVerification.setExpiryDate(Date.valueOf("2021-06-01"));
        emailVerification.setToken("n56+df54g56df455645d64fg56df4g5s" +
                "d4f5s6f4s56f4sd5645w6e456sd4f56sd4f65sd4f56sf" +
                "sd6s5ad56as4d6s4ad6+as4d6as45d56as4d56a4s5d64as5d4as56");


        JopSeeker jopSeeker=modelMapper.map(jopSeekerDto,JopSeeker.class);
        PersonalInformation information=modelMapper.map(jopSeekerDto.getPersonalInformationDto(),PersonalInformation.class);


        jopSeeker.setUserNumber("JBSKR-"+ LocalDateTime.now());
        information.setUser(jopSeeker);
        jopSeeker.setPersonalInformation(information);
        jopSeeker.setEmailVerification(emailVerification);




        jopSeekerDao.save(jopSeeker);

        JopSeekerDto resJopSeekerDto=modelMapper.map(jopSeeker,JopSeekerDto.class);
        PersonalInformationDto resInformationDto=modelMapper.map(jopSeeker.getPersonalInformation(),PersonalInformationDto.class);

        resJopSeekerDto.setPersonalInformationDto(resInformationDto);



        return new SuccessDataResult<JopSeekerDto>(resJopSeekerDto,"Kullanıcı Eklemesi Başarılı");



    }




    @Override
    public DataResult<List<JopSeekerDto>> getAll() {


        return null;
    }
}
