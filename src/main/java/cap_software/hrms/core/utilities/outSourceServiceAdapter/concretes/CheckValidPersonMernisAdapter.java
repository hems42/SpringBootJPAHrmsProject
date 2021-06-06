package cap_software.hrms.core.utilities.outSourceServiceAdapter.concretes;

import cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts.CheckValidPersonService;
import cap_software.hrms.outSourceServices.mernis.IWWKPSPublicSoap;

public class CheckValidPersonMernisAdapter implements CheckValidPersonService {

    private IWWKPSPublicSoap publicSoap;

    public CheckValidPersonMernisAdapter() {
        publicSoap= new IWWKPSPublicSoap();
    }


    @Override
    public boolean isValidPerson(String nationalIdentityNumber, String name, String surname, String bornOfYear) {

        //final Long TCKimlikNo,final String Ad,final String Soyad,final Integer DogumYili

        boolean result;

        try {
          result=publicSoap.TCKimlikNoDogrula(Long.parseLong(nationalIdentityNumber),
                    name.toUpperCase(),
                    surname.toUpperCase(),
                    Integer.valueOf(bornOfYear)
                    );
        } catch (Exception e) {
            e.printStackTrace();

            result=false;
        }

        return result;
    }
}
