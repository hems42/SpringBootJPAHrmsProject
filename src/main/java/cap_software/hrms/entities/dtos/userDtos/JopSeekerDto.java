package cap_software.hrms.entities.dtos.userDtos;


import cap_software.hrms.core.validations.ValidRealPerson;
import cap_software.hrms.entities.concretes.contacts.PersonalInformation;
import cap_software.hrms.entities.concretes.users.JopSeeker;
import cap_software.hrms.entities.dtos.contactDtos.PersonalInformationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.util.Random;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JopSeekerDto extends UserDto{

                    /*
                    *
                Req 1 : İş Arayanlar sisteme kayıt olabilmelidir.

                Kabul Kriterleri:

                Kayıt sırasında kullanıcıdan ad, soyad, tcno, doğum yılı, e-Posta, şifre, şifre tekrarı bilgileri istenir.
                Tüm alanlar zorunludur. Kullanıcı bilgilendirilir.
                Mernis doğrulaması yapılarak sisteme kayıt gerçekleştirilir.
                Doğrulama geçerli değilse kullanıcı bilgilendirilir.
                Daha önce kayıtlı bir e-posta veya tcno var ise kayıt gerçekleşmez. Kullanıcı bilgilendirilir.
                Kayıdın gerçekleşmesi için e-posta doğrulaması gerekir.
                */


    private PersonalInformationDto personalInformationDto;





}
