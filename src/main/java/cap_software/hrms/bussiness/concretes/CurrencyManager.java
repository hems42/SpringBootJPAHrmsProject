package cap_software.hrms.bussiness.concretes;

import cap_software.hrms.bussiness.abstracts.CurrencyService;
import cap_software.hrms.dataAccess.abstracts.CurrenyDao;
import cap_software.hrms.entities.concretes.utils.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyManager implements CurrencyService {

    @Autowired
    private CurrenyDao currenyDao;

    @Override
    public List<Currency> getAll() {
        return currenyDao.findAll();
    }

    @Override
    public void add(Currency currency) {

        currenyDao.save(currency);
    }
}
