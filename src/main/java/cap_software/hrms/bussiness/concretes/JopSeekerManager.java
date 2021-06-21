package cap_software.hrms.bussiness.concretes;


import cap_software.hrms.bussiness.abstracts.JopSeekerService;
import cap_software.hrms.core.convertors.DtoConvertor;
import cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts.CheckValidPersonService;
import cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts.EmailService;
import cap_software.hrms.core.utilities.results.DataResult;
import cap_software.hrms.core.utilities.results.SuccessDataResult;
import cap_software.hrms.core.verification.EmailVerify;
import cap_software.hrms.dataAccess.abstracts.JopSeekerDao;
import cap_software.hrms.entities.concretes.contacts.PersonalInformation;
import cap_software.hrms.entities.concretes.users.JopSeeker;
import cap_software.hrms.entities.dtos.contactDtos.PersonalInformationDto;
import cap_software.hrms.entities.dtos.userDtos.JopSeekerDto;
import cap_software.hrms.entities.mapstructExams.Parent;
import cap_software.hrms.entities.mapstructExams.ParentMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class JopSeekerManager implements JopSeekerService {

    @Autowired
    private  JopSeekerDao  jopSeekerDao;




    private final ModelMapper modelMapper;
    private final ParentMapper  mapper;



    private EmailService  emailService;
    private CheckValidPersonService checkValidPersonService;

    @Override
    public DataResult<JopSeekerDto> addJopSeeker(JopSeekerDto jopSeekerDto)
    {
        Parent parent=new Parent("hh","ll",22);

        System.out.println("dto dan gelen :"+mapper.fromParent(parent));

        JopSeeker jopSeeker=convertToJobSeeker(jopSeekerDto);
       // jopSeeker.setUserNumber("JBSKR-"+new Random().nextInt());
        jopSeeker.setEmailVerification(EmailVerify.getEmailVerify());
        return new SuccessDataResult<JopSeekerDto>(convertToJopSeekerDto(jopSeekerDao.save(jopSeeker)),"Kullanıcı Eklemesi Başarılı");}

    @Override
    public DataResult<List<JopSeekerDto>> addJopSeeker(List<JopSeekerDto> jopSeekerDtos) {
        Iterable<JopSeeker> jbs=jopSeekerDtos.stream().map(j->convertToJobSeeker(j)).collect(Collectors.toList());
        return new SuccessDataResult<List<JopSeekerDto>>(jopSeekerDao.saveAll(jbs).stream().map(j->convertToJopSeekerDto(j)).collect(Collectors.toList()),"Liste Basşarıyla Eklenmiştir");
    }

    @Override
    public DataResult<JopSeekerDto> getById(int id) {
        return new SuccessDataResult<>(convertToJopSeekerDto(jopSeekerDao.findById(id).get()),"Kullanıcı Başarıyla Getirildi");
    }

    @Override
    public DataResult<List<JopSeekerDto>> getAllJobSeekers()
    {return new SuccessDataResult<List<JopSeekerDto>>(jopSeekerDao.findAll().stream().map(j->convertToJopSeekerDto(j)).collect(Collectors.toList()),"Kullanıcı Listesi Getirildi");}


    @Override
    public DataResult<JopSeekerDto> deleteById(int id) {
        JopSeeker  jopSeeker=jopSeekerDao.findById(id).get();
        jopSeekerDao.deleteById(id);
        return new SuccessDataResult<>(convertToJopSeekerDto(jopSeeker),"Kullanıcı Başarıyla Silindi");
    }

    @Override
    public DataResult<JopSeekerDto> delete(JopSeekerDto jopSeekerDto) {
        JopSeeker  jopSeeker=convertToJobSeeker(jopSeekerDto);
        jopSeekerDao.delete(jopSeeker);
        return new SuccessDataResult<>(convertToJopSeekerDto(jopSeeker),"Kullanıcı Başarıyla Silindi");
    }


    @Override
    public DataResult<JopSeekerDto> update(JopSeekerDto jopSeekerDto) {/*
        convertToPersonalInformationDto(jopSeekerDao.updatePersonalInformation(jopSeekerDto.getId(),
        convertToPersonalInformation(jopSeekerDto.getPersonalInformationDto())));*/

        JopSeeker jopSeeker=jopSeekerDao.findById(jopSeekerDto.getId()).get();

        PersonalInformation information=convertToPersonalInformation(jopSeekerDto.getPersonalInformationDto());
        information.setUser(jopSeeker);
        jopSeeker.setPersonalInformation(information);

        jopSeekerDao.save(jopSeeker);//updatePersonalInformation(jopSeeker.getId(),jopSeeker.getPersonalInformation());


        return new SuccessDataResult<>(convertToJopSeekerDto(jopSeekerDao.findById(jopSeekerDto.getId()).get()),"Kişisel Bilgi Güncellendi");
    }

    @Override
    public DataResult<PersonalInformationDto> update(int id,PersonalInformationDto personalInformationDto) {

        JopSeeker jopSeeker=getJopSeeker(id);

        PersonalInformation  personalInformation=convertToPersonalInformation(personalInformationDto);
        personalInformation.setUser(jopSeeker);
        personalInformation.setId(jopSeeker.getPersonalInformation().getId());
        jopSeeker.setPersonalInformation(personalInformation);
        jopSeekerDao.save(jopSeeker);
        return new SuccessDataResult<>(convertToPersonalInformationDto(getJopSeeker(id).getPersonalInformation()),"Kişisel Bilgi Güncellendi");
    }


    private JopSeeker convertToJobSeeker(JopSeekerDto jopSeekerDto)
    {   JopSeeker jopSeeker=modelMapper.map(jopSeekerDto,JopSeeker.class);
        PersonalInformation information=modelMapper.map(jopSeekerDto.getPersonalInformationDto(), PersonalInformation.class);
        information.setUser(jopSeeker);
        jopSeeker.setPersonalInformation(information); return jopSeeker;}


    private JopSeekerDto convertToJopSeekerDto(JopSeeker jopSeeker)
    {
        JopSeekerDto resJopSeekerDto=modelMapper.map(jopSeeker,JopSeekerDto.class);
        PersonalInformationDto resInformationDto=modelMapper.map(jopSeeker.getPersonalInformation(), PersonalInformationDto.class);
        resJopSeekerDto.setPersonalInformationDto(resInformationDto);
        return resJopSeekerDto;
    }


    private PersonalInformation convertToPersonalInformation(PersonalInformationDto personalInformationDto)
    {
        PersonalInformation resInformation=modelMapper.map(personalInformationDto, PersonalInformation.class);
        return resInformation;
    }

    private PersonalInformationDto convertToPersonalInformationDto(PersonalInformation personalInformation)
    {
        PersonalInformationDto resInformationDto=modelMapper.map(personalInformation, PersonalInformationDto.class);
        return resInformationDto;
    }

    private JopSeeker getJopSeeker(int id)
    {
        return  jopSeekerDao.getById(id);
    }

}
