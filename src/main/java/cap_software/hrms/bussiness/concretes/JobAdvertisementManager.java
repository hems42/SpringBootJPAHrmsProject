package cap_software.hrms.bussiness.concretes;

import cap_software.hrms.bussiness.abstracts.JopAdvertisementSevice;
import cap_software.hrms.dataAccess.abstracts.JopAdvertisementDao;
import cap_software.hrms.entities.concretes.JopAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JopAdvertisementSevice {


    @Autowired
    private JopAdvertisementDao  jopAdvertisementDao;


    @Override
    public void add(JopAdvertisement jopAdvertisement) {
        jopAdvertisementDao.save(jopAdvertisement);
    }

    @Override
    public List<JopAdvertisement> getAll() {
        return jopAdvertisementDao.findAll();
    }

    @Override
    public void update(JopAdvertisement jopAdvertisement) {

        jopAdvertisementDao.save(jopAdvertisement);

    }

    @Override
    public void delete(JopAdvertisement jopAdvertisement) {

        jopAdvertisementDao.delete(jopAdvertisement);
    }

    @Override
    public JopAdvertisement getById(int id) {
        return jopAdvertisementDao.findById(id).get();
    }


    /*
    * 		@Override
	public Result add(Product product) {
		this.productDao.save(product);

		return new Result(true,"veri ekleme başarılı");
	}




	@Override
	public DataResult<List<Product>> getAll() {


		//return productDao.findAll();

		return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"veri gönderme başarılı");

	}


	@Override
	public DataResult<List<Product>> getAllByPage(int pageNo, int pageSize) {

		Pageable pageable=PageRequest.of(pageNo, pageSize);

		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent(),"veri gönderme başarılı");
	}



	@Override
	public DataResult<List<Product>> getAllSortedDesc() {

		Sort sort=Sort.by(Sort.Direction.DESC,"productName");



		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort),"veri gönderme başarılı");
	}



	@Override
	public DataResult<Product> getByProductName(String productName) {

		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"veri getirme başarılı");
	}




	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {

		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategoryId_categoryId(productName, categoryId),"veri getirme kategory ve ürün isim başarılı");
	}




	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {

		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategoryId(productName, categoryId),"veri getirme kategori or ürün ismi başarılı");
	}




	@Override
	public DataResult<List<Product>> getByProductCategoryIdIn(List<Integer> categories) {

		return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIdIn(categories),"veri listeleme başarılı");
	}




	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {

		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),"veri getirmeb contain başarılı");
	}




	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {

		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),"veri getirme startwith başarılı");
	}




	@Override
	public DataResult<List<Product>> getByProductNameEndsWith(String productName) {

		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameEndsWith(productName),"veri getirmerme end with başarılı");
	}




	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {

		return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName, categoryId),"veri getirme başarılı");
	}



*/
}

