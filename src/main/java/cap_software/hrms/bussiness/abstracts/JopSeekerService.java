package cap_software.hrms.bussiness.abstracts;

import cap_software.hrms.core.utilities.results.DataResult;
import cap_software.hrms.entities.concretes.contacts.PersonalInformation;
import cap_software.hrms.entities.dtos.contactDtos.PersonalInformationDto;
import cap_software.hrms.entities.dtos.userDtos.JopSeekerDto;

import java.util.List;


public interface JopSeekerService {

    DataResult<JopSeekerDto> addJopSeeker(JopSeekerDto jopSeekerDto);

    DataResult<List<JopSeekerDto>> addJopSeeker(List<JopSeekerDto> jopSeekerDtos);

    DataResult<JopSeekerDto> getById(int id);

    DataResult<List<JopSeekerDto>> getAllJobSeekers();

    DataResult<JopSeekerDto> deleteById(int id);

    DataResult<JopSeekerDto>  delete(JopSeekerDto jopSeekerDto);

    DataResult<JopSeekerDto>  update(JopSeekerDto jopSeekerDto);

    DataResult<PersonalInformationDto>  update(int id,PersonalInformationDto personalInformationDto);


}
