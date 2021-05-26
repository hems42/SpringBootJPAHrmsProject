package cap_software.hrms.bussiness.concretes;

import cap_software.hrms.bussiness.abstracts.JopPositionService;
import cap_software.hrms.dataAccess.abstracts.JopPositionDao;
import cap_software.hrms.entities.concretes.JopPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JopPositionManager implements JopPositionService {

    @Autowired
    JopPositionDao jopPositionDao;
    @Override
    public void add(JopPosition jopPosition) {
        jopPositionDao.save(jopPosition);
    }

    @Override
    public List<JopPosition> getAll() {
        return jopPositionDao.findAll();
    }

    @Override
    public void update(JopPosition jopPosition) {
        jopPositionDao.save(jopPosition);

    }

    @Override
    public void delete(JopPosition jopPosition) {
        jopPositionDao.delete(jopPosition);

    }

    @Override
    public JopPosition getById(int id) {
        return jopPositionDao.findById(id).get();
    }
}
