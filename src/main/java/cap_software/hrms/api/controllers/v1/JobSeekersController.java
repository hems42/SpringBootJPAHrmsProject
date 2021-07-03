package cap_software.hrms.api.controllers.v1;


import cap_software.hrms.bussiness.JopSeekerService;
import cap_software.hrms.core.dtoRequestes.createRequest.CreateJopSeekerRequest;
import cap_software.hrms.core.dtoRequestes.updateRequest.UpdateJopSeekerRequest;
import cap_software.hrms.core.dtoRequestes.updateRequest.UpdatePersonalInformationRequest;
import cap_software.hrms.core.utilities.results.DataResult;
import cap_software.hrms.core.dto.userDtos.JopSeekerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/jopseekers")
public class JobSeekersController {


    private final JopSeekerService jopSeekerService;

    public JobSeekersController(JopSeekerService jopSeekerService) {
        this.jopSeekerService = jopSeekerService;
    }


    @PostMapping
    public ResponseEntity<DataResult<JopSeekerDto>> createJopSeeker(
            @Valid @RequestBody CreateJopSeekerRequest createJopSeekerRequest) {


        return ResponseEntity.ok(jopSeekerService.createJopSeeker(createJopSeekerRequest));
    }

    @GetMapping("/getJopSeekerById{id}")
    public ResponseEntity<DataResult<JopSeekerDto>> getJopSeekerById(@PathVariable String id) {
        return ResponseEntity.ok(jopSeekerService.getJopSeekerById(id));
    }


    @GetMapping("/getAllJopSeekers")
    public ResponseEntity<DataResult<List<JopSeekerDto>>> getAllJopSeekers() {
        return ResponseEntity.ok(jopSeekerService.getAllJobSeekers());
    }


    @PutMapping("/updateJopSeekerById{id}")
    public ResponseEntity<DataResult<JopSeekerDto>> updateJopSeekerById(@PathVariable String id,
                                                                        @RequestBody UpdateJopSeekerRequest updateJopSeekerRequest) {
        return ResponseEntity.ok(jopSeekerService.updateJopSeekerById(id, updateJopSeekerRequest));
    }

    @PutMapping("/updateJopSeekerPersonalInformationById{id}")
    public ResponseEntity<DataResult<JopSeekerDto>> updateJopSeekerPersonalInformationById(@PathVariable String id,
                                                                                           @RequestBody UpdatePersonalInformationRequest personalInformationRequest) {
        return ResponseEntity.ok(jopSeekerService.updateJopSeekerPersonalInformationById(id, personalInformationRequest));
    }

    @PutMapping("/updateActiveJopSeekerById{id}")
    public ResponseEntity<DataResult<Boolean>> updateActiveJopSeekerById(@PathVariable String id,
                                                                         @RequestParam Boolean isActive) {
        return ResponseEntity.ok(jopSeekerService.updateActiveJopSeekerById(id, isActive));
    }

    @PatchMapping("/deleteJopSeekerById{id}")
    public ResponseEntity<DataResult<Boolean>> deleteJopSeekerById(@PathVariable String id) {
        return ResponseEntity.ok(jopSeekerService.deleteJopSeekerById(id));
    }


}
