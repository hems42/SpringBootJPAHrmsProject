package cap_software.hrms.bussiness.concretes;

import cap_software.hrms.bussiness.abstracts.JopSeekerService;
import cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts.CheckPersonService;
import cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts.EmailService;
import cap_software.hrms.core.utilities.results.DataResult;
import cap_software.hrms.core.utilities.results.SuccessDataResult;
import cap_software.hrms.dataAccess.abstracts.JopSeekerDao;
import cap_software.hrms.entities.concretes.contacts.PersonalInformation;
import cap_software.hrms.entities.concretes.users.JopSeeker;
import cap_software.hrms.entities.concretes.utils.AuthParametres;
import cap_software.hrms.entities.concretes.utils.DateParametres;
import cap_software.hrms.entities.concretes.verifications.EmailVerification;
import cap_software.hrms.entities.dtos.userDtos.JopSeekerDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

        JopSeeker jopSeeker=modelMapper.map(jopSeekerDto,JopSeeker.class);

        PersonalInformation information= new PersonalInformation();

        EmailVerification emailVerification= new EmailVerification();
        emailVerification.setVerifed(false);
        emailVerification.setExpiryDate(Date.valueOf("2021-06-01"));
        emailVerification.setToken("new Random().nextInt()"+jopSeekerDto.getName());
         emailVerification.setDateParametres(new DateParametres());

        jopSeeker.setUserNumber(Integer.toString(new Random().nextInt()));
        jopSeeker.setEmail(jopSeekerDto.getEmail());
        jopSeeker.setPassword(jopSeekerDto.getPassword());
        jopSeeker.setAuthParametres(new AuthParametres(true));
        jopSeeker.setPersonalInformation(information);
        jopSeeker.setDateParametres(new DateParametres());


        information.setUser(jopSeeker);
        information.setName(jopSeekerDto.getName());
        information.setSurname(jopSeekerDto.getSurname());
        information.setBirthDay(jopSeekerDto.getBirthOfDate());
        information.setNationalIdentityNumber(jopSeekerDto.getNationalIdentityNumber());
        information.setSex(jopSeekerDto.getSex());


        jopSeeker.setEmailVerification(emailVerification);

        JopSeekerDto seekerDto= new JopSeekerDto();
        seekerDto.setSex(jopSeekerDto.getSex());
        seekerDto.setBirthOfDate(jopSeekerDto.getBirthOfDate());
        seekerDto.setName(jopSeekerDto.getName());
        seekerDto.setSurname(jopSeekerDto.getSurname());
        seekerDto.setNationalIdentityNumber(jopSeekerDto.getNationalIdentityNumber());
        seekerDto.setEmail(jopSeekerDto.getEmail());
        seekerDto.setMatchingPassword(jopSeekerDto.getMatchingPassword());
        seekerDto.setPassword(jopSeekerDto.getPassword());


        return new SuccessDataResult<JopSeekerDto>(modelMapper.map(jopSeekerDao.save(jopSeeker), JopSeekerDto.class),"kullanıcı başarıyla eklendi");

       // return new SuccessDataResult<>(seekerDto, "kullanıcı başarıyla eklendi");



    }

/*
    @Override
    public DataResult<JopSeekerDto> addJopSeeker(JopSeekerDto jopSeekerDto) {

        JopSeeker jopSeeker=new JopSeeker();

        jopSeeker.setJopSeekerDto(jopSeekerDto);

        EmailVerification emailVerification= new EmailVerification();
        emailVerification.setVerifed(false);
        emailVerification.setExpiryDate(Date.valueOf("2021-06-01"));
        emailVerification.setToken("new Random().nextInt()"+jopSeekerDto.getName());
        emailVerification.setDateParametres(new DateParametres());

        jopSeeker.setEmailVerification(emailVerification);






        return new SuccessDataResult<JopSeekerDto>(jopSeeker.getJobSeekerDto(),"kullanıcı başarıyla eklendi");

        // return new SuccessDataResult<>(seekerDto, "kullanıcı başarıyla eklendi");



    }*/


    @Override
    public DataResult<List<JopSeekerDto>> getAll() {

        JopSeeker jb;
      /*  List<JopSeekerDto> jopSeekerDtos=jopSeekerDao.findAll().stream().map(j ->


                modelMapper.map(j,JopSeekerDto.class))
                .collect(Collectors.toList());*/
        List<JopSeekerDto> jopSeekerDtos=jopSeekerDao.findAll().stream().map(j ->j.getJobSeekerDto()).collect(Collectors.toList());



        return new SuccessDataResult<>(jopSeekerDtos, "kullanıcılar başarıyla getirildi");
    }
}
