package cap_software.hrms.bussiness.abstracts;


import cap_software.hrms.entities.concretes.Company;

import java.util.List;

public interface CompanyService  {

    List<Company> getAll();

    void add(Company company);
}
