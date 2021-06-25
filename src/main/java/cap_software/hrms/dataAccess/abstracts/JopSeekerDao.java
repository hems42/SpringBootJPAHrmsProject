package cap_software.hrms.dataAccess.abstracts;

import cap_software.hrms.entities.concretes.contacts.PersonalInformation;
import cap_software.hrms.entities.concretes.users.JopSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

public interface JopSeekerDao extends JpaRepository<JopSeeker,Integer> {

    @Transactional
    @Modifying
    @Query(value = "update PersonalInformation  j set j:personalInformation where j.id=:id",nativeQuery = true)
    void updatePersonalInformation(@Param(value = "id") int id,@RequestBody PersonalInformation personalInformation);

  /*

  @Query("update Customer u set u.phone = :phone where u.id = :id")
void updatePhone(@Param(value = "id") long id, @Param(value = "phone") String phone);

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
