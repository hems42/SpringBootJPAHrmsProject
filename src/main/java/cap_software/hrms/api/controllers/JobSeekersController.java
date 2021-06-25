package cap_software.hrms.api.controllers;

import cap_software.hrms.bussiness.abstracts.JopSeekerService;
import cap_software.hrms.core.utilities.results.ErrorDataResult;
import cap_software.hrms.core.dto.contactDtos.PersonalInformationDto;
import cap_software.hrms.core.dto.userDtos.JopSeekerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {

    @Autowired
    private JopSeekerService jopSeekerService;

    @PostMapping(value = "add")
    public ResponseEntity<?> add(@Valid @RequestBody JopSeekerDto jobSeekerDto) {


        return ResponseEntity.ok(jopSeekerService.addJopSeeker(jobSeekerDto));
    }


    @GetMapping("getAll")
    public ResponseEntity<?> getAll()
    {
        return ResponseEntity.ok(jopSeekerService.getAllJobSeekers());
    }


    @PostMapping("update")
     public ResponseEntity<?> updatePersonalInformation(@RequestBody JopSeekerDto jopSeekerDto)
    {
        return  ResponseEntity.ok(jopSeekerService.update(jopSeekerDto));
    }


    @PostMapping("updateById")
    public ResponseEntity<?> updatePersonalInformation(@RequestParam int id,@RequestBody PersonalInformationDto personalInformationDto)
    {
        return  ResponseEntity.ok(jopSeekerService.update(id,personalInformationDto));
    }





















    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();

        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {

            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }


        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama Hataları");

        return errors;
    }

}
