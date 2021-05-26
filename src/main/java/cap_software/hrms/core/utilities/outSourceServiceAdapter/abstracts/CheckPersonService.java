package cap_software.hrms.core.utilities.outSourceServiceAdapter.abstracts;

import cap_software.hrms.entities.concretes.contacts.PersonalInformation;

public interface CheckPersonService {

    boolean isValidPerson(PersonalInformation information);

}
