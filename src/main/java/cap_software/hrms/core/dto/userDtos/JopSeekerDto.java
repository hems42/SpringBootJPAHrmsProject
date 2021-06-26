package cap_software.hrms.core.dto.userDtos;



import cap_software.hrms.core.dto.contactDtos.PersonalInformationDto;
import cap_software.hrms.core.dto.utilDtos.AuthParametersDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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

    private AuthParametersDto authParametersDto;

    private PersonalInformationDto personalInformationDto;





}
