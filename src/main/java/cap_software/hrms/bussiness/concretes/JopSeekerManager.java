package cap_software.hrms.bussiness.concretes;

import cap_software.hrms.bussiness.abstracts.JopSeekerService;
import cap_software.hrms.dataAccess.abstracts.JopSeekerDao;
import cap_software.hrms.entities.concretes.users.JopSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JopSeekerManager implements JopSeekerService {

    @Autowired
    private  JopSeekerDao  jopSeekerDao;


    @Override
    public void add(JopSeeker jopSeeker) {
        jopSeekerDao.save(jopSeeker);
    }

    @Override
    public List<JopSeeker> getAll() {
        return jopSeekerDao.findAll();
    }

    @Override
    public void update(JopSeeker jopSeeker) {
        jopSeekerDao.save(jopSeeker);

    }

    @Override
    public void delete(JopSeeker jopSeeker) {
   jopSeekerDao.delete(jopSeeker);
    }

    @Override
    public JopSeeker getById(int id) {
        return jopSeekerDao.findById(id).get();
    }
}
