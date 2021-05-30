package cap_software.hrms.bussiness.concretes;

import cap_software.hrms.bussiness.abstracts.CompanyService;
import cap_software.hrms.dataAccess.abstracts.CompanyDao;
import cap_software.hrms.entities.concretes.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyManager implements CompanyService {
    @Autowired
    private CompanyDao companyDao;

    @Override
   public List<Company> getAll()
    { return companyDao.findAll();}

    @Override
   public void add(Company company)
   {
       companyDao.save(company);
   }

}
