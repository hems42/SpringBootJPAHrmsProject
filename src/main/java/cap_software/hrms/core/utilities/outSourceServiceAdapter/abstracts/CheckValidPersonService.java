package cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts;

public interface CheckValidPersonService {

    boolean isValidPerson(String nationalIdentityNumber,String name, String surname, String bornOfYear);
      //
}
