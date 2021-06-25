package cap_software.hrms.core.dto.cvDtos;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumVitaeDto {
	
	private List<SchoolDto> schools;
	

}
