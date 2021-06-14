package cap_software.hrms.entities.mapstructExams;

import lombok.Data;

@Data
public class ChildDto {

    private  String firstName;
    private  String lastName;
    private int age;
    private Parent parent;
}
