package cap_software.hrms.entities.mapstructExams;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Child {

    private  String name;
    private  String surname;
    private int age;
    private Parent parent;

}
