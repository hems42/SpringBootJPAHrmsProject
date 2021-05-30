package cap_software.hrms.bussiness.concretes;

import cap_software.hrms.bussiness.abstracts.CityService;
import cap_software.hrms.core.utilities.results.DataResult;
import cap_software.hrms.core.utilities.results.SuccessDataResult;
import cap_software.hrms.dataAccess.abstracts.CityDao;
import cap_software.hrms.entities.concretes.utils.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    @Autowired
    private CityDao  cityDao;


    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<>(cityDao.findAll(),"Şehirler Başarıyla Getirilmiştir");
    }
}
