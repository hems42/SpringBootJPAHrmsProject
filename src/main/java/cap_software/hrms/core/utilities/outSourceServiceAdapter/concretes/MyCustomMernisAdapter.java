package cap_software.hrms.core.utilities.outSourceServiceAdapter.concretes;

import cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts.CheckPersonService;
import cap_software.hrms.entities.concretes.contacts.PersonalInformation;

public class MyCustomMernisAdapter implements CheckPersonService {
    @Override
    public boolean isValidPerson(PersonalInformation information) {
        return true;
    }
}
