package cap_software.hrms.bussiness.abstracts;

import cap_software.hrms.core.utilities.results.DataResult;
import cap_software.hrms.entities.dtos.userDtos.JopSeekerDto;

import java.util.List;


public interface JopSeekerService {

    DataResult<JopSeekerDto> addJopSeeker(JopSeekerDto jopSeekerDto);

    DataResult<List<JopSeekerDto>> getAll();

}
