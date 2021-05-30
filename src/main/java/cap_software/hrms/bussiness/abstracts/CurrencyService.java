package cap_software.hrms.bussiness.abstracts;

import cap_software.hrms.entities.concretes.utils.Currency;

import java.util.List;

public interface CurrencyService {
    List<Currency> getAll();
    void add(Currency currency);

}
