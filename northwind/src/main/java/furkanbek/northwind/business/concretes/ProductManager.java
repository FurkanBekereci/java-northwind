package furkanbek.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import furkanbek.northwind.business.abstracts.ProductService;
import furkanbek.northwind.core.utilities.results.DataResult;
import furkanbek.northwind.core.utilities.results.Result;
import furkanbek.northwind.core.utilities.results.SuccessDataResult;
import furkanbek.northwind.core.utilities.results.SuccessResult;
import furkanbek.northwind.dataAccess.abstracts.ProductDao;
import furkanbek.northwind.entities.concretes.Product;
import furkanbek.northwind.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService{

	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Ürünler listelendi");
	}

	@Override
	public Result add(Product product) {
		// TODO Auto-generated method stub
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi.");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName));
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Ürünler listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Ürünler listelendi");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIn(categories),"Ürünler listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),"Ürünler listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),"Ürünler listelendi");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategoryId(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName, categoryId),"Ürünler listelendi");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent() ,"Ürünler listelendi");
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		// TODO Auto-generated method stub
		Sort sort = Sort.by(Sort.Direction.DESC,"productName"); 
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort) ,"Ürünler listelendi");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails() ,"Ürünler listelendi");
	}

}
