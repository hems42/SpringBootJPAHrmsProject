package cap_software.hrms.api.abstracts;

import cap_software.hrms.core.utilities.results.Result;

import java.util.List;

public interface ICrudController <T>{

    Result add(T t);
    List<T> getAll();
    Result update(T t);
    Result delete(T t);
    T getById(int id);
}
