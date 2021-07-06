package cap_software.hrms.bussiness;


import cap_software.hrms.core.constants.Messages;
import cap_software.hrms.core.dtoConvertors.JopSeekerDtoConvertor;
import cap_software.hrms.core.dtoRequestes.createRequest.CreateJopSeekerRequest;
import cap_software.hrms.core.dtoRequestes.createRequest.CreatePersonalInformationRequest;
import cap_software.hrms.core.dtoRequestes.updateRequest.UpdateJopSeekerRequest;
import cap_software.hrms.core.dtoRequestes.updateRequest.UpdatePersonalInformationRequest;
import cap_software.hrms.core.exceptions.AlReadyExistUserException;
import cap_software.hrms.core.exceptions.UserNotFoundException;
import cap_software.hrms.core.utilities.results.DataResult;
import cap_software.hrms.core.utilities.results.SuccessDataResult;
import cap_software.hrms.core.verification.EmailVerify;
import cap_software.hrms.dataAccess.abstracts.JopSeekerDao;
import cap_software.hrms.entities.contacts.PersonalInformation;
import cap_software.hrms.entities.users.JopSeeker;
import cap_software.hrms.core.dto.userDtos.JopSeekerDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class JopSeekerService {


    private final JopSeekerDao jopSeekerDao;
    private final JopSeekerDtoConvertor convertorJopSeeker;

    public JopSeekerService(JopSeekerDao jopSeekerDao, JopSeekerDtoConvertor convertorJopSeeker) {
        this.jopSeekerDao = jopSeekerDao;
        this.convertorJopSeeker = convertorJopSeeker;
    }


    public DataResult<JopSeekerDto> createJopSeeker(CreateJopSeekerRequest jopSeekerRequest) {

        if (isAlReadyExistJopSeeker(jopSeekerRequest.getEmail()) == null) {
            CreatePersonalInformationRequest personalInformationRequest = jopSeekerRequest.getPersonalInformation();

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
            jopSeeker.setEmail(jopSeekerRequest.getEmail());
            jopSeeker.setPassword(jopSeekerRequest.getPassword());
            jopSeeker.setCreatedDate(LocalDateTime.now());
            jopSeeker.setIsActive(true);
            jopSeeker.setEmailVerification(EmailVerify.getEmailVerify());

            return new SuccessDataResult<>(convertorJopSeeker.convert(jopSeekerDao.save(jopSeeker)), Messages.KULLANICI_EKLEME_BASARILI);
        } else {
            return new SuccessDataResult<>(new JopSeekerDto(), Messages.KULLANICI_DAHA_ONCE_EKLENMİS);

        }


    }


    public DataResult<JopSeekerDto> getJopSeekerById(String id) {
        return new SuccessDataResult<>(convertorJopSeeker.convert(getJopSeeker(id)), Messages.KULLANICI_BULUNDU);
    }


    public DataResult<List<JopSeekerDto>> getAllJobSeekers() {
        return new SuccessDataResult<List<JopSeekerDto>>(jopSeekerDao.findAll()
                .stream().map((j) -> convertorJopSeeker.convert(j))
                .collect(Collectors.toList()), Messages.KULLANICI_LİSTESİ_GETİRİLDİ);
    }


    public DataResult<Boolean> deleteJopSeekerById(String id) {
        JopSeeker jopSeeker = getJopSeeker(id);
        jopSeekerDao.delete(jopSeeker);
        return new SuccessDataResult<>(true, Messages.KULLANICI_SİLİNDİ);
    }


    public DataResult<JopSeekerDto> updateJopSeekerById(String id,
                                                        UpdateJopSeekerRequest jopSeekerRequest) {

        if (isAlReadyExistJopSeeker(jopSeekerRequest.getEmail()) != null) {
            UpdatePersonalInformationRequest informationRequest = jopSeekerRequest.getPersonalInformationRequest();

            JopSeeker jopSeeker = getJopSeeker(id);

            jopSeeker.setEmail(jopSeekerRequest.getEmail());
            jopSeeker.setPassword(jopSeekerRequest.getPassword());
            jopSeeker.setUpdatedDate(LocalDateTime.now());

            PersonalInformation information = jopSeeker.getPersonalInformation();

            information.setUpdatedDate(LocalDateTime.now());
            information.setSex(informationRequest.getSex());
            information.setName(informationRequest.getName());
            information.setSurname(informationRequest.getSurname());
            information.setBirthOfDate(informationRequest.getBirthOfDate());
            information.setNationalIdentityNumber(informationRequest.getNationalIdentityNumber());

            jopSeeker.setPersonalInformation(information);
            return new SuccessDataResult<>(convertorJopSeeker.convert(jopSeekerDao.save(jopSeeker)),
                    Messages.KULLANICI_GÜNCELLENDİ + " " + id);
        } else {
            return new SuccessDataResult<>(new JopSeekerDto());
        }


    }


    public DataResult<JopSeekerDto> updateJopSeekerPersonalInformationById(String id,
                                                                           UpdatePersonalInformationRequest personalInformationRequest) {

        JopSeeker jopSeeker = getJopSeeker(id);

        PersonalInformation information = jopSeeker.getPersonalInformation();

        information.setUpdatedDate(LocalDateTime.now());
        information.setSex(personalInformationRequest.getSex());
        information.setName(personalInformationRequest.getName());
        information.setSurname(personalInformationRequest.getSurname());
        information.setBirthOfDate(personalInformationRequest.getBirthOfDate());
        information.setNationalIdentityNumber(personalInformationRequest.getNationalIdentityNumber());

        jopSeeker.setPersonalInformation(information);


        return new SuccessDataResult<>(convertorJopSeeker.convert(jopSeekerDao.save(jopSeeker)),
                Messages.KULLANICI_KİŞİSEL_BİLGİLERİ_GÜNCELLENDİ + " " + id);
    }


    public DataResult<Boolean> updateActiveJopSeekerById(String id, Boolean isActive) {
        JopSeeker jopSeeker = getJopSeeker(id);

        jopSeeker.setIsActive(isActive);

        jopSeekerDao.save(jopSeeker);

        return isActive == true ? new SuccessDataResult<>(true, Messages.KULLANICI_AKTİF_EDİLDİ) :
                new SuccessDataResult<>(false, Messages.KULLANICI_PASİFE_ALINDI);
    }


    private JopSeeker getJopSeeker(String id) {
        return jopSeekerDao.findById(id).orElseThrow(() -> new UserNotFoundException(Messages.KULLANICI_BULUNAMADI));
    }

    private JopSeeker isAlReadyExistJopSeeker(String email) {
        JopSeeker jopSeeker = jopSeekerDao.getJopSeekerByEmail(email).get();

        if (jopSeeker != null) {
            return jopSeeker;
        } else {
         throw  new AlReadyExistUserException(email + " " + Messages.KULLANICI_DAHA_ONCE_EKLENMİS);
        }
    }

}
