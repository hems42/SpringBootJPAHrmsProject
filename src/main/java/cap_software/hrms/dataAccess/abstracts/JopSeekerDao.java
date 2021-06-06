package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.entities.concretes.users.JopSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JopSeekerDao extends JpaRepository<JopSeeker,Integer> {

  /*
    Product getByProductName(String productName);

	Product getByProductNameAndCategoryId_categoryId(String productName, int categoryId);

	List<Product> getByProductNameOrCategoryId(String productName, int categoryId);

	List<Product> getByCategoryIdIn(List<Integer> categories);

	List<Product> getByProductNameContains(String productName);

	List<Product> getByProductNameStartsWith(String productName);

	List<Product> getByProductNameEndsWith(String productName);

	@Query("From Product where productName=:productName and categoryId=:categoryId")
	List<Product> getByNameAndCategory(String  productName, int categoryId);
    * */

}
