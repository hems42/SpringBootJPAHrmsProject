package cap_software.hrms.bussiness.abstracts;

import cap_software.hrms.entities.concretes.users.JopSeeker;

import java.util.List;

public interface JopSeekerService {

    void add(JopSeeker jopSeeker);

    List<JopSeeker> getAll();

    JopSeeker findById(int id);

}
