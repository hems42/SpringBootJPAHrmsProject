package cap_software.hrms.bussiness.concretes;


import cap_software.hrms.bussiness.abstracts.JopSeekerService;
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
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
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
    private CheckValidPersonService checkValidPersonService;

    @Override
    public DataResult<JopSeekerDto> addJopSeeker(JopSeekerDto jopSeekerDto)
    {   JopSeeker jopSeeker=convertToJobSeeker(jopSeekerDto);
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
    public DataResult<JopSeekerDto> updateById(int id) {
        return null;
    }

    @Override
    public DataResult<JopSeekerDto> update(JopSeekerDto jopSeekerDto) {
        return null;
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
}
