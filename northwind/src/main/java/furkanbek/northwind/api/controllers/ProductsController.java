package furkanbek.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import furkanbek.northwind.business.abstracts.ProductService;
import furkanbek.northwind.core.utilities.results.DataResult;
import furkanbek.northwind.core.utilities.results.Result;
import furkanbek.northwind.entities.concretes.Product;
import furkanbek.northwind.entities.dtos.ProductWithCategoryDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}


	@GetMapping("/getAll")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product){
		return this.productService.add(product);
	}
	
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameAndCategoryId(productName,categoryId);
	}
	
	@GetMapping("/getByProductNameOrCategoryId")
	public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
		return this.productService.getByProductNameOrCategoryId(productName,categoryId);
	}
	@GetMapping("/getByCategoryIn")
	public DataResult<List<Product>> getByCategoryIn(@RequestBody List<Integer> categories){
		return this.productService.getByCategoryIn(categories);
	}
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam("productName") String productName){
		return this.productService.getByProductNameContains(productName);
	}
	@GetMapping("/getByProductNameStartsWith")
	public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam("productName") String productName){
		return this.productService.getByProductNameStartsWith(productName);
	}
	@GetMapping("/getByNameAndCategoryId")
	public DataResult<List<Product>> getByNameAndCategoryId(@RequestParam("productName") String productName , @RequestParam("categoryId") int categoryId){
		return this.productService.getByNameAndCategoryId(productName,categoryId);
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAllByPAge(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize){
		return this.productService.getAll(pageNo,pageSize);
	}
	
	@GetMapping("/getAllSorted")
	public DataResult<List<Product>> getAllSorted(){
		return this.productService.getAllSorted();
	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productService.getProductWithCategoryDetails();
	}
}
