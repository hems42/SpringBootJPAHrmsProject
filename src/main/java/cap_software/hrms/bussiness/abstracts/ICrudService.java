package cap_software.hrms.bussiness.abstracts;

import cap_software.hrms.core.utilities.results.Result;

import java.util.List;

public interface ICrudService <T>{

   void add(T t);

   List<T> getAll();

  void update(T t);

  void delete(T t);

  T getById(int id);
}
