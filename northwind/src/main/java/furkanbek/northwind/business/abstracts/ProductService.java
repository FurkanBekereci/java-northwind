package furkanbek.northwind.business.abstracts;

import java.util.List;

import furkanbek.northwind.core.utilities.results.DataResult;
import furkanbek.northwind.core.utilities.results.Result;
import furkanbek.northwind.entities.concretes.Product;
import furkanbek.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	
	DataResult<List<Product>> getAll();
	
	DataResult<List<Product>> getAll(int pageNo, int pageSize);
	
	DataResult<List<Product>> getAllSorted();
	
	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
	
	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
	
	DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
	
	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);

	DataResult<List<Product>> getByNameAndCategoryId(String productName,int categoryId);
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
