package cap_software.hrms.api.controllers.v1;


import cap_software.hrms.bussiness.JopSeekerService;
import cap_software.hrms.core.dtoRequestes.createRequest.CreateJopSeekerRequest;
import cap_software.hrms.core.dtoRequestes.updateRequest.UpdateJopSeekerRequest;
import cap_software.hrms.core.utilities.results.DataResult;
import cap_software.hrms.core.utilities.results.ErrorDataResult;
import cap_software.hrms.core.dto.userDtos.JopSeekerDto;
import cap_software.hrms.entities.users.JopSeeker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/jobseekers")
public class JobSeekersController {


    private final JopSeekerService jopSeekerService;

    public JobSeekersController(JopSeekerService jopSeekerService)
    {
        this.jopSeekerService = jopSeekerService;
    }


    @GetMapping
    public ResponseEntity<DataResult<List<JopSeeker>>> getAllJopSeekers()
    {
        return ResponseEntity.ok(jopSeekerService.getAllJobSeekers());
    }


    @PostMapping
    public ResponseEntity<DataResult<JopSeekerDto>> createJopSeeker(@Valid @RequestBody CreateJopSeekerRequest createJopSeekerRequest)
    {


        return ResponseEntity.ok(jopSeekerService.createJopSeeker(createJopSeekerRequest));
    }


    @PutMapping("{id}")
    public ResponseEntity<JopSeeker> updateJopSeeker(@RequestParam Integer id,
                                                     @RequestBody UpdateJopSeekerRequest updateJopSeekerRequest)
    {
        //return  ResponseEntity.ok(jopSeekerService.update(id,personalInformationDto));
        return ResponseEntity.ok(new JopSeeker());
    }


    @PatchMapping("{id}")
    public ResponseEntity<Void> deleteJopSeeker(@PathVariable("id") Integer id) {

        return ResponseEntity.ok().build();
    }


/*    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();

        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {

            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }


        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama Hataları");

        return errors;
    }*/

}
