package cap_software.hrms.core.dto.utilDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateParametersDto {
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
