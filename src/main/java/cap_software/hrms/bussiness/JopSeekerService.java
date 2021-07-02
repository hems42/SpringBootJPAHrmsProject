package cap_software.hrms.bussiness;


import cap_software.hrms.core.concstants.Messages;
import cap_software.hrms.core.dtoConvertors.JopSeekerDtoConvertor;
import cap_software.hrms.core.dtoRequestes.createRequest.CreateJopSeekerRequest;
import cap_software.hrms.core.dtoRequestes.createRequest.CreatePersonalInformationRequest;
import cap_software.hrms.core.utilities.results.DataResult;
import cap_software.hrms.core.utilities.results.SuccessDataResult;
import cap_software.hrms.core.verification.EmailVerify;
import cap_software.hrms.dataAccess.abstracts.JopSeekerDao;
import cap_software.hrms.entities.contacts.PersonalInformation;
import cap_software.hrms.entities.users.JopSeeker;
import cap_software.hrms.core.dto.contactDtos.PersonalInformationDto;
import cap_software.hrms.core.dto.userDtos.JopSeekerDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class JopSeekerService {


    private final JopSeekerDao jopSeekerDao;
    private final ModelMapper modelMapper;
    private final JopSeekerDtoConvertor convertorJopSeeker;

    public JopSeekerService(JopSeekerDao jopSeekerDao, ModelMapper modelMapper, JopSeekerDtoConvertor convertorJopSeeker) {
        this.jopSeekerDao = jopSeekerDao;
        this.modelMapper = modelMapper;
        this.convertorJopSeeker = convertorJopSeeker;
    }


    public DataResult<JopSeekerDto> createJopSeeker(CreateJopSeekerRequest JopSeekerRequest) {


        CreatePersonalInformationRequest personalInformationRequest = JopSeekerRequest.getPersonalInformation();

        JopSeeker jopSeeker = new JopSeeker();
        PersonalInformation personalInformation = new PersonalInformation();

        personalInformation.setName(personalInformationRequest.getName());
        personalInformation.setSurname(personalInformationRequest.getSurname());
        personalInformation.setNationalIdentityNumber(personalInformationRequest.getNationalIdentityNumber());
        personalInformation.setBirthOfDate(personalInformationRequest.getBirthOfDate());
        personalInformation.setSex(personalInformationRequest.getSex());
        personalInformation.setCreatedDate(LocalDateTime.now());
        personalInformation.setUser(jopSeeker);


        jopSeeker.setPersonalInformation(personalInformation);
        jopSeeker.setEmail(JopSeekerRequest.getEmail());
        jopSeeker.setPassword(JopSeekerRequest.getPassword());
        jopSeeker.setCreatedDate(LocalDateTime.now());
        jopSeeker.setIsActive(true);
        jopSeeker.setEmailVerification(EmailVerify.getEmailVerify());

        return new SuccessDataResult<>(convertorJopSeeker.convert(jopSeekerDao.save(jopSeeker)), Messages.KULLANICI_EKLEME_BASARILI);
    }


    public DataResult<JopSeeker> getJopSeekerById(String  id) {
        return new SuccessDataResult<>(jopSeekerDao.findById(id).get(), "Kullanıcı Başarıyla Getirildi " + id);
    }


    public DataResult<List<JopSeeker>> getAllJobSeekers() {
        return new SuccessDataResult<List<JopSeeker>>(jopSeekerDao.findAll(), "Kullanıcı Listesi Getirildi");
    }


    public DataResult<JopSeekerDto> deleteJopSeekerById(String  id) {
        JopSeeker jopSeeker = jopSeekerDao.findById(id).get();
        jopSeekerDao.deleteById(id);
        return new SuccessDataResult<>(convertToJopSeekerDto(jopSeeker), "Kullanıcı Başarıyla Silindi");
    }


    public DataResult<JopSeekerDto> deleteJopSeeker(JopSeekerDto jopSeekerDto) {
        JopSeeker jopSeeker = convertToJobSeeker(jopSeekerDto);
        jopSeekerDao.delete(jopSeeker);
        return new SuccessDataResult<>(convertToJopSeekerDto(jopSeeker), "Kullanıcı Başarıyla Silindi");
    }


    public DataResult<JopSeekerDto> updateJopSeeker(JopSeekerDto jopSeekerDto) {/*
        convertToPersonalInformationDto(jopSeekerDao.updatePersonalInformation(jopSeekerDto.getId(),
        convertToPersonalInformation(jopSeekerDto.getPersonalInformationDto())));*/

        JopSeeker jopSeeker = jopSeekerDao.findById(jopSeekerDto.getId()).get();

        PersonalInformation information = convertToPersonalInformation(jopSeekerDto.getPersonalInformation());
        information.setUser(jopSeeker);
        jopSeeker.setPersonalInformation(information);

        jopSeekerDao.save(jopSeeker);//updatePersonalInformation(jopSeeker.getId(),jopSeeker.getPersonalInformation());


        return new SuccessDataResult<>(convertToJopSeekerDto(jopSeekerDao.findById(jopSeekerDto.getId()).get()), "Kişisel Bilgi Güncellendi");
    }


    public DataResult<PersonalInformationDto> updateJopSeeker(String  id, PersonalInformationDto personalInformationDto) {

        JopSeeker jopSeeker = getJopSeeker(id);

        PersonalInformation personalInformation = convertToPersonalInformation(personalInformationDto);
        personalInformation.setUser(jopSeeker);
        personalInformation.setId(jopSeeker.getPersonalInformation().getId());
        jopSeeker.setPersonalInformation(personalInformation);
        jopSeekerDao.save(jopSeeker);
        return new SuccessDataResult<>(convertToPersonalInformationDto(getJopSeeker(id).getPersonalInformation()), "Kişisel Bilgi Güncellendi");
    }


    private JopSeeker convertToJobSeeker(JopSeekerDto jopSeekerDto) {
        JopSeeker jopSeeker = modelMapper.map(jopSeekerDto, JopSeeker.class);
        PersonalInformation information = modelMapper.map(jopSeekerDto.getPersonalInformation(), PersonalInformation.class);
        information.setUser(jopSeeker);
        jopSeeker.setPersonalInformation(information);
        return jopSeeker;
    }


    private JopSeekerDto convertToJopSeekerDto(JopSeeker jopSeeker) {
        JopSeekerDto resJopSeekerDto = modelMapper.map(jopSeeker, JopSeekerDto.class);
        PersonalInformationDto resInformationDto = modelMapper.map(jopSeeker.getPersonalInformation(), PersonalInformationDto.class);
        resJopSeekerDto.setPersonalInformation(resInformationDto);
        return resJopSeekerDto;
    }


    private PersonalInformation convertToPersonalInformation(PersonalInformationDto personalInformationDto) {
        PersonalInformation resInformation = modelMapper.map(personalInformationDto, PersonalInformation.class);
        return resInformation;
    }

    private PersonalInformationDto convertToPersonalInformationDto(PersonalInformation personalInformation) {
        PersonalInformationDto resInformationDto = modelMapper.map(personalInformation, PersonalInformationDto.class);
        return resInformationDto;
    }

    private JopSeeker getJopSeeker(String id) {
        return jopSeekerDao.getById(id);
    }

}
