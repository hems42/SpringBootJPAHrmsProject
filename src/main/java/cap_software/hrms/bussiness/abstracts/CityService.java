package cap_software.hrms.bussiness.abstracts;

import cap_software.hrms.core.utilities.results.DataResult;
import cap_software.hrms.entities.concretes.utils.City;

import java.util.List;

public interface CityService {

    DataResult<List<City>> getAll();
}
